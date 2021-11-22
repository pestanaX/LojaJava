package com.artcomsoft.sistemaloja.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
  
@Table (name="tabela_funcao_admin",schema="loja")
public class FuncaoAdiministrador {

	@EmbeddedId
	private FuncaoAdministradorPK chaveComposta;

	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;

	public FuncaoAdministradorPK getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(FuncaoAdministradorPK chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


}
