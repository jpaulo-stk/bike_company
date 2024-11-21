CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario varchar(255),
    data_nascimento date,
    tipo ENUM('FISICA', 'JURIDICA') NOT NULL
);

CREATE TABLE pessoa_fisica (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE,
    FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE pessoa_juridica (
    id INT PRIMARY KEY,
    razao_social VARCHAR(255) NOT NULL,
    cnpj CHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE
);
