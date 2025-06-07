-- DDL definition
-- schema.sql
CREATE TABLE IF NOT EXISTS Produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    descricao_produto VARCHAR(255) NOT NULL,
    data_produto TIMESTAMP
);
