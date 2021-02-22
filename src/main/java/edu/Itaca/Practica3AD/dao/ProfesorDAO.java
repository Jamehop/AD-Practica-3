package edu.Itaca.Practica3AD.dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import edu.Itaca.Practica3AD.Profesor;

public class ProfesorDAO implements DAO<Profesor>{

	public Profesor get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Profesor> getAll(ODB odb) {
		List<Profesor> profesores = new ArrayList();
		IQuery query = new CriteriaQuery(Profesor.class);
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}

	public void create(Profesor t, ODB odb) {
		// TODO Auto-generated method stub
		
	}

	public void update(Profesor t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Profesor t) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Profesor> getSoloHombres(ODB odb) {
		List<Profesor> profesores = new ArrayList();
		IQuery query = new CriteriaQuery(Profesor.class, Where.equal("sexo", "H"));
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}
	
	public void getProfesoresNacimiento(ODB odb, String year) {
		IQuery query = new CriteriaQuery(Profesor.class, Where.lt("fechaNacimiento", year));
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		int i = 1;
		while (objectsProfesor.hasNext()) {
			System.out.println((i++) + "\t: " + objectsProfesor.next());
		}
	}

	public List<Profesor> getCodigoProfesor(ODB odb, float codigo) {
		List<Profesor> profesores = new ArrayList();
		
		ICriterion criterio = new And().add(Where.equal("codigo", codigo));
		CriteriaQuery query = new CriteriaQuery(Profesor.class, criterio);
		
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}
}
