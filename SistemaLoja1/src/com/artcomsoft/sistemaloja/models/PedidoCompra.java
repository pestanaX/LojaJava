package com.artcomsoft.sistemaloja.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class PedidoCompra {
	
	private int codigoPedido ;
	
	
	private String criadoPor; 
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column (name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private  Date dataCriacao; 

	private String modificador;	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column (name="data_modificacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao ;	


}
