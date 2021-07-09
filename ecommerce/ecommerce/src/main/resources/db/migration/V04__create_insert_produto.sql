CREATE TABLE produto(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	valor float(8,2) NOT NULL,
	quantidade integer NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    registro datetime NOT NULL,
    categoria_id BIGINT(20),
    caracteristica_id BIGINT(20)
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `produto` ADD CONSTRAINT `fk_categoria` FOREIGN KEY ( `categoria_id` ) 
REFERENCES `categoria` ( `id` );
ALTER TABLE `produto` ADD CONSTRAINT `fk_caracteristica` FOREIGN KEY ( `caracteristica_id` )
 REFERENCES `caracteristica` ( `id` );
 
 insert into produto (nome, valor, quantidade, descricao, registro, categoria_id, caracteristica_id ) 
 values ('nome produto 01', 23.30, 10, 'descrição do produto 01', '2021-07-08 12:18:00', 1, 1 );
 insert into produto (nome, valor, quantidade, descricao, registro, categoria_id, caracteristica_id ) 
 values ('nome produto 02', 23.30, 10, 'descrição do produto 02', '2021-06-18 12:18:00', 1, 2);