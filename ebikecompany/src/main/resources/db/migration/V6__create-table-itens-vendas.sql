CREATE TABLE vendas (
  id_venda int NOT NULL AUTO_INCREMENT,
  data date DEFAULT NULL,
  id_user int NOT NULL,
  valor_total int NOT NULL,
  PRIMARY KEY (id_venda),
  KEY id_user (id_user),
  CONSTRAINT vendas_ibfk_1 FOREIGN KEY (id_user) REFERENCES user (id)
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
