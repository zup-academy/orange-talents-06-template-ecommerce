package br.com.zup.ecommerce.controller.response;

public class OpiniaoResponse {
	private Long id;
	private Integer nota;
	private String descricao;
	private ProdutoResponse produto;
	private UsuarioResponse usuarioOpiniao;

	public OpiniaoResponse(Long id, Integer nota, String descricao, ProdutoResponse produto, UsuarioResponse usuarioOpiniao) {
		this.id = id;
		this.nota = nota;
		this.descricao = descricao;
		this.produto = produto;
		this.usuarioOpiniao = usuarioOpiniao;
	}

	public Long getId() {
		return id;
	}

	public Integer getNota() {
		return nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public ProdutoResponse getProduto() {
		return produto;
	}
	public UsuarioResponse getUsuario() {
		return usuarioOpiniao;
	}

}
