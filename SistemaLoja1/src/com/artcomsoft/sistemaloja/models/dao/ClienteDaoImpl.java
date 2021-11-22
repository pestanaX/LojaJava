package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.Funcao;

@Repository
public class ClienteDaoImpl  implements InterfaceDao{

	@PersistenceContext 
	private EntityManager entity ;	

	@Override
	public void salvarObjeto(Object obj) {
		// TODO Auto-generated method stub
		entity.persist(obj);
	}
	public int salvarObjeto (Cliente obj) {
		entity.persist(obj);		
		return obj.getIdCliente();		
	}
	@Override
	public void atualizarObjeto(Object obj) {
		// TODO Auto-generated method stub
		this.entity.merge((Cliente)obj);
	}
	@Override
	public Object getId(int id) {
		// TODO Auto-generated method stub
		return (Cliente) this.entity.find(Cliente.class, id);
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Cliente> listagensCliente() {		
		return this.entity.createQuery("from Cliente",Cliente.class).getResultList();		 
	}	

	public Cliente procurarSenha(String senha) {
		Cliente clienteObjeto= new Cliente();
		clienteObjeto =null;
		for (Cliente user :listagensCliente()) {
			if (user.getSenha().equals (senha)) {
				clienteObjeto  =user;
				break ;
			}
		}
		return clienteObjeto;
	}
	public Cliente  procurarClienteEmail (String email){
		Cliente clienteObjeto= new Cliente();
		clienteObjeto =null;
		for (Cliente user :listagensCliente()) {
			if (user.getEmail().equals (email)) {
				clienteObjeto  =user;
				break ;
			}
		}
		return clienteObjeto;    	
	}
}