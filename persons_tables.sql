CREATE TABLE IF NOT EXISTS PERSONS(
  "name" varchar,
  "surname" varchar,
  "age" smallint,
  "phone_number" char(11),
  "city_of_living" varchar,
  PRIMARY KEY ("name", "surname", "age")
);

insert into persons (name, surname, age, phone_number, city_of_living) VALUES
    ('Josh', 'Johnson', 30, '34445667872', 'MINSK'),
    ('Helga', 'Arigashi', 25, '89225446787', 'MOSCOW'),
    ('Yuriy', 'Sokolov', 23, '89441233221', 'VORONEZH'),
    ('Helen', 'Nekolskiy', 35, '65551245221', 'PRAGUE');
