package br.com.zup.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zup.ecommerce.controller.response.ImagemResponse;

@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imagem;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Imagem() {
		// TODO Auto-generated constructor stub
	}
	
	public Imagem(String imagens, Produto produto) {
		this.imagem = imagens;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public String getImagem() {
		return imagem;
	}

	public Produto getProduto() {
		return produto;
	}
	public ImagemResponse converteModel() {
		return new ImagemResponse(this.id, this.imagem, this.produto);
	}

}
