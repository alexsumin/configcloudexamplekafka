DROP TABLE IF EXISTS properties;

CREATE TABLE properties
(
    ID          bigint PRIMARY KEY,
    APPLICATION varchar(255) NOT NULL,
    PROFILE     varchar(255) NOT NULL,
    LABEL       varchar(255) NOT NULL,
    "KEY"       varchar(255) NOT NULL,
    "VALUE"     varchar(255) NOT NULL
);