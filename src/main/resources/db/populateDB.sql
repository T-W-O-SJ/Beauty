DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

    INSERT INTO users (id,name, email, password,phone) VALUES
  (default,'User', 'user@yandex.ru', 'password','89151551155'),
  (default,'Admin', 'admin@gmail.com', 'admin', '89151194188');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);



INSERT INTO products (id,time, description, price)
VALUES (DEFAULT,20, 'глубокое бикини', 700),
       (DEFAULT,100, 'подмышки', 300),
       (DEFAULT,100, 'бёдра', 600),
       (DEFAULT,33, 'руки', 400),
       (DEFAULT,23, 'верхняя губа', 200),
       (DEFAULT,44, 'Админ ланч', 510),
       (DEFAULT,222, 'Админ ужин', 1500);
INSERT INTO images (PRODUCT_ID, IMAGE)
VALUES (100016, 'глубокое бикини'),
       (100016, 'подмышки'),
       (100016, 'бёдра'),
       (100016, 'руки'),
       (100017, 'верхняя губа'),
       (100017, 'Админ ланч'),
       (100017, 'Админ ужин');

