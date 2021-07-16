package model.dao;

import java.util.List;

import model.entities.Login;

public interface LoginDao {
	void insert(Login obj);

	void update(Login obj);

	void deleteById(Integer id);

	Login findById(Integer id);

	Login findByLogin(String text);

	List<Login> findAll();
}
