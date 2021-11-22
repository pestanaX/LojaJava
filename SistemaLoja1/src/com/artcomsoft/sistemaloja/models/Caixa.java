package com.artcomsoft.sistemaloja.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_caixa", schema="loja")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public class Caixa extends Usuario{
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable (name="tabela_funcao_caixa" ,schema="loja",
	joinColumns = @JoinColumn (name="id_caixa") ,inverseJoinColumns=
	@JoinColumn(name="id_funcao"))
	List<Funcao> funcaoCaixa;
	public Caixa() {

	}


}
