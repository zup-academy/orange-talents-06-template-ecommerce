package br.com.zup.ecommerce.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.ecommerce.model.Categoria;
import br.com.zup.ecommerce.validator.ValorUnico;

public class CategoriaRequest {

	@NotBlank
	@ValorUnico(domainClass = Categoria.class, fieldName = "nome", message = "Nome da categoria deve ser único.")
	private String nome;
	
	private Categoria categoria;

	public CategoriaRequest() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaRequest(String nome, Categoria categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Categoria toModel() {
		return new Categoria(this.nome, this.categoria);
	}

}
