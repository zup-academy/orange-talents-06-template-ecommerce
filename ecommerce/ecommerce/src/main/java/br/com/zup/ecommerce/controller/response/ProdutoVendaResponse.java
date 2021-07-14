package br.com.zup.ecommerce.controller.response;

import java.math.BigDecimal;

public class ProdutoVendaResponse {

	private Long id;
	private Integer quantidade;
	private BigDecimal valor;
	private String nomeProduto;
	private String descricaoProduto;
	
	//ProdutoResponse produto;

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public ProdutoVendaResponse(Long id, Integer quantidade, BigDecimal valor,
			String nomeProduto, String descricaoProduto) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		//this.produto = produto;
	}
	
	public ProdutoVendaResponse(Long id, Integer quantidade, BigDecimal valor) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	

}
