package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.Fornecidor;

@Repository
public class FornecidorDaoImpl implements InterfaceDao {

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
		return (Fornecidor) this.entity.find(Fornecidor.class, id);
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Fornecidor> listagensFornecidor() {		
		return this.entity.createQuery("from Fornecidor",Fornecidor.class).getResultList();		 
	}
	
	
	public Fornecidor nomeFornecidor (String nome){
		
		Fornecidor fornecidorObjeto= new Fornecidor();
		fornecidorObjeto =null;
	
		for (Fornecidor fornecidor :listagensFornecidor()) {
			System.out.println(fornecidor.getNomeDoFornecidor());
			if (fornecidor.getNomeDoFornecidor().equals(nome)) {
				fornecidorObjeto =fornecidor;
				
				break ;
			}
		}
		return fornecidorObjeto;

	}


}

