package com.example.alfin_java_test.dto;

import lombok.Data;

@Data
public class CambioResponse {
    private double montoOriginal;
    private double montoConvertido;
    private double tipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
}
