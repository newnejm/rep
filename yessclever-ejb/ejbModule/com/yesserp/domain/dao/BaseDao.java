package com.yesserp.domain.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.yesserp.domain.entities.BaseEntity;

@Local
public interface BaseDao<T extends BaseEntity> {

	public T create(T t);
    public T find(Class type,Object id);
    public T update(T t);
    public void delete(Class type,Object id);
    public List findWithNamedQuery(String queryName);
    public List findWithNamedQuery(String queryName,int resultLimit);
	List<T> findAll();
    
}