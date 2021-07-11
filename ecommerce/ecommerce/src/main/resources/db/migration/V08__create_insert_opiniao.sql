CREATE TABLE opiniao(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nota int not null,
	descricao VARCHAR(100) NOT NULL,
	produto_id BIGINT(20) NOT NULL,
    usuario_id BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `opiniao` ADD CONSTRAINT `fk_produto_opiniao` FOREIGN KEY ( `produto_id` ) 
REFERENCES `produto` ( `id` );
ALTER TABLE `opiniao` ADD CONSTRAINT `fk_usuario_opiniao` FOREIGN KEY ( `usuario_id` ) 
REFERENCES `usuario` ( `id` );

insert into opiniao (nota, descricao, produto_id, usuario_id) 
values (1, 'descriação op 01', 1, 1);
insert into opiniao (nota, descricao, produto_id, usuario_id) 
values (1, 'descriação op 02', 1, 2);
insert into opiniao (nota, descricao, produto_id, usuario_id) 
values (1, 'descriação op 03', 1, 2);