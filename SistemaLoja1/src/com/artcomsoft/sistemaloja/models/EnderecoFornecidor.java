package com.artcomsoft.sistemaloja.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Repository 
@Entity
@Table (name="tb_EnderecoFornecidor",schema="loja")

public class EnderecoFornecidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column (length =20,nullable=false)
	private String estado;
	@Column (length =20,nullable=false)
	private String municipio;
	@Column (length =20,nullable=false)
	private String bairro ;
	@Column (length =20,nullable=false)
	private String rua ;
	@Column (length =20,nullable=false)
	private String numeroDaCasa ;
	
	private String complementar;
	
	@Column (length =30 , nullable =false)
	private String cpf;
	@Column (length =30 , nullable =false)
	private String celular;
	
	private String telefone;
	
	private String email;
	
	@Column (name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;	
	
	@Column (name="data_modificacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao;
	
 	@OneToOne (cascade=CascadeType.DETACH)
 	@JoinColumn (name ="id_fornecidor")	
 	private Fornecidor  fornecidor ;
    
 	public EnderecoFornecidor () {
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}
	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}
	public String getComplementar() {
		return complementar;
	}
	public void setComplementar(String complementar) {
		this.complementar = complementar;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Fornecidor getFornecidor() {
		return fornecidor;
	}
	public void setFornecidor(Fornecidor fornecidor) {
		this.fornecidor = fornecidor;
	}
    
    
}
