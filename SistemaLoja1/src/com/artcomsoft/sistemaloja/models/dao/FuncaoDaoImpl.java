package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artcomsoft.sistemaloja.models.Funcao;

//@Repository
//

@Service("interfaceDao")
public class FuncaoDaoImpl implements InterfaceDao {

	@PersistenceContext 
	private EntityManager entity ;	

	@Override	
	public void salvarObjeto(Object obj) {
		// TODO Auto-generated method stub
		entity.persist(obj);
		//return false;
	}
	@Override
	public void atualizarObjeto(Object obj) {
		// TODO Auto-generated method stub
		this.entity.merge((Funcao)obj);
	}
	@Override
	public Object getId(int id) {
		// TODO Auto-generated method stub
		return (Funcao) this.entity.find(Funcao.class, id);
	}
	// Metodo para listar todas a Funcionalidades do Sistema
	public List<Funcao> listagensObjeto() {		
		return this.entity.createQuery("from Funcao",Funcao.class).getResultList();		 
	}	
	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return (Funcao) descricaoFuncao(descricao);
	}

	public Funcao descricaoFuncao (String descricao){
		Funcao funcaoObjeto= new Funcao();
		funcaoObjeto =null;
		for (Funcao funcao :listagensObjeto()) {
			if (funcao.getDescricao().equals (descricao)) {
				funcaoObjeto =funcao;
				break ;
			}
		}
		return funcaoObjeto;

	}


}
