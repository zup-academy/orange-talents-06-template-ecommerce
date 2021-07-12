package br.com.zup.ecommerce.controller.response;

import java.util.List;

public class CriarPedidoResponse {
	private Long id;
	private String pagamento;
	private List<ProdutoVendaResponse> vendas;
	private UsuarioResponse comprador;

	public CriarPedidoResponse(Long id, String pagamento, List<ProdutoVendaResponse> vendas, UsuarioResponse comprador) {
		this.id = id;
		this.pagamento = pagamento;
		this.vendas = vendas;
		this.comprador = comprador;
	}

	public Long getId() {
		return id;
	}

	public String getPagamento() {
		return pagamento;
	}

	public List<ProdutoVendaResponse> getVendas() {
		return vendas;
	}

	public UsuarioResponse getComprador() {
		return comprador;
	}

}
