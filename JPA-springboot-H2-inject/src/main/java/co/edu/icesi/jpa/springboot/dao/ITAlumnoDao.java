package co.edu.icesi.jpa.springboot.dao;

import java.util.List;

import co.edu.icesi.jpa.springboot.model.TAlumno;

public interface ITAlumnoDao {

	public void save(TAlumno entity);
	public void update(TAlumno entity);
	public void delete(TAlumno entity);
	public TAlumno findById(Integer codigo);
	public List<TAlumno> findAll();
	
}
