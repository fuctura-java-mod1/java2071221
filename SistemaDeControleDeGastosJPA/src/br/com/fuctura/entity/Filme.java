package br.com.fuctura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	private String nome;
	private Integer duracao;
	@Column(name = "youtubeLink", length = 100, nullable = true)
	private String linkDoVideoNoYoutube;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getLinkDoVideoNoYoutube() {
		return linkDoVideoNoYoutube;
	}

	public void setLinkDoVideoNoYoutube(String linkDoVideoNoYoutube) {
		this.linkDoVideoNoYoutube = linkDoVideoNoYoutube;
	}

}
