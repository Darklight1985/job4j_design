insert into role(name) values ('artist');

insert into users(name,role_id) values ('Jora',1);

insert into rules(name) values ('general');

insert into role_rules(role_id, rules_id) values (1, 1);

insert into category(name) values ('premier');

insert into state(accepted) values (true);

insert into item(users_id, category_id, state_id) values (1, 1, 1);

insert into comments(description, item_id) values ('very important', 1);

insert into attachs(name, item_id) values ('number 1', 1);