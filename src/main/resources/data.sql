CREATE TABLE IF NOT EXISTS tipo_cambio (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    moneda_origen VARCHAR(10),
    moneda_destino VARCHAR(10),
    tipo_cambio DOUBLE
);

CREATE TABLE IF NOT EXISTS auditoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(100),
    moneda_origen VARCHAR(10),
    moneda_destino VARCHAR(10),
    monto DOUBLE,
    monto_convertido DOUBLE,
    tipo_cambio DOUBLE,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tipo_cambio (moneda_origen, moneda_destino, tipo_cambio) VALUES ('USD', 'PEN', 3.6);
INSERT INTO tipo_cambio (moneda_origen, moneda_destino, tipo_cambio) VALUES ('PEN', 'USD', 0.27);
