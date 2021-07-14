ALTER TABLE categoria ADD produto_id BIGINT(20);

ALTER TABLE `categoria` ADD CONSTRAINT `fk_produto` FOREIGN KEY ( `produto_id` ) 
REFERENCES `produto` ( `id` );