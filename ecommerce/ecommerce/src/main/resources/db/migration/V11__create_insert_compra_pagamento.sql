create table finaliza_compra(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
id_transaçao VARCHAR(50) NOT NULL,
comunicacao boolean not null
) ENGINE=InnoDB DEFAULT charset=utf8;

insert into finaliza_compra (id_transaçao, comunicacao ) 
 values ( '1AA', false);
insert into finaliza_compra (id_transaçao, comunicacao ) 
 values ( '2AA', false);
 
 create table registro_pagamento(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
retorno VARCHAR(50) NOT NULL,
registro datetime not null,
id_finaliza BIGINT(20)  not null
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `registro_pagamento` ADD CONSTRAINT `fk_transacao` FOREIGN KEY ( `id_finaliza` ) 
REFERENCES `finaliza_compra` ( `id` );

insert into registro_pagamento (retorno, registro, id_finaliza) 
values ( '0', '2021-07-08 12:18:00', 1);
 insert into registro_pagamento (retorno, registro, id_finaliza) 
 values ( '1', '2021-07-08 16:18:00', 1);