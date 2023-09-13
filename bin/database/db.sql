CREATE DATABASE IF NOT EXISTS simulador_banco;

USE simulador_banco;

DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS cuentas;
DROP TABLE IF EXISTS transacciones;

CREATE TABLE IF NOT EXISTS clientes (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(32) NOT NULL,
    apellido varchar(32) NOT NULL,
    dni varchar(32) NOT NULL,
    direccion varchar(72) NOT NULL,
    telefono varchar(56) NOT NULL,
    email varchar(56) NOT NULL
);

CREATE TABLE IF NOT EXISTS cuentas (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cliente_id int NOT NULL UNIQUE KEY,
    numero varchar(255) NOT NULL,
    saldo int NOT NULL DEFAULT 0,
    titular varchar(56) NOT NULL,
    tasa_de_interes int(2) NULL,
    limite_de_dinero int(6) NULL,
    tipo_de_cuenta VARCHAR(12) NOT NULL 
);

CREATE TABLE IF NOT EXISTS transacciones (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    fecha varchar(12) NOT NULL,
    hora varchar(12) NOT NULL,
    tipo varchar(32) NOT NULL,
    id_cliente int NOT NULL,
    id_cuenta int NOT NULL,
    monto int NOT NULL,

    CONSTRAINT FOREIGN KEY(id_cliente) REFERENCES clientes(id),
    CONSTRAINT FOREIGN KEY(id_cuenta) REFERENCES cuentas(id)
);