package br.com.zup.ecommerce.controller.request;

import java.math.BigDecimal;

import br.com.zup.ecommerce.controller.response.ProdutoVendaResponse;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.model.ProdutoVenda;

public class ProdutoVendaRequest {
	private Integer quantidade;
	private Long idProduto;

	// private String pagamento;

	public ProdutoVendaRequest(Integer quantidade, Long idProduto) {

		this.quantidade = quantidade;
		this.idProduto = idProduto;

	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public ProdutoVenda toModel(Integer quantidade, Produto produto) {
		return new ProdutoVenda(quantidade, produto.getValor(), produto);
	}

	public ProdutoVendaResponse toResponse(Produto produto) {
		return new ProdutoVendaResponse(produto.getId(), produto.getQuantidade(), produto.getValor(),
				produto.getNome(), produto.getDescricao());
	}

}
