CREATE DATABASE datetimecalculatordb;
CREATE USER puser WITH PASSWORD 'password';
ALTER ROLE puser SET client_encoding TO 'utf8';
ALTER ROLE puser SET timezone TO 'UTC';
GRANT ALL PRIVILEGES ON DATABASE datetimecalculatordb TO puser;
