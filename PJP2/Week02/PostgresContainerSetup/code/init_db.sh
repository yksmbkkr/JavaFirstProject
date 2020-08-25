#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username postgres <<-EOSQL
    CREATE DATABASE datetimecalculatordb;
    CREATE USER puser WITH PASSWORD 'password';
    ALTER ROLE puser SET client_encoding TO 'utf8';
    ALTER ROLE puser SET timezone TO 'UTC';
    GRANT ALL PRIVILEGES ON DATABASE datetimecalculatordb TO puser;
    ALTER ROLE puser WITH SUPERUSER;
EOSQL

psql -v ON_ERROR_STOP=1 -U postgres -d datetimecalculatordb -a -f /code/create_table.sql
