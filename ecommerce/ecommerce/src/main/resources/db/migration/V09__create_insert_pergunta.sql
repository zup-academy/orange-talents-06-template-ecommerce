CREATE TABLE pergunta(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
   	titulo VARCHAR(50) NOT NULL,
   	criacao datetime not null,
	produto_id BIGINT(20) NOT NULL,
    usuario_id BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `pergunta` ADD CONSTRAINT `fk_produto_pergunta` FOREIGN KEY ( `produto_id` ) 
REFERENCES `produto` ( `id` );
ALTER TABLE `pergunta` ADD CONSTRAINT `fk_usuario_pergunta` FOREIGN KEY ( `usuario_id` ) 
REFERENCES `usuario` ( `id` );

insert into pergunta (titulo, produto_id, usuario_id, criacao) 
values ('titulo 01 da pergunta', 1, 1, '2021-07-08 12:18:00');
insert into pergunta (titulo, produto_id, usuario_id, criacao) 
values ('titulo 02 da pergunta', 1, 2, '2021-07-08 12:18:00');
insert into pergunta (titulo, produto_id, usuario_id, criacao) 
values ('titulo 03 da pergunta', 1, 1, '2021-07-08 12:18:00');
