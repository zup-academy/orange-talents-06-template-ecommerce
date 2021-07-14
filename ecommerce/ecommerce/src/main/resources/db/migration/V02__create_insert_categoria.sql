CREATE TABLE categoria(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    categoria_mae BIGINT(20)
) ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO categoria (nome) Values('categoria 01');
INSERT INTO categoria (nome, categoria_mae) Values('categoria 02', 1);
INSERT INTO categoria (nome, categoria_mae) Values('categoria 03',1);
INSERT INTO categoria (nome, categoria_mae) Values('categoria 04', 2);





