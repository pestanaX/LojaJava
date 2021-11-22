package com.artcomsoft.sistemaloja.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;


@Repository 
@Entity
@Table (name="tb_Fornecidor",schema="loja")

public class Fornecidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fornecidor")
	private int idFornecidor;
	
	@Column(name="nome")
	private String nomeDoFornecidor;
	
	@Column(name="criado_por")
	private String criadoPor ; 
	
	@Column (name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name="modificado_por")
	private String modificadoPor;

	@Column (name="data_modificacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao;
    
	public Fornecidor() {
		
	}

	public int getIdFornecidor() {
		return idFornecidor;
	}

	public void setIdFornecidor(int idFornecidor) {
		this.idFornecidor = idFornecidor;
	}

	public String getNomeDoFornecidor() {
		return nomeDoFornecidor;
	}

	public void setNomeDoFornecidor(String nomeDoFornecidor) {
		this.nomeDoFornecidor = nomeDoFornecidor;
	}

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	

}
