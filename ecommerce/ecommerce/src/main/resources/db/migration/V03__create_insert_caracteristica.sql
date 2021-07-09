CREATE TABLE caracteristica(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	marca VARCHAR(50) NOT NULL,
	modelo  VARCHAR(50) NOT NULL,
	quantidade_embalagem integer NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO caracteristica ( marca, modelo, quantidade_embalagem) values ('MARCA 01','MODELO 01',1);
INSERT INTO caracteristica ( marca, modelo, quantidade_embalagem) values ('MARCA 02','MODELO 02',1);
INSERT INTO caracteristica ( marcgit a, modelo, quantidade_embalagem) values ('MARCA 03','MODELO 03',2);