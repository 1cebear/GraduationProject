DELETE FROM userscores;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM menu;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('admin', 'admin@yandex.ru', 'admin'),
  ('user', 'user@yandex.ru', 'user');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurant (name)
VALUES ('restaurant 1'),
  ('restaurant 2');

INSERT INTO menu (restaurant_id, name, date_time)
VALUES (100002, 'menu 1', '2015-05-30 10:00:00'),
  (100002, 'menu 2', '2015-05-31 10:00:00'),
  (100003, 'menu 3', '2015-05-30 10:00:00');

INSERT INTO dishes (name, menu_id, price)
VALUES ('fish', 100004, 50),
  ('jam', 100004, 200),
  ('soupe', 100005, 125),
  ('cake', 100005, 75);

INSERT INTO userscores (menu_id, user_id, score)
VALUES (100004, 100000, 5);