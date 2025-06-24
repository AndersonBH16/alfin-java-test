package com.example.alfin_java_test.config;

import com.example.alfin_java_test.model.TipoCambio;
import com.example.alfin_java_test.repository.TipoCambioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final TipoCambioRepository repository;

    @PostConstruct
    public void initData() {

        repository.deleteAll().thenMany(
                Flux.just(
                            new TipoCambio(null, "USD", "PEN", 3.6),
                            new TipoCambio(null, "PEN", "USD", 0.27)
                        )
                        .flatMap(repository::save)
        ).subscribe(
                saved -> System.out.println("Insertado: " + saved),
                err -> System.err.println("Error al insertar: " + err.getMessage()),
                () -> System.out.println("Carga inicial completada.")
        );
    }
}
