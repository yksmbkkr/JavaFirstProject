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
