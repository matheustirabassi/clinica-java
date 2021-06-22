use  clinica2;
select paciente.* , endereco.*, consulta.*, pagamento.*,login.* from paciente 
left join endereco on paciente.id = endereco.idPaciente
left join consulta on paciente.id = consulta.idPaciente 
left join pagamento on paciente.id = pagamento.idConsulta
left join login on paciente.id = login.idPaciente