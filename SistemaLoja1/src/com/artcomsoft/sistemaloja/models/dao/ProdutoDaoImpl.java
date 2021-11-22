package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.Produto;

@Repository
public class ProdutoDaoImpl  implements InterfaceDao{
	
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
		return (Produto) this.entity.find(Produto.class, id);
	}
    
	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Produto> listagensProduto() {		
		return this.entity.createQuery("from Produto",Produto.class).getResultList();		 
	}
	public Produto descricaoProduto (String descricao){
		Produto produtoObjeto= new Produto  ();
		produtoObjeto =null;
		for (Produto produto :listagensProduto()) {
			if (produto.getDescricaoProduto().equals (descricao)) {
				produtoObjeto =produto;
				break ;
			}
		}
		return produtoObjeto;

	}
	public Produto codigoProduto (String codigo){
		Produto produtoObjeto= new Produto  ();
		produtoObjeto =null;
		for (Produto produto :listagensProduto()) {
			if (produto.getCodigoProduto().equals (codigo)) {
				produtoObjeto =produto;
				break ;
			}
		}
		return produtoObjeto;

	}

}
