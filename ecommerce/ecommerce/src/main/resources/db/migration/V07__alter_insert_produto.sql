ALTER TABLE produto ADD usuario_id BIGINT(20);

ALTER TABLE `produto` ADD CONSTRAINT `fk_usuario` FOREIGN KEY ( `usuario_id` ) 
REFERENCES `usuario` ( `id` );

update produto
set usuario_id = 1
where id >=1;