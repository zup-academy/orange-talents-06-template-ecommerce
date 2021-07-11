package br.com.zup.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.zup.ecommerce.controller.response.PerguntaResponse;
import br.com.zup.ecommerce.controller.response.ProdutoResponse;

@Entity
public class Pergunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	private LocalDateTime criacao;

	public Pergunta() {
		// TODO Auto-generated constructor stub
	}

	public Pergunta(String titulo, Usuario usuario, Produto produto) {
		this.titulo = titulo;
		this.usuario = usuario;
		this.produto = produto;
		this.criacao = LocalDateTime.now();
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public PerguntaResponse ConverteResponse() {
		return new PerguntaResponse(this.id, this.titulo, this.usuario.getUsuario(), this.produto.getNome(),
				this.produto.getDescricao(), this.criacao, this.produto.getUsuario().getUsuario());
	}

}
