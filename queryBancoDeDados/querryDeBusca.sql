select paciente.* , endereco.*, consulta.*, pagamento.*, login.* from paciente inner join endereco on endereco.idPaciente = paciente.id inner join consulta on consulta.idPaciente= paciente.id inner join pagamento on pagamento.idConsulta = consulta.id inner join login on login.idPaciente = paciente.id where paciente.id = 1;
select paciente.* , endereco.*, consulta.*, pagamento.*, login.* from paciente inner join endereco on endereco.idPaciente = paciente.id inner join consulta on consulta.idPaciente= paciente.id inner join pagamento on pagamento.idConsulta = consulta.id inner join login on login.idPaciente = paciente.id;