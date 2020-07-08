DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS images;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL,
  phone            varchar            NOT NULL

);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  time        INTEGER  NOT NULL,
  description TEXT      NOT NULL,
  price    INTEGER       NOT NULL
);
CREATE UNIQUE INDEX entities_unique_user_id_idx
  ON products (id);

CREATE TABLE images (
                        id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
                        product_id INTEGER NOT NULL ,
                        image Text NOT NULL,
                        CONSTRAINT image_id_idx UNIQUE (id),
                        FOREIGN KEY (product_id)REFERENCES products(id) ON DELETE  CASCADE );