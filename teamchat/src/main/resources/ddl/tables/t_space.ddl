DROP TABLE IF EXISTS space;
CREATE TABLE space (
  space_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title char(50) NOT NULL,
  color char(6) NOT NULL,
  created_by int NOT NULL,  -- for appuserid
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
