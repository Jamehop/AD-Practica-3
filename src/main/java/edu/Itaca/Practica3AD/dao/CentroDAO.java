package edu.Itaca.Practica3AD.dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import edu.Itaca.Practica3AD.Centro;

public class CentroDAO implements DAO<Centro> {

	public Centro get(long id) {
		return null;
	}

	public List<Centro> getAll(ODB odb) {
		List<Centro> centros = new ArrayList<Centro>();
		IQuery query = new CriteriaQuery(Centro.class);
		Objects<Centro> objectsCentros = odb.getObjects(query);

		while (objectsCentros.hasNext()) {
			centros.add(objectsCentros.next());
		}

		return centros;
	}

	public void create(Centro t, ODB odb) {
		odb.store(t);
		
	}

	public void update(Centro t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Centro t) {
		// TODO Auto-generated method stub
		
	}
	

}
