CREATE TABLE regions
(id INTEGER PRIMARY KEY,
 name VARCHAR(50) NOT NULL,
 regionx FLOAT NOT NULL,
 regiony FLOAT NOT NULL,
 object TEXT NOT NULL,
 UNIQUE INDEX(name));