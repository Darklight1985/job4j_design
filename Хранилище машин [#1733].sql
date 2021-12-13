create table body(
id serial primary key,
	name varchar(255)
);

create table engine(
id serial primary key,
	name varchar(255)
);

create table gearbox(
id serial primary key,
	name varchar(255)
);

create table cars(
id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

insert into body(name) values ('B215'), ('B728'), ('B436'), ('B567'), ('B122'); 
insert into engine(name) values ('E225'), ('E778'), ('E136'), ('E467'), ('E125'); 
insert into gearbox(name) values ('G225'), ('G778'), ('G136'), ('G467'), ('G125'); 

insert into cars(name, body_id, engine_id, gearbox_id) values ('Lada', 1, 3, 5), ('Toyota', 2, 2, 4), ('BMW', 3, 1, 3), ('Opel', 5, 2, 1);

select * from cars as c
join body as b
on c.body_id = b.id
join engine as e
on c.engine_id = e.id
join gearbox as g
on c.gearbox_id = g.id;

select * from cars c 
right join body b on c.body_id=b.id
where c.id is null;

select * from cars c
right join engine e on c.engine_id=e.id
where c.id is null;

select * from cars c
right join gearbox g on c.gearbox_id=g.id
where c.id is null
; 
