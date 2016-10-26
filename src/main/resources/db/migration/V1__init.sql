CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id__category_UNIQUE (id ASC),
  UNIQUE INDEX name_UNIQUE (name ASC)
);

CREATE TABLE news (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  text longtext NOT NULL,
  date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  category_id int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_news_UNIQUE (id),
  CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id)
);


INSERT into category(name) values ('SPORT');
INSERT into category(name) values ('MEDIA');
INSERT into category(name) values ('POLITICS');
INSERT into category(name) values ('TECHNOLOGY');
INSERT into category(name) values ('WEATHER');
INSERT into category(name) values ('TRAFFIC');
