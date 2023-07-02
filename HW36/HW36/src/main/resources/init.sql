CREATE TABLE Products (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  cost DECIMAL(10, 2)
);

CREATE TABLE Orders (
  id INT PRIMARY KEY,
  date DATE,
  cost DOUBLE
);

CREATE TABLE OrderProduct (
  order_id INT,
  product_id INT,
  FOREIGN KEY (order_id) REFERENCES Orders(id),
  FOREIGN KEY (product_id) REFERENCES Products(id),
  PRIMARY KEY (order_id, product_id)
);

INSERT INTO Products (id, name, cost)
VALUES (1, 'Product 1', 10.99),
       (4, 'Product 4', 12.99),
       (10, 'Product 2', 15.99),
       (27, 'Product 5', 9.99);

INSERT INTO Orders (id, date, cost)
VALUES (10, '2023-06-30', 13),
       (11, '2023-06-30', 13),
       (13, '2023-06-30', 13),
       (130, '2023-06-30', 13);

INSERT INTO OrderProduct (order_id, product_id)
VALUES (10, 1),
       (11, 4),
       (13, 10),
       (130, 27);
