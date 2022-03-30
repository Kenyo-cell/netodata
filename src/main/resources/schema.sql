CREATE TABLE IF NOT EXISTS CUSTOMERS (
         "id" serial PRIMARY KEY,
         "name" varchar,
         "surname" varchar,
         "age" smallint,
         "phone_number" char(11)
);

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