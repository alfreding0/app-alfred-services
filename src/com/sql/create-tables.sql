/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alfreding0
 * Created: Jul 15, 2022
 */

--DATABASE IN POSTGRESQL
--CREATE DATABASE db_alfred_services;

create table personals(
    id serial primary key,
    ci varchar(12) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone varchar(20) not null,
    address varchar(150) not null,
    birthday date not null,
    created_at timestamp default now(),
    updated_at timestamp default now()
);

create table customers(
    id serial primary key,
    ci varchar(12) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone varchar(20) not null,
    created_at timestamp default now(),
    updated_at timestamp default now()
);

create table users(
    id serial primary key,
    name varchar(50) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),

    personal_id int not null,
    foreign key (personal_id) references personals (id)
        on update cascade on delete cascade
);

create table sales(
    id serial primary key,
    date_time timestamp not null,
    total float not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),

    customer_id int not null,
    foreign key (customer_id) references customers (id)
        on update cascade on delete cascade,

    personal_id int not null,
    foreign key (personal_id) references personals (id)
        on update cascade on delete cascade
);

create table services(
    id serial primary key,
    name varchar(100) not null,
    description varchar(300),
    price float not null,
    created_at timestamp default now(),
    updated_at timestamp default now()
);

create table sales_services(
    id serial primary key,
    number_days int not null,
    final_price float not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),

    sale_id int not null,
    foreign key (sale_id) references sales (id)
        on update cascade on delete cascade,

    service_id int not null,
    foreign key (service_id) references services (id)
        on update cascade on delete cascade
);