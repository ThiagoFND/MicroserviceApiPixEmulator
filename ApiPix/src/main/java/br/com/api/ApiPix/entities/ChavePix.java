package br.com.api.ApiPix.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChavePix {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	// private Usuario usuario;

	private String chave;
	private String tipo;
	private Date dataCriacao;

	public ChavePix(String id, String chave, String tipo, Date dataCriacao) {
		super();
		this.id = id;
		this.chave = chave;
		this.tipo = tipo;
		this.dataCriacao = dataCriacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public Usuario getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	 */
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chave, dataCriacao, id, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChavePix other = (ChavePix) obj;
		return Objects.equals(chave, other.chave) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(id, other.id) && Objects.equals(tipo, other.tipo);
	}

}
