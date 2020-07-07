DROP TABLE IF EXISTS app_user;
CREATE TABLE app_user (
  app_user_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nick_name varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) DEFAULT NULL,
  color char(6) NOT NULL,
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
