CREATE TABLE usuario(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	usuario VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
    senha varchar(200) NOT NULL, 
    data_cadastro datetime
) ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO usuario (usuario, email, senha, data_cadastro) 
Values('usuario teste', 'usuarioteste@zup.com.br', 123456, '2021-07-06 01:00:00');

INSERT INTO usuario (usuario, email, senha, data_cadastro) 
Values('usuario teste 02', 'usuarioteste02@zup.com.br', 123456,'2021-07-06 01:00:00');