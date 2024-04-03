CREATE TABLE customers (
  customer_id SERIAL PRIMARY KEY,
  name  VARCHAR(100) NOT NULL,
  phone VARCHAR(20),
  email VARCHAR(45) NOT NULL UNIQUE,
  password VARCHAR(200) NOT NULL,
  role VARCHAR(45) NOT NULL,
  created_at DATE
);