CREATE TABLE vendas (
    id_venda INT PRIMARY KEY AUTO_INCREMENT,
    data DATE
);

CREATE TABLE itens_vendas (
    id_produto INT NOT NULL,
    id_venda INT NOT NULL,
    quantidade INT,
    valor decimal(10,2),
    PRIMARY KEY (id_produto, id_venda),
    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto) ON DELETE CASCADE,
    FOREIGN KEY (id_venda) REFERENCES vendas(id_venda) ON DELETE CASCADE
);

