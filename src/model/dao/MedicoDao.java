package model.dao;

import java.util.List;

import model.entities.Medico;

public interface MedicoDao {
	void insert(Medico obj);

	void update(Medico obj);

	void deleteById(Integer id);

	Medico findById(Integer id);

	List<Medico> findAll();
}
