package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artcomsoft.sistemaloja.models.Endereco;
import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.ImagenProduto;

@Repository
public class ImagemDao  implements  InterfaceDao{

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
		return (ImagenProduto) this.entity.find(ImagenProduto.class, id);
	}

	@Override
	public Object getDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<ImagenProduto> listagensImagens() {		
		return this.entity.createQuery("from ImagenProduto",ImagenProduto.class).getResultList();		 
	}
	public ImagenProduto procurarIdProduto (int id){
		ImagenProduto imagemObjeto = new ImagenProduto();
		imagemObjeto =null;
		for (ImagenProduto img :listagensImagens()) {
			if (img.getProduto().getIdProduto()==id) {				
				imagemObjeto=img;				
				break ;
			}
		}
		return imagemObjeto;    	
	}

}
