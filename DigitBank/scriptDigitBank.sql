create table if not exists cuenta
(
    ID                  int auto_increment
        primary key,
    TIPO                varchar(20) null,
    SALDO               double      null,
    LIMITEDEDESCUBIERTO double      null,
    TASADEINTERES       double      not null
);

create table if not exists cliente
(
    ID             int auto_increment
        primary key,
    NOMBRECOMPLETO varchar(30) null,
    DNI            varchar(15) null,
    DIRECCION      varchar(25) null,
    TELEFONO       varchar(25) null,
    EMAIL          varchar(25) null,
    CUENTA         int         null,
    constraint CUENTA
        foreign key (CUENTA) references cuenta (ID)
            on update cascade on delete cascade
);

create index CUENTA_idx
    on cliente (CUENTA);

create table if not exists movimiento
(
    ID                  int auto_increment
        primary key,
    FECHAHORAMOVIMIENTO datetime    null,
    TIPOMOVIMIENTO      varchar(20) null,
    MONTO               double      null,
    CUENTAORIGEN_ID     int         null,
    CUENTADESTINO_ID    int         null,
    constraint CUENTADESTINO_ID
        foreign key (CUENTADESTINO_ID) references cliente (ID)
            on update cascade on delete cascade,
    constraint CUENTAORIGEN_ID
        foreign key (CUENTAORIGEN_ID) references cuenta (ID)
);

create index CUENTADESTINO_ID_idx
    on movimiento (CUENTADESTINO_ID);

create index CUENTAORIGEN_ID_idx
    on movimiento (CUENTAORIGEN_ID);


