create table cars(id serial primary key, model varchar(255), power integer, crushed boolean);
insert into cars(model, power, crushed) values('Logan', 100, false);
select * from cars;
update cars set model = 'Lanos';
select * from cars;
delete from cars;
select * from cars;