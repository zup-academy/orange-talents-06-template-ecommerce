package br.com.zup.ecommerce.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.model.produtos.Pergunta;
import br.com.zup.ecommerce.model.produtos.Produto;
import br.com.zup.ecommerce.validator.ExistsId;

public class PerguntaRequest {
	@NotBlank
	private String titulo;
	@NotNull
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "Usuario não cadastrado")
	private Long usuario;
	@NotNull
	@ExistsId(domainClass = Produto.class, fieldName = "id", message = "Produto não cadastrado")
	private Long produto;

	public PerguntaRequest(@NotBlank String titulo,
			@NotNull @ExistsId(domainClass = Usuario.class, fieldName = "id", message = "Usuario não cadastrado") Long usuario,
			@NotNull @ExistsId(domainClass = Produto.class, fieldName = "id", message = "Produto não cadastrado") Long produto) {
		this.titulo = titulo;
		this.usuario = usuario;
		this.produto = produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getUsuario() {
		return usuario;
	}

	public Long getProduto() {
		return produto;
	}

	public Pergunta toModel(Usuario usuario, Produto produto) {
		return new Pergunta(this.titulo, usuario, produto);
	}

}
