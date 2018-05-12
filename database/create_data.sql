CREATE SCHEMA max_schema;

CREATE TABLE country (
  id   BIGSERIAL    NOT NULL PRIMARY KEY,
  name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE city (
  id         BIGSERIAL    NOT NULL PRIMARY KEY,
  name       VARCHAR(128) NOT NULL,
  id_country BIGINT       NOT NULL REFERENCES country (id)
);

CREATE TABLE role (
  id   SERIAL      NOT NULL PRIMARY KEY,
  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE "user" (
  id       BIGSERIAL    NOT NULL PRIMARY KEY,
  email    VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(128) NOT NULL,
  role_id  INTEGER      NOT NULL REFERENCES role (id)
);

CREATE TABLE subscriber (
  id         BIGSERIAL   NOT NULL PRIMARY KEY,
  name       VARCHAR(64) NOT NULL,
  birth_date DATE        NOT NULL,
  country_id BIGINT      NOT NULL REFERENCES country (id),
  city_id    BIGINT      NOT NULL REFERENCES city (id),
  user_id    BIGINT      NOT NULL REFERENCES "user" (id),
  gender     VARCHAR(64) NOT NULL
);

CREATE TABLE param (
  id            BIGSERIAL NOT NULL PRIMARY KEY,
  subscriber_id BIGINT    NOT NULL REFERENCES subscriber (id),
  date          DATE      NOT NULL,
  height        INTEGER   NOT NULL,
  weight        NUMERIC   NOT NULL
);

CREATE TABLE program (
  id          SERIAL                 NOT NULL PRIMARY KEY,
  name        CHARACTER VARYING(128) NOT NULL UNIQUE,
  price       NUMERIC                NOT NULL,
  description CHARACTER VARYING(256) UNIQUE
);

CREATE TABLE purchase (
  id            BIGSERIAL NOT NULL PRIMARY KEY,
  subscriber_id BIGINT REFERENCES subscriber (id),
  program_id    INTEGER REFERENCES program (id),
  date          DATE      NOT NULL
);

CREATE TABLE theme (
  id   SERIAL                 NOT NULL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

CREATE TABLE subtopic (
  id       BIGSERIAL              NOT NULL PRIMARY KEY,
  name     CHARACTER VARYING(256) NOT NULL UNIQUE,
  text     TEXT                   NOT NULL UNIQUE,
  theme_id INTEGER REFERENCES theme (id)
);

INSERT INTO country (name) values ('Belarus');