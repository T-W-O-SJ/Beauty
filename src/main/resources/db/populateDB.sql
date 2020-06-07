DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

    INSERT INTO users (name, email, password,phone) VALUES
  ('User', 'user@yandex.ru', 'password','89151551155'),
  ('Admin', 'admin@gmail.com', 'admin', '89151194188');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO products (id,time, description, price)
    VALUES (1,10,'stamp',24);

INSERT INTO products (time, description, price)
VALUES (20, 'глубокое бикини', 700),
       (100, 'подмышки', 300),
       (100, 'бёдра', 600),
       (33, 'руки', 400),
       (23, 'верхняя губа', 200),
       (44, 'Админ ланч', 510),
       (222, 'Админ ужин', 1500);
INSERT INTO images (PRODUCT_ID, IMAGE)
VALUES (1, 'глубокое бикини'),
       (1, 'подмышки'),
       (1, 'бёдра'),
       (1, 'руки'),
       (2, 'верхняя губа'),
       (3, 'Админ ланч'),
       (3, 'Админ ужин');

