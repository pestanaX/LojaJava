package com.artcomsoft.sistemaloja.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.controller.Componentes.Arquivo;
import com.artcomsoft.sistemaloja.models.ImagenProduto;
import com.artcomsoft.sistemaloja.models.Produto;
import com.artcomsoft.sistemaloja.models.dao.ImagemDao;

@Controller
@Transactional
public class ImagemController {

	@Autowired 
	private ImagemDao imagemDao;
	@Autowired 
	private  ImagenProduto imagemProduto;
	@Autowired 
	private Arquivo arquivo1;
	

	@RequestMapping("/Imagem")
	private String formImagem() {
		return "Funciolanidades/CadrastramentoProduto/ImagemProduto";
	}

	@RequestMapping(value="/imagenProduto", method = RequestMethod.POST)
	public ModelAndView save( @RequestParam("id") int id ,@RequestParam("file") MultipartFile file,
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3) throws IOException {		
		byte b[] = file.getBytes();
		byte b1[]= file1.getBytes();
		byte b2[]=file2.getBytes();
		byte b3[]=file3.getBytes();
		arquivo1= new Arquivo();
		imagemProduto =  new ImagenProduto();
		imagemProduto.setProduto(new Produto(id));
		imagemProduto.setImagemPrincipal(arquivo1.criarArquivo(file.getOriginalFilename(), "imagem2", b));
		imagemProduto.setImagem1(arquivo1.criarArquivo(file1.getOriginalFilename(), "imagem2", b1));
		imagemProduto.setImagem2(arquivo1.criarArquivo(file2.getOriginalFilename(), "imagem2", b2));
		imagemProduto.setImagem3(arquivo1.criarArquivo(file3.getOriginalFilename(), "imagem2", b3));
		imagemDao.salvarObjeto(imagemProduto);
		return new ModelAndView();
	}
	@RequestMapping(value="/imagemAlterar", method = RequestMethod.POST)
	public ModelAndView atualizar(@RequestParam("id") int id,@RequestParam("idProduto") int idProduto ,@RequestParam("file") MultipartFile file,
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3) throws IOException {		
		byte b[] = file.getBytes();
		byte b1[]= file1.getBytes();
		byte b2[]=file2.getBytes();
		byte b3[]=file3.getBytes();
		arquivo1= new Arquivo();
		imagemProduto =  new ImagenProduto();
		imagemProduto.setIdImagem(id);
		imagemProduto.setProduto(new Produto(idProduto));
		imagemProduto.setImagemPrincipal(arquivo1.criarArquivo(file.getOriginalFilename(), "imagem2", b));
		imagemProduto.setImagem1(arquivo1.criarArquivo(file1.getOriginalFilename(), "imagem2", b1));
		imagemProduto.setImagem2(arquivo1.criarArquivo(file2.getOriginalFilename(), "imagem2", b2));
		imagemProduto.setImagem3(arquivo1.criarArquivo(file3.getOriginalFilename(), "imagem2", b3));
		imagemDao.atualizarObjeto(imagemProduto);
        System.out.println("ffdfdf"); 
		return new ModelAndView();
	}


} 
