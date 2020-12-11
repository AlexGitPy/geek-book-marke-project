-- create table categories (id bigserial primary key, title varchar(255));
-- insert into categories (title)
-- values
-- ('Food'),
-- ('Electronic');
--
-- create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
-- insert into products (title, price, category_id)
-- values
-- ('Milk', 95, 1),
-- ('Bread', 25, 1),
-- ('Cheese', 360, 1);

create table authors (id bigserial primary key, title varchar (255));
insert into authors (title)
values
('Vonnegut'),
('Dostoevsky');

create table books (id bigserial primary key, title varchar (255), price int, authors_id bigint references authors (id));
insert into books (title, price, authors_id)
values
('Slaughterhouse-Five', 200, 1),
('Crime and Punishment', 250, 2);

