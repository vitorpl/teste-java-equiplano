drop table apolice;

CREATE TABLE apolice (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  fim_vigencia datetime NOT NULL,
  inicio_vigencia datetime NOT NULL,
  numero varchar(255) DEFAULT NULL,
  placa varchar(255) DEFAULT NULL,
  valor decimal(19,2) NOT NULL,
  cliente bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_cliente_apolice (cliente),
  CONSTRAINT FK_cliente_apolice FOREIGN KEY (cliente) REFERENCES cliente (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;