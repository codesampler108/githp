DROP TABLE IF EXISTS message;
CREATE TABLE message (
  message_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  chat_id int NOT NULL,
  data varchar(255) NOT NULL,
  created_by int NOT NULL,  -- for appuserid
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
