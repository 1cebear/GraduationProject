DELETE FROM userscores;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM menu;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('admin', 'admin@yandex.ru', 'admin'),
  ('user', 'user@yandex.ru', 'user');

INSERT INTO menu (name, date_time)
VALUES ('menu 1', '2015-05-30 10:00:00'),
  ('menu 2', '2015-05-30 10:00:00');

INSERT INTO dishes (name, menu_id, price)
VALUES ('fish', 100002, 50),
  ('jam', 100002, 200),
  ('soupe', 100003, 125),
  ('cake', 100003, 75);

INSERT INTO userscores (menu_id, user_id, score)
VALUES (100002, 100000, 5);