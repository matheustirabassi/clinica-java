package model.dao;

import java.util.List;

import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;

public interface PacienteDao {
	void insert(Paciente obj, Endereco obj2, Login obj3);

	void update(Paciente obj, Endereco obj2, Login obj3);

	void deleteById(Integer id);

	Paciente findById(Integer id);

	Paciente findByIdLogin(Integer idPaciente);

	List<Paciente> findAll();
}
