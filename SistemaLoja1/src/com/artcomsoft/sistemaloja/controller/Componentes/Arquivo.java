package com.artcomsoft.sistemaloja.controller.Componentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Arquivo {

	@Autowired
	private HttpServletRequest request;
	
	private String  criarPasta (String nomePasta) throws IOException {
		
		String caminhoActual = System.getProperty("user.dir"); 
		//String caminhoActual ="/"+"imagens";
		//String caminho =request.getServletContext().getRealPath("/");		
		//FacesContext conext = FacesContext.getCurrentInstance(); 
		System.out.println(caminhoActual);
        File dir = new File (".");
        File  file = new File (caminhoActual,nomePasta);
		if (!file.exists()) {
			file = new File (caminhoActual,nomePasta);
			file.mkdir();			
		}
		return file.getAbsolutePath();
	}
	public String criarArquivo (String nomeArquivo, String nomePasta , byte [] b ) throws IOException {

		String pasta = criarPasta(nomePasta);
		String caminho =pasta +"/"+nomeArquivo;
		OutputStream file  = new FileOutputStream (caminho);
		file.write(b);
		file.close();		
		return caminho ;
	}
}                  

