package com.yesserp.sessionbean.dao;

import java.util.List;

import javax.ejb.Local;


@Local
public interface GestionLocal {

	public void insert(Object o);
	public void update(Object o);
	public void delete(Object o);
	public Object getId(Object o);
	public Object findById(Object o,Long id);
	public List<Object> findAll(Object o);
	
}
