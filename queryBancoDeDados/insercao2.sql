drop schema clinica3;
CREATE DATABASE clinica3;
use clinica3;
CREATE TABLE `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valor` double DEFAULT NULL,
  `formaPagamento` int DEFAULT NULL,
  `idConsulta` int DEFAULT NULL,
  `convenio` varchar(30) DEFAULT NULL,
  `statusPagamento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pagamentoConvencionalespecialidade_medico` (`idConsulta`),
  CONSTRAINT `fk_pagamentoConvencionalespecialidade_medico` FOREIGN KEY (`idConsulta`) REFERENCES `consulta` (`id`)
) ;

CREATE TABLE `medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `idPaciente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `fk_loginPaciente` (`idPaciente`),
  CONSTRAINT `fk_loginPaciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`)
) ;

CREATE TABLE `gerente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `especialidade_medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idEspecialidade` int DEFAULT NULL,
  `idMedico` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEspecialidade` (`idEspecialidade`),
  KEY `idMedico` (`idMedico`),
  CONSTRAINT `especialidade_medico_ibfk_1` FOREIGN KEY (`idEspecialidade`) REFERENCES `especialidade` (`id`),
  CONSTRAINT `especialidade_medico_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`)
) ;

CREATE TABLE `especialidade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeEspecialidade` varchar(30) DEFAULT NULL,
  `descricao` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(30) DEFAULT NULL,
  `numero` decimal(10,0) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `cep` decimal(8,0) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `idPaciente` int DEFAULT NULL,
  `idMedico` int DEFAULT NULL,
  `idGerente` int DEFAULT NULL,
  `idClinica` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_enderecoMedico` (`idMedico`),
  KEY `fk_enderecoPaciente` (`idPaciente`),
  KEY `fk_enderecoGerente` (`idGerente`),
  KEY `fk_enderecoClinica` (`idClinica`),
  CONSTRAINT `fk_enderecoClinica` FOREIGN KEY (`idClinica`) REFERENCES `clinica` (`id`),
  CONSTRAINT `fk_enderecoGerente` FOREIGN KEY (`idGerente`) REFERENCES `gerente` (`id`),
  CONSTRAINT `fk_enderecoMedico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`),
  CONSTRAINT `fk_enderecoPaciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`)
) ;

CREATE TABLE `convenio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plano` varchar(30) DEFAULT NULL,
  `tarifa` double DEFAULT NULL,
  `idConsulta` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pagamentoConvenio` (`idConsulta`),
  CONSTRAINT `fk_pagamentoConvenio` FOREIGN KEY (`idConsulta`) REFERENCES `consulta` (`id`)
) ;

CREATE TABLE `consulta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataMarcada` datetime DEFAULT NULL,
  `observacao` varchar(100) DEFAULT NULL,
  `idMedico` int DEFAULT NULL,
  `idPaciente` int DEFAULT NULL,
  `tipoConsulta` int DEFAULT NULL,
  `statusConsulta` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_consultaMedico` (`idMedico`),
  KEY `fk_consultaPaciente` (`idPaciente`),
  CONSTRAINT `fk_consultaMedico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`),
  CONSTRAINT `fk_consultaPaciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`)
) ;

CREATE TABLE `clinica` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `cpnj` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
