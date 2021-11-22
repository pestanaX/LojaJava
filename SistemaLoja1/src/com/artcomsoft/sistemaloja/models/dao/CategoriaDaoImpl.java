package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.Funcao;

@Repository 
public class CategoriaDaoImpl implements InterfaceDao {

	
	@PersistenceContext 
	private EntityManager entity ;	
	
	@Override
	public void salvarObjeto(Object obj) {
		// TODO Auto-generated method stub
		 entity.persist(obj);
	}

	@Override
	public void atualizarObjeto(Object obj) {
		// TODO Auto-generated method stub
		 entity.merge(obj);
	}

	@Override
	public Object getId(int id) {
		// TODO Auto-generated method stub
		return (Categoria) this.entity.find(Categoria.class, id);
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Categoria> listagensCategoria() {		
		return this.entity.createQuery("from Categoria",Categoria.class).getResultList();		 
	}
	public Categoria descricaoCategoria (String descricao){
		Categoria categoriaObjeto= new Categoria();
		categoriaObjeto =null;
		for (Categoria categoria :listagensCategoria()) {
			if (categoria.getDescricaoCategoria().equals (descricao)) {
				categoriaObjeto =categoria;
				break ;
			}
		}
		return categoriaObjeto;

	}

}
 