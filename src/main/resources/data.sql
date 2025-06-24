CREATE TABLE tipo_cambio (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     moneda_origen VARCHAR(10),
     moneda_destino VARCHAR(10),
     tipo_cambio DOUBLE
);

INSERT INTO tipo_cambio (moneda_origen, moneda_destino, tipo_cambio) VALUES ('USD', 'PEN', 3.6);
INSERT INTO tipo_cambio (moneda_origen, moneda_destino, tipo_cambio) VALUES ('PEN', 'USD', 0.27);
