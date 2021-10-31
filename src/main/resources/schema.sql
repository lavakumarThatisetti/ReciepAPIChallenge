CREATE TABLE IF NOT EXISTS recipe
(
  id bigserial PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE,
  image TEXT NULL ,
  category VARCHAR(50) NULL,
  label VARCHAR(50) NULL,
  price DOUBLE PRECISION,
  description TEXT NULL
);
