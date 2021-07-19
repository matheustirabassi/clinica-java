package model.dao;

import java.util.List;

import model.entities.Consulta;
import model.entities.Especialidade;

public interface ConsultaDao {

	void insert(Consulta obj);

	void update(Consulta obj);

	void deleteById(Integer id);

	List<Consulta> findAllByIdPaciente(Integer id);

	List<Consulta> findAll();

	List<Especialidade> findAllEspecialidade();
}
