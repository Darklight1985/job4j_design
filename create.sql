create table role (
    id serial primary key, 
    name varchar(255)
);

create table users (
    id serial primary key, 
    name varchar(255),
	role_id int references role(id)
);

create table rules (
    id serial primary key, 
    name varchar(255)
);

create table role_rules (
    id serial primary key, 
    role_id int,
	rules_id int
);

create table category (
    id serial primary key, 
    name varchar(255)
);

create table state (
    id serial primary key, 
    accepted boolean
);

create table item (
    id serial primary key, 
    users_id int references users(id),
	category_id int references category(id)
);

create table comments (
    id serial primary key, 
	description text,
    item_id int references item(id)
);

create table attachs (
    id serial primary key, 
    name varchar(255),
	item_id int references item(id)
);