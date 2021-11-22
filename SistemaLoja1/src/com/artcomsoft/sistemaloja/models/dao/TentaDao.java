package com.artcomsoft.sistemaloja.models.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.artcomsoft.sistemaloja.models.Tenta;

@Repository 
@Transactional
public class TentaDao {
	
	@PersistenceContext 
    private EntityManager entity ;
	

	//@Transactional
	//@Autowired
	
	public void salvarObjeto(Tenta obj) {
		// TODO Auto-generated method stub
		   entity.persist(obj);
		//return false;
	}

}
