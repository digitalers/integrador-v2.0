use banco;
insert into cliente(dni,nombre,apellido,calle,altura,
barrio,ciudad,provincia,codigo_postal, email, telefono) values("345656",
"carina","gomez","cabral",234,"las palmas","fsa","fsa", "4454","cari@mail.com",343434);
select * from cliente;

insert into cuenta(saldo,tipo_cuenta, adicional,cliente_idcliente )values(4000,'cuenta_corriente','limite_descub',1);

select * from cuenta;


insert into cliente(dni,nombre,apellido,calle,altura,
barrio,ciudad,provincia,codigo_postal, email, telefono) values("378345",
"carolina","goez","cuellar",200,"calas","formosa","formosa", "3411","car0@mail.com",1536787);

select * from transacciones;

insert into transacciones(tipo_transaccion, fecha_y_hora, monto, cuenta_origen, cuenta_destino,
cuenta_idcuenta, cuenta_cliente_idcliente) values('deposito', '2023-09-10 10:34:09',
20000,1, 324, 1,1);


insert into transacciones(tipo_transaccion, monto, cuenta_origen, cuenta_destino,
cuenta_idcuenta, cuenta_cliente_idcliente) values('deposito', 
25000,1, 3264, 1,1);


UPDATE cuenta set saldo=5000 where tipo_cuenta= 'cuenta_corriente' and cliente_idcliente =10;


SELECT   cliente.dni, cuenta.saldo, cuenta.tipo_cuenta
FROM cuenta
inner JOIN cliente ON cuenta.cliente_idcliente=cliente.idcliente WHERE cliente.dni='1110';

SELECT cliente.dni, cuenta.saldo as saldo, cuenta.tipo_cuenta as tipo FROM cuenta inner JOIN cliente ON cuenta.cliente_idcliente=cliente.idcliente WHERE dni='1110';

delete from transacciones where cliente_idcliente = 1;

SELECT  cliente.dni ,cuenta.tipo_cuenta , cuenta.saldo  FROM cuenta inner JOIN cliente ON cuenta.cliente_idcliente=cliente.idcliente WHERE dni='1110';

SELECT cliente.dni, transacciones.idtransacciones, transacciones.tipo_transaccion,
transacciones.fecha_y_hora, transacciones.monto, transacciones.cuenta_origen, transacciones.cuenta_destino FROM transacciones
INNER JOIN cliente  on transacciones.cuenta_cliente_idcliente= idcliente
 WHERE dni='11';