DROP TABLE IF EXISTS weather;

CREATE TABLE weather (
  `area` VARCHAR(198) PRIMARY KEY,
  `latitude` VARCHAR(198) NOT NULL,
  `longitude` VARCHAR(198) NOT NULL,
  `time` VARCHAR(198) NOT NULL,
  `forecast` VARCHAR(198) NOT NULL
);
