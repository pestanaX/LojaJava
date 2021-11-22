package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.Endereco;
import com.artcomsoft.sistemaloja.models.Funcao;

@Repository 

public class EnderecoDaoImpl implements InterfaceDao{


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
		this.entity.merge((Endereco)obj);

	}

	@Override
	public Object getId(int id) {
		// TODO Auto-generated method stub
		return (Endereco) this.entity.find(Endereco.class, id);
	}
	public List<Endereco> listagensEndereco() {		
		return this.entity.createQuery("from Endereco",Endereco.class).getResultList();		 
	}	

	public Endereco procurarIdCliente (int id){
		Endereco enderecoObjeto = new Endereco();
		enderecoObjeto =null;
		for (Endereco endereco :listagensEndereco()) {
			System.out.println(endereco.getEstado());
			if (endereco.getCliente().getIdCliente()==id) {				
				enderecoObjeto=endereco;
				
				break ;
			}
		}
		return enderecoObjeto;    	
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}



}
