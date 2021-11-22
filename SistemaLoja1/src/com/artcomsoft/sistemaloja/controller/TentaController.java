package com.artcomsoft.sistemaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artcomsoft.sistemaloja.models.Tenta;
import com.artcomsoft.sistemaloja.models.dao.TentaDao;

@Controller
@Transactional
public class TentaController {
	
	@Autowired
	private TentaDao tentaDao = new TentaDao();
    
	@RequestMapping("/tenta")
	private String tentaIndex() {
		 return "FormularioFuncao/Tenta";
	}	
	@RequestMapping("/inputTenta")
	private String salvarObjeto(Tenta tenta) {
		
		tentaDao.salvarObjeto(tenta);               
		return "FormularioFuncao/ok";
		
	}

}
