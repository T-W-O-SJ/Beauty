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


INSERT INTO products (time, description, price, user_id)
VALUES (20, 'глубокое бикини', 700, 100000),
       (100, 'подмышки', 300, 100000),
       (100, 'бёдра', 600, 100000),
       (33, 'руки', 400, 100000),
       (23, 'верхняя губа', 200, 100000),
       (44, 'Админ ланч', 510, 100001),
       (222, 'Админ ужин', 1500, 100001);
