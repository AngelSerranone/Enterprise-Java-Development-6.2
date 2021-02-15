drop schema if exists book_format;
create schema book_format;
use book_format;

CREATE TABLE book_format (
formats VARCHAR(255)
CONSTRAINT CHECK (formats IN ('HARDCOVER','PAPERBACK','ELECTRONIC','AUDIO')),
isbn VARCHAR(255),
PRIMARY KEY (isbn, formats)
);

insert into book_format (formats, isbn) values ("HARDCOVER", "123abc");

drop schema if exists book;
create schema book;
use book;

CREATE TABLE book (
isbn VARCHAR(255),
title VARCHAR(255),
author VARCHAR(255),
genre VARCHAR(255),
PRIMARY KEY (isbn)
);

insert into book (isbn, title, author, genre) values ("123abc", "Carapusculo", "yoquese", "mierder");

drop schema if exists product;
create schema product;
use product;

CREATE TABLE product (
product_id INT AUTO_INCREMENT,
product_name VARCHAR(255),
product_price DOUBLE,
inventory_count INT,
PRIMARY KEY (product_id)
);

insert into product (product_id, product_name, product_price, inventory_count) values (1, "chuches", 5.0, 300);

drop schema if exists shipping_order;
create schema shipping_order;
use shipping_order;

CREATE TABLE shipping_order (
order_id INT,
product_id INT,
quantity INT,
PRIMARY KEY (order_id)
);

insert into shipping_order (order_id, product_id, quantity) values (1, 1, 30);






