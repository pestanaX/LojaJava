
package com.artcomsoft.sistemaloja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity 
@Table(name ="tb_tenta", schema="loja")
public class Tenta {

	@Id 
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private int id;
	private String  tenta;
	private String  commentario;

	public String getCommentario() {
		return commentario;
	}

	public void setCommentario(String commentario) {
		this.commentario = commentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenta() {
		return tenta;
	}

	public void setTenta(String tenta) {
		this.tenta = tenta;
	}

	@Override
	public String toString() {
		return "Tenta [tenta=" + tenta + "]";
	}


}
