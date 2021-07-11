package br.com.zup.ecommerce.controller.response;

import java.time.LocalDateTime;

public class PerguntaDetalheResponse {
	private Long id;
	private String titulo;
	private String usuario;
	private LocalDateTime criacao;
		
	public PerguntaDetalheResponse(Long id, String titulo, String usuario, 
			LocalDateTime criacao) {
		this.id = id;
		this.titulo = titulo;
		this.usuario = usuario;
		this.criacao = criacao;
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

	public LocalDateTime getCriacao() {
		return criacao;
	}
	
	
	
}
