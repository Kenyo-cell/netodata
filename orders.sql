CREATE TABLE IF NOT EXISTS ORDERS (
    "id" serial PRIMARY KEY,
    "date" date DEFAULT NOW(),
    "customer_id" integer NOT NULL,
    "product_name" text,
    "amount" float4,
    CONSTRAINT customer_id_fk
        FOREIGN KEY (customer_id)
        REFERENCES CUSTOMERS("id")
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


insert into ORDERS (customer_id, product_name) values
(1, 'Boots'), (2, 'T-Shirt'), (3, 'Phone');