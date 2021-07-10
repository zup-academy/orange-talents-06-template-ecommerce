CREATE TABLE imagem(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	imagem VARCHAR(300) NOT NULL,
	produto_id BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `imagem` ADD CONSTRAINT `fk_produto_imagem` FOREIGN KEY ( `produto_id` ) 
REFERENCES `produto` ( `id` );

insert into imagem (imagem, produto_id) values ('link01', 1);
insert into imagem (imagem, produto_id) values ('link01', 1);