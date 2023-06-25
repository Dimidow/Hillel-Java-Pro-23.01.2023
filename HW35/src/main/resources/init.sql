-- Creating the 'Product' table
CREATE TABLE Products (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  price DECIMAL(10, 2)
);

-- Creating the 'Cart' table
CREATE TABLE Carts (
  id INT PRIMARY KEY
);

-- Creating a table to establish a relationship between 'Product' and 'Cart'
CREATE TABLE CartProduct (
  cart_id INT,
  product_id INT,
  FOREIGN KEY (cart_id) REFERENCES Carts(id),
  FOREIGN KEY (product_id) REFERENCES Products(id),
  PRIMARY KEY (cart_id, product_id)
);

-- Inserting data
INSERT INTO Products (id, name, price) VALUES
  (1, 'Product 1', 10.99),
  (10, 'Product 2', 15.99),
  (13, 'Product 3', 7.99),
  (4, 'Product 4', 12.99),
  (27, 'Product 5', 9.99);

INSERT INTO Carts (id) VALUES (1);