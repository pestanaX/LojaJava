package com.artcomsoft.sistemaloja.models;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable 
public class FuncaoAdministradorPK {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_funcao")
	private Funcao funcao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_administrator")
	private Administrador adm;

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}
	
}
