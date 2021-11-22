package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.artcomsoft.sistemaloja.models.EnderecoFornecidor;


@Repository
public class EnderecoFornecidorDaoImpl implements InterfaceDao {

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
		return (EnderecoFornecidor) this.entity.find(EnderecoFornecidor.class, id);
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<EnderecoFornecidor> listagensEndereco() {		
		return this.entity.createQuery("from EnderecoFornecidor",EnderecoFornecidor.class).getResultList();		 
	}
	public EnderecoFornecidor procurarIdFornecidor (int id){
		
		EnderecoFornecidor enderecoObjeto = new EnderecoFornecidor();
		enderecoObjeto =null;
		for (EnderecoFornecidor endereco :listagensEndereco()) {
			if (endereco.getFornecidor().getIdFornecidor()==id) {				
				enderecoObjeto=endereco;				
				break ;
			}
		}
		return enderecoObjeto;    	
	}

}
