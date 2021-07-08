package br.com.zup.ecommerce.controller.response;

import java.util.List;

public class CategoriaResponse {
	private Long id;
	private String nome;
	private List<String> nomeCategoria;
	
	public CategoriaResponse(Long id, String nome, List<String> nomeCategoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeCategoria = nomeCategoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getNomeCategoria() {
		return nomeCategoria;
	}
	
	
	
}
