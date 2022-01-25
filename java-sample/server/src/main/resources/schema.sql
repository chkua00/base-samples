DROP TABLE IF EXISTS price_bar;

CREATE TABLE price_bar (
  `date` VARCHAR(198) PRIMARY KEY,
  `open` VARCHAR(198) NOT NULL,
  `high` VARCHAR(198) NOT NULL,
  `low` VARCHAR(198) NOT NULL,
  `close` VARCHAR(198) NOT NULL,
  `volume` VARCHAR(198) NOT NULL
);