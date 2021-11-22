package com.artcomsoft.sistemaloja.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;


@Repository 
@Entity
@Table (name="tb_funcao",schema="loja")
public class Funcao{

	@Id 
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private int id_funcao; 
	private String descricao ;
	private String criador;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column (name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private  Date dataCriacao; 

	private String modificador;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column (name="data_modificacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao ;	
    
	@ManyToMany	(fetch=FetchType.LAZY )
	@JoinTable (name="tabela_funcao_admin",schema="loja",
    joinColumns =@JoinColumn(name="id_funcao" ),inverseJoinColumns= @JoinColumn(name="id_administrador"))
	
	private List <Administrador> admin;
	
	public Funcao () {
		
	}
	public Funcao(String descricao, String criador) {
		super();
		this.descricao = descricao;
		this.criador = criador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_funcao() {
		return id_funcao;
	}

	public void setId_funcao(int id_funcao) {
		this.id_funcao = id_funcao;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		this.modificador = modificador;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public List<Administrador> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Administrador> admin) {
		this.admin = admin;
	}

	
}
