create table products (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    price_in_cents decimal(10,2),

    primary key(id)
);