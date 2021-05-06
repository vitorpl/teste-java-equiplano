
CREATE TABLE estado (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  sigla varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE cidade (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  estado bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_estado_cidade (estado),
  CONSTRAINT FK_estado_cidade FOREIGN KEY (estado) REFERENCES estado (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  cpf varchar(255) DEFAULT NULL,
  nome varchar(60) DEFAULT NULL,
  cidade bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_cidade_cliente (cidade),
  CONSTRAINT FK_cidade_cliente FOREIGN KEY (cidade) REFERENCES cidade (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE apolice (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  fim_vigencia datetime(6) NOT NULL,
  inicio_vigencia datetime(6) NOT NULL,
  numero varchar(255) DEFAULT NULL,
  placa varchar(255) DEFAULT NULL,
  valor decimal(19,2) NOT NULL,
  cliente bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_cliente_apolice (cliente),
  CONSTRAINT FK_cliente_apolice FOREIGN KEY (cliente) REFERENCES cliente (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




