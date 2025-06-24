package com.example.alfin_java_test.controller;

import com.example.alfin_java_test.dto.CambioRequest;
import com.example.alfin_java_test.dto.CambioResponse;
import com.example.alfin_java_test.model.TipoCambio;
import com.example.alfin_java_test.repository.TipoCambioRepository;
import com.example.alfin_java_test.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.alfin_java_test.model.Auditoria;
import com.example.alfin_java_test.repository.AuditoriaRepository;

import java.security.Principal;

@RestController
@RequestMapping("/api/tipo-cambio")
@RequiredArgsConstructor
public class TipoCambioController {
    private final TipoCambioRepository repo;
    private final TipoCambioService svc;
    private final AuditoriaRepository auditoriaRepo;

    @PostMapping("/realizar")
    public Mono<CambioResponse> cambiar(@RequestBody CambioRequest req, Principal p) {
        return svc.realizarCambio(req, p.getName());
    }

    @GetMapping
    public Flux<TipoCambio> listar() { return repo.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TipoCambio> crear(@RequestBody TipoCambio tc) {
        return repo.save(tc);
    }

    @PutMapping("/{id}")
    public Mono<TipoCambio> actualizar(@PathVariable Long id, @RequestBody TipoCambio tc) {
        return repo.findById(id)
                .flatMap(existing -> {
                    existing.setMonedaOrigen(tc.getMonedaOrigen());
                    existing.setMonedaDestino(tc.getMonedaDestino());
                    existing.setTipoCambio(tc.getTipoCambio());
                    return repo.save(existing);
                });
    }

    @GetMapping("/auditoria")
    public Flux<Auditoria> listarAuditoria() {
        return auditoriaRepo.findAll();
    }
}
