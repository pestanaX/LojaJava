package com.artcomsoft.sistemaloja.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Repository;


@Repository 
@Entity
@Table (name="tb_categoria",schema="loja")
public class Categoria implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id_categoria")
	private int idCategoria;

	@Column(name="descricao",length =20,nullable=false)
	private String descricaoCategoria; 

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
	
	@OneToMany(mappedBy="categoria")		
    private List<Produto> produtos; 
	
    public Categoria () {

	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	public String getCriadoPor() {
		return criadoPor;
	}
	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}
	public String getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

}
