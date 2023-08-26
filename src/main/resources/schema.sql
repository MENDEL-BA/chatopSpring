CREATE TABLE IF NOT EXISTS USERS (
  id INT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(255) UNIQUE NOT NULL,
  name VARCHAR(255),
  password VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS RENTALS (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  surface NUMERIC,
  price NUMERIC,
  picture VARCHAR(255),
  description VARCHAR(2000),
  owner_id INT NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  FOREIGN KEY (owner_id) REFERENCES USERS (id)
);

CREATE TABLE IF NOT EXISTS MESSAGES (
  id INT PRIMARY KEY AUTO_INCREMENT,
  rental_id INT,
  user_id INT,
  message VARCHAR(2000),
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  FOREIGN KEY (rental_id) REFERENCES RENTALS (id),
  FOREIGN KEY (user_id) REFERENCES USERS (id)
);

-- Note: Since a rental can have multiple messages and a user can have multiple messages,
-- you need a separate table to manage the many-to-many relationship between rentals and users for messages.

CREATE TABLE IF NOT EXISTS RENTAL_USER_MESSAGES (
  rental_id INT,
  user_id INT,
  message_id INT,
  PRIMARY KEY (rental_id, user_id, message_id),
  FOREIGN KEY (rental_id) REFERENCES RENTALS (id),
  FOREIGN KEY (user_id) REFERENCES USERS (id),
  FOREIGN KEY (message_id) REFERENCES MESSAGES (id)
);
