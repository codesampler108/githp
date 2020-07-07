DROP TABLE IF EXISTS chatappusers;
CREATE TABLE chatappusers (
  chat_id int NOT NULL, 
  appuser_id int NOT NULL
) DEFAULT CHARSET=utf8;
