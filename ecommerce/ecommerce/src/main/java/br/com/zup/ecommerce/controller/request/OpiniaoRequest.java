package br.com.zup.ecommerce.controller.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.ecommerce.model.Opiniao;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.validator.ExistsId;

public class OpiniaoRequest {
	@NotNull
	@Min(1) @Max(5)
	private Integer nota;
	@NotBlank @Max(500)
	private String descricao;
	@NotNull
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "Usuario não cadastrado")
	private Long usuario;
	@NotNull
	@ExistsId(domainClass = Produto.class, fieldName = "id", message = "Produto não cadastrado")
	private Long produto;
	public OpiniaoRequest(@NotNull @Min(1) @Max(5) Integer nota, @NotBlank String descricao, @NotNull Long usuario,
			@NotNull Long produto) {
		super();
		this.nota = nota;
		this.descricao = descricao;
		this.usuario = usuario;
		this.produto = produto;
	}
	public Integer getNota() {
		return nota;
	}
	public String getDescricao() {
		return descricao;
	}
	public Long getUsuario() {
		return usuario;
	}
	public Long getProduto() {
		return produto;
	}
	
	public Opiniao toModel(Usuario usuario, Produto produto) {
		return new Opiniao(this.nota, this.descricao, usuario, produto);
	}
	
	
}
