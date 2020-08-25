CREATE LANGUAGE plpython3u;
CREATE TABLE date_operations
(
    uid       serial  not null,
    argument1 varchar,
    argument2 varchar,
    operation varchar not null,
    result    varchar
);

ALTER TABLE date_operations OWNER TO puser;

create table execution_time
(
    tid        serial  not null
        constraint execution_time_pk
            primary key,
    time_taken varchar not null,
    uid        integer
);

alter table execution_time
    owner to puser;
