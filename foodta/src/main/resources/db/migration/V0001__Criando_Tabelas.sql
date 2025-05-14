create table cozinha(
    id bigint not null auto_increment,
    nome_cozinha varchar(50),

    primary key(id)
) engine=InnoDB default charset=utf8;

create table formaPagamento(
    id bigint not null auto_increment,
    descricaoForma varchar,

    primary key(id);
) engine=InnoDB default charset=utf8;

create table estado(
    int bigint not null auto_increment,
    nome varchar(50),

    primary key(id)
) engine=InnoDB default charset=utf8;

create table restaurante(
    id bigint not null auto_increment,
    nome varchar,
    taxa_frete decimal(12,2),
    cozinha_id bigint not null,

    primary key(id)
) engine=InnoDB default charset=utf8;

create table cidade(
    id bigint not null auto_increment,
    nome varchar,
    estado_id bigint not null,

    primary key(id)
) engine=InnoDB default charset=utf8;

alter table cidade add constraint fk_cidade_estado foreign key estado_id references estado(id);
alter table restaurante add constaint fk_restaurante_cozinha foreign key cozinha_id references restaurante(id);
