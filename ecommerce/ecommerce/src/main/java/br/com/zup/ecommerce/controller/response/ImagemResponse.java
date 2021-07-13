package br.com.zup.ecommerce.controller.response;

import br.com.zup.ecommerce.model.produtos.Produto;

public class ImagemResponse {
	
	private Long id;
	private String imagem;
	private Produto produto;
	public ImagemResponse(Long id, String imagem, Produto produto) {
		super();
		this.id = id;
		this.imagem = imagem;
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
	
	

}
