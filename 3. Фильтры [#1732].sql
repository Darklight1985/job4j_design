create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
	expired_data date,
	price float
);

insert into type (name) values ('СЫР'), ('МОЛОКО'), ('ШОКОЛАД'), ('МОРОЖЕНОЕ');
insert into product (name, type_id, expired_data, price) values ('Колбасный сыр', 1, '2021-12-31', 500), ('Твердый сыр', 1, '2021-12-09', 300), 
('Сыр моцарелла', 1, '2021-12-25', 600);
insert into product (name, type_id, expired_data, price) values ('Фруктовое молоко', 2, '2021-12-30', 200), ('Коровье молоко', 2, '2021-12-29', 120), 
('Шоколадное молоко', 2, '2021-12-22', 150);
insert into product (name, type_id, expired_data, price) values ('Белый шоколад', 3, '2022-02-12', 90), ('Горький шоколад', 3, '2022-02-27', 70), 
('Молочный шоколад', 3, '2022-02-03', 100);
insert into product (name, type_id, expired_data, price) values ('Клубничное мороженое', 4, '2021-12-08', 300), ('Сливочное мороженое', 4, '2021-12-06', 270), 
('Ванильное мороженое', 4, '2021-12-02', 350);

select * from product as p
join type as t
on p.type_id = t.id
where t.name like '%СЫР%';

select * from product as p
where p.name like '%мороженое%';

select * from product as p
where p.expired_data < now();

select * from product
where price = (select max(p.price)
from product as p);

select t.name, count(p.type_id)  
from product as p
join type as t
on p.type_id = t.id
group by t.name;

select * from product as p
join type as t
on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(p.type_id)  
from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p.type_id) < 5;

select p.name, t.name  
from product as p
join type as t
on p.type_id = t.id;

