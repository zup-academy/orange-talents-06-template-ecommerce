package br.com.zup.ecommerce.controller.request;

import java.util.List;

import br.com.zup.ecommerce.controller.response.ProdutoVendaResponse;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;
import br.com.zup.ecommerce.model.CriarPedido;
import br.com.zup.ecommerce.model.ProdutoVenda;
import br.com.zup.ecommerce.model.Usuario;

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
