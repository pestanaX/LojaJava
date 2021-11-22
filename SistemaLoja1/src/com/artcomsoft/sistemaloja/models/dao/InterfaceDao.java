package com.artcomsoft.sistemaloja.models.dao;

import java.util.List;


import org.springframework.stereotype.Service;


import com.artcomsoft.sistemaloja.models.Funcao;


//@Service 
public interface InterfaceDao {
	 
        public void salvarObjeto(Object obj);
        public void atualizarObjeto(Object obj);
        public Object getId(int id);
        public Object getDescricao(String descricao);
        
        
        // public Object procurarDescricao(String descricaoObj);
        //public List listagensObjeto(Object obj );
}
