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

insert into personals
(
    ci,
    first_name,
    last_name,
    phone,
    address,
    birthday
)
values 
(
    '893253',
    'Alfredo',
    'Gonzales Quiucha',
    '87934899',
    'Camiri City #25',
    '23-07-2002'
),
(
    '63234',
    'Yessica',
    'Albornoz Cuellar',
    '86879990',
    'Av. Rioja #52',
    '13-02-1993'
),
(
    '639234',
    'Esteban',
    'Arueta del Rio',
    '68934332',
    'Av. Bolivar #2',
    '02-02-1995'
);

insert into customers
(
    ci,
    first_name,
    last_name,
    phone
)
values 
(
    '3539988',
    'Ricardo',
    'Llanos Perez',
    '68789344'
),
(
    '6935234',
    'Quimeo',
    'Denavidez',
    '8983444'
),
(
    '92534',
    'Wilder',
    'Jimenez',
    '93533212'
),
(
    '982343',
    'Herbert',
    'Uriquiza',
    '89793434'
);

insert into users(
    name,
    email,
    password,
    personal_id
)
values
(
    'alfreding0',
    'alfreding0@gmail.com',
    md5('alfreding0pass'),
    1
),
(
    'yessica',
    'yessica@gmail.com',
    md5('yessicapass'),
    3
);

insert into services(
    name,
    description,
    price
)
values
(
    'Windows Maintenance',
    'Without description',
    '35.53'
),
(
    'Linux Maintenance',
    'Without description',
    '130.51'
),
(
    'Laravel Support',
    'Without description',
    '90.00'
),
(
    'Java Support',
    'Without description',
    '63.29'
);