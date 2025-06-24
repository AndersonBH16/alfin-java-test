package com.example.alfin_java_test.dto;

import lombok.Data;

@Data
public class CambioRequest {
    private String monedaOrigen;
    private String monedaDestino;
    private double monto;
}
