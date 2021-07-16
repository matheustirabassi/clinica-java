package model.dao;

import java.util.List;

import model.entities.Consulta;
import model.entities.Especialidade;
import model.entities.Medico;
import model.entities.Paciente;

public interface ConsultaDao {

	void insert(Consulta obj);

	void update(Consulta obj, Paciente obj2, Medico obj3);

	void deleteById(Integer id);

	Consulta findByIdPaciente(Integer id);

	List<Consulta> findAll();

	List<Especialidade> findAllEspecialidade();
}
