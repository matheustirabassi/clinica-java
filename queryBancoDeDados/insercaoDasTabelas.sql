drop schema clinica2;
create database clinica2;
use clinica2;

create table paciente(
id int primary key not null auto_increment,
nome varchar(30),
cpf varchar(11),
telefone varchar(13),
email varchar(35),
dataNascimento date
);
create table especialidade(
id int primary key not null auto_increment,
nomeEspecialidade varchar(30),
descricao varchar(30)
);

create table medico(
id int primary key not null auto_increment,
nome varchar(30),
cpf varchar(11),
telefone varchar(13),
email varchar(35),
dataNascimento date
);

create table especialidade_Medico(
id int primary key not null auto_increment,
idEspecialidade int,
idMedico int,
foreign key(idEspecialidade) references especialidade(id),
foreign key(idMedico) references medico(id)
);
create table gerente(
id int primary key not null auto_increment,
nome varchar(30),
cpf varchar(11),
telefone varchar(13),
email varchar(35),
dataNascimento date
);
create table clinica(
id int primary key not null auto_increment,
nome varchar(30),
cpnj varchar(14)
);
create table consulta(
id int primary key not null auto_increment,
dataMarcada datetime,
observacao varchar(100),
idMedico int,
idPaciente int,
constraint fk_consultaMedico foreign key(idMedico) references medico(id),
constraint fk_consultaPaciente foreign key(idPaciente) references paciente(id)
);
create table endereco(
id int primary key not null auto_increment,
logradouro varchar(30),
numero numeric,
bairro varchar(30),
estado varchar(30),
cidade varchar(30),
cep numeric(8),
complemento varchar(30),
idPaciente int,
idMedico int,
idGerente int,
idClinica int,
constraint fk_enderecoMedico foreign key(idMedico) references medico(id),
constraint fk_enderecoPaciente foreign key(idPaciente) references paciente(id),
constraint fk_enderecoGerente foreign key(idGerente) references gerente(id),
constraint fk_enderecoClinica foreign key(idClinica) references clinica(id)
);
create table pagamento(
id int primary key not null auto_increment,
valor double,
formaPagamento int,
idConsulta int,
constraint fk_pagamentoConvencionalespecialidade_medico foreign key(idConsulta) references consulta(id)
);
create table convenio(
id int primary key not null auto_increment,
plano varchar(30),
tarifa double,
idConsulta int,
constraint fk_pagamentoConvenio foreign key(idConsulta) references consulta(id)
);
create table login(
id int primary key not null auto_increment,
usuario varchar(30) unique key,
senha varchar(30),
idPaciente int,
constraint fk_loginPaciente foreign key(idPaciente) references paciente(id)
);




