package com.example.alfin_java_test.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("auditoria")
public class Auditoria {

    @Id
    private Long id;
    private String usuario;
    private String monedaOrigen;
    private String monedaDestino;
    private double monto;
    private double montoConvertido;
    private double tipoCambio;
    private LocalDateTime fecha;
}
