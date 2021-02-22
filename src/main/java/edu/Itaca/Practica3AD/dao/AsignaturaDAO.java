package edu.Itaca.Practica3AD.dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import edu.Itaca.Practica3AD.Asignatura;

public class AsignaturaDAO implements DAO<Asignatura>{

	public Asignatura get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Asignatura> getAll(ODB odb) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Asignatura t, ODB odb) {
		// TODO Auto-generated method stub
		
	}

	public void update(Asignatura t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Asignatura t) {
		// TODO Auto-generated method stub
		
	}
	public List<Asignatura> nombreAsignatura(ODB odb, String nombre) {
		ArrayList<Asignatura> asignaturas = new ArrayList();
		IQuery query = new CriteriaQuery(Asignatura.class, Where.equal("nombre", nombre));
		Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);
		
		while(objectsAsignaturas.hasNext()) {
			asignaturas.add(objectsAsignaturas.next());
		}
		return asignaturas;
	}

	
}
