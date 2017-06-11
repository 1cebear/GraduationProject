DELETE FROM dishes;
DELETE FROM menu;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO menu (name, date_time)
VALUES ('menu 1', '2015-05-30 10:00:00'),
  ('menu 2', '2015-05-30 10:00:00');

INSERT INTO dishes (name, menu_id, price)
VALUES ('fish', 100000, 50),
  ('jam', 100000, 200),
  ('soupe', 100001, 125),
  ('cake', 100001, 75)