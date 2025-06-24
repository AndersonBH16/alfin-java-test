package com.example.alfin_java_test.service;

import com.example.alfin_java_test.dto.CambioRequest;
import com.example.alfin_java_test.dto.CambioResponse;
import com.example.alfin_java_test.model.Auditoria;
import com.example.alfin_java_test.repository.AuditoriaRepository;
import com.example.alfin_java_test.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final TipoCambioRepository repository;
    private final AuditoriaRepository auditoriaRepo;

    public Mono<CambioResponse> realizarCambio(CambioRequest req, String usuario) {
        return repository.findByMonedaOrigenAndMonedaDestino(req.getMonedaOrigen(), req.getMonedaDestino())
                .flatMap(tc -> {
                    double conv = req.getMonto() * tc.getTipoCambio();

                    CambioResponse res = new CambioResponse();
                    res.setMontoOriginal(req.getMonto());
                    res.setMontoConvertido(conv);
                    res.setTipoCambio(tc.getTipoCambio());
                    res.setMonedaOrigen(tc.getMonedaOrigen());
                    res.setMonedaDestino(tc.getMonedaDestino());

                    Auditoria aud = new Auditoria();
                    aud.setUsuario(usuario);
                    aud.setMonedaOrigen(tc.getMonedaOrigen());
                    aud.setMonedaDestino(tc.getMonedaDestino());
                    aud.setMonto(req.getMonto());
                    aud.setMontoConvertido(conv);
                    aud.setTipoCambio(tc.getTipoCambio());
                    aud.setFecha(LocalDateTime.now());

                    return auditoriaRepo.save(aud).thenReturn(res);
                });
    }
}
