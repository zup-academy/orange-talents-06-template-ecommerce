CREATE TABLE pedido(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    pagamento VARCHAR(50) NOT NULL,
    usuario_id BIGINT(20) NOT NULL,
    criacao datetime NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `pedido` ADD CONSTRAINT `fk_usuario_pedido` FOREIGN KEY ( `usuario_id` ) 
REFERENCES `usuario` ( `id` );


CREATE TABLE venda(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	quantidade int not null,
    valor float(8,2) NOT NULL,
    produto_id BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `venda` ADD CONSTRAINT `fk_produto_venda` FOREIGN KEY ( `produto_id` ) 
REFERENCES `produto` ( `id` );


insert into pedido (pagamento, usuario_id, criacao) 
values ("paypal", 1, '2021-07-08 12:18:00');
insert into pedido (pagamento, usuario_id, criacao) 
values ("paypal", 2, '2021-07-08 12:18:00');

insert into venda (quantidade, valor, produto_id) 
values (2, 3.55, 1);

insert into venda (quantidade, valor, produto_id) 
values (2, 55.55, 2);




