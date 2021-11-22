package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.artcomsoft.sistemaloja.models.Administrador;
import com.artcomsoft.sistemaloja.models.Funcao;

//@Service("interfaceDao")

@Repository
public class AdiministradorDaoImpl implements InterfaceDao {
	@PersistenceContext 
	private EntityManager entity ;	

	@Override	
	public void salvarObjeto(Object obj) {
		// TODO Auto-generated method stub
		entity.persist(obj);
		//return false;
	}
	// Salva o Administrador e o seu relacionamento
	public void salvarObjetoR(Object obj , List <Funcao> funcoes) {
		try  {
			entity.getTransaction().begin(); 
			entity.persist(obj);
			entity.getTransaction().commit();
		} catch (Exception ex ) {
			entity.getTransaction().rollback();
            ex.printStackTrace();   
		}
	} 
	@Override
	public void atualizarObjeto(Object obj) {
		// TODO Auto-generated method stub
		this.entity.merge((Administrador)obj);
	}
	@Override
	public Object getId(int id) {
		// TODO Auto-generated method stub
		return (Administrador) this.entity.find(Administrador.class, id);
	}
	// Metodo para listar todas a Funcionalidades do Sistema
	public List<Administrador> listagensObjeto() {		
		return this.entity.createQuery("from Administrador",Administrador.class).getResultList();		 
	}	
	@Override
	public Object getDescricao(String descricao) {
		return null ;
	}
	public Administrador  procurarAdministrador (String nomeUsuario){
		Administrador administradorObjeto= new Administrador();
		administradorObjeto =null;
		for (Administrador user :listagensObjeto()) {
			if (user.getNomeUsuario().equals (nomeUsuario)) {
				administradorObjeto  =user;
				break ;
			}
		}
		return administradorObjeto;

	}

}
