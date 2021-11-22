package com.artcomsoft.sistemaloja.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="tb_admin", schema="loja")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Administrador extends Usuario {
	
    //@Transient 	
    //private String confirmarSenha;
	
	@ManyToMany	(fetch=FetchType.LAZY)
    @JoinTable (name="tabela_funcao_admin" ,schema="loja",
    joinColumns = @JoinColumn (name="id_administrator") ,inverseJoinColumns=
    @JoinColumn(name="id_funcao"))
	//@ManyToMany (mappedBy="")
	List <Funcao>  funcaoAdministrador;
    public Administrador () {}
    
	public List<Funcao> getFuncaoAdministrador() {
		return funcaoAdministrador;
	}
	public void setFuncaoAdministrador(List<Funcao> funcaoAdministrador) {
		this.funcaoAdministrador = funcaoAdministrador;
	}

}
