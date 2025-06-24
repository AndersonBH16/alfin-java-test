package com.example.alfin_java_test.repository;

import com.example.alfin_java_test.model.TipoCambio;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TipoCambioRepository extends ReactiveCrudRepository<TipoCambio, Long> {

    Mono<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
