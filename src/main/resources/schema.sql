DROP TABLE IF EXISTS cell;
CREATE TABLE cell
(
    id    varchar(50) NOT NULL,
    sheet varchar(50) NOT NULL,
    value varchar(50),
    result varchar(50),
    CONSTRAINT pk_cell PRIMARY KEY (id, sheet)
);