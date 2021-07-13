package br.com.zup.ecommerce.controller.request;

import java.util.List;

import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.model.carrinho.CriarPedido;
import br.com.zup.ecommerce.model.carrinho.ProdutoVenda;

public class CriarPedidoRequest {

	private String pagamento;
	private List<ProdutoVendaRequest> vendas;
	private Long comprador;

	public CriarPedidoRequest(String pagamento, List<ProdutoVendaRequest> vendas, Long comprador) {
		this.pagamento = pagamento;
		this.vendas = vendas;
		this.comprador = comprador;
	}

	public String getPagamento() {
		return pagamento;
	}

	public List<ProdutoVendaRequest> getVendas() {
		return vendas;
	}

	public Long getComprador() {
		return comprador;
	}

	public CriarPedido ToModel(Usuario usuarioRecuperado, List<ProdutoVenda> vendasProdutos) {
		return new CriarPedido(this.pagamento, vendasProdutos, usuarioRecuperado);
	}

}
