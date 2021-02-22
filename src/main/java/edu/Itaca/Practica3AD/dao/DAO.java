package edu.Itaca.Practica3AD.dao;

import java.util.List;

import org.neodatis.odb.ODB;

public interface DAO <T> {	
		
		T get(long id);
	    
	    List<T> getAll(ODB odb);
	    
	    void create(T t, ODB odb);
	    
	    void update(T t, String[] params);
	    
	    void delete(T t);
}