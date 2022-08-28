
DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), price INTEGER);
INSERT INTO products (title, price) VALUES ('lemon', 10), ('bread', 15), ('milk', 20), ('apple', 100);



DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES ('bob'),('jack'),('john'),('bill');
