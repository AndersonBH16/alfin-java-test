package com.example.alfin_java_test.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("tipo_cambio")
public class TipoCambio {

    @Id
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}
