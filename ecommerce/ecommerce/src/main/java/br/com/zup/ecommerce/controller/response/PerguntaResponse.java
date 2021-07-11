package br.com.zup.ecommerce.controller.response;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.zup.ecommerce.model.Pergunta;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.model.Usuario;

public class PerguntaResponse {

	private Long id;
	private String titulo;
	private String usuario;
	private String produto;
	private String descricao;
	private LocalDateTime criacao;
	private String usuarioProduto;
	
	
	public PerguntaResponse(Long id, String titulo, String usuario, String produto, String descricao,
			LocalDateTime criacao, String usuarioProduto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.usuario = usuario;
		this.produto = produto;
		this.descricao = descricao;
		this.criacao = criacao;
		this.usuarioProduto = usuarioProduto;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getProduto() {
		return produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public String getUsuarioProduto() {
		return usuarioProduto;
	}
}
