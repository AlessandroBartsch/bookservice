CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  author CLOB,  -- Usando CLOB em vez de longtext
  launch_date TIMESTAMP NOT NULL,  -- Usando TIMESTAMP
  price DECIMAL(10,2) NOT NULL,  -- Ajustando a precisão para 10,2
  title CLOB   -- Usando CLOB em vez de longtext
);
