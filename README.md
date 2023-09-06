# Integrador-v2.0
## Segunda entrega del trabajo integrador

### 💠Paradigma Orientado a Objetos.
Diseña una clase abstracta Cuenta que represente una cuenta bancaria con los atributos numero, saldo y titular, y los métodos abstractos depositar y retirar. Luego, crea dos subclases concretas CuentaCorriente y CuentaAhorro que hereden de Cuenta y sobreescriban los métodos abstractos, teniendo en cuenta que la primera tiene un límite de descubierto y la segunda tiene una tasa de interés. Implementa los constructores, getters, setters y toString correspondientes para todas las clases. Finalmente, crea un objeto de tipo CuentaCorriente y otro de tipo CuentaAhorro, y realiza algunas operaciones de depósito y retiro sobre ellos, mostrando el estado de las cuentas después de cada operación.

### 💠 SQL (DML). 
Diseña una base de datos relacional que almacene la información de los clientes, las cuentas y las transacciones de un banco. Crea las tablas correspondientes con sus atributos, claves primarias y claves foráneas. Luego, escribe las sentencias SQL para realizar las siguientes operaciones:
Insertar tres clientes con sus datos personales (nombre, dni, dirección, teléfono, email).
Insertar dos cuentas corrientes y una cuenta ahorro con sus datos (número, saldo, titular, límite de descubierto o tasa de interés).
Insertar cuatro transacciones con sus datos (fecha, hora, tipo, monto, cuenta origen, cuenta destino).
Actualizar el saldo de las cuentas involucradas en las transacciones.
Eliminar una cuenta que no tenga transacciones asociadas.
Consultar el saldo y el tipo de cuenta de un cliente dado su dni.
