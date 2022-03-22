CREATE TABLE IF NOT EXISTS CUSTOMERS (
    "id" serial PRIMARY KEY,
    "name" varchar,
    "surname" varchar,
    "age" smallint,
    "phone_number" char(11)
);

insert into CUSTOMERS (name) values ('ALEXEY'), ('alexey'), ('Alexey');