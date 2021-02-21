package edu.Itaca.Practica2AD.dao;

import java.util.List;

public interface DAO <T> {	
		
		T get(long id);
	    
	    List<T> getAll();
	    
	    void create(T t);
	    
	    void update(T t, String[] params);
	    
	    void delete(T t);
}