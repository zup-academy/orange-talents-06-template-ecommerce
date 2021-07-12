package br.com.zup.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.zup.ecommerce.controller.response.CriarPedidoResponse;
import br.com.zup.ecommerce.controller.response.ProdutoVendaResponse;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;

@Entity
@Table(name = "pedido")
public class CriarPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pagamento;
	private LocalDateTime criacao;
		
	@OneToMany(mappedBy = "produto")
	private List<ProdutoVenda> produtoVenda;
		
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario comprador;

	public CriarPedido() {
		// TODO Auto-generated constructor stub
	}

	public CriarPedido(String pagamento, List<ProdutoVenda> pedidos, Usuario comprador) {
		this.pagamento = pagamento;
		this.criacao = LocalDateTime.now();
		this.produtoVenda = pedidos;
		this.comprador = comprador;
	}

	public Long getId() {
		return id;
	}

	public String getPagamento() {
		return pagamento;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public List<ProdutoVenda> getProdutoVenda() {
		return produtoVenda;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public CriarPedidoResponse converteModel(UsuarioResponse compradorResponse, List<ProdutoVendaResponse> produtoVendaResponse){
		return new CriarPedidoResponse(this.id, this.pagamento, produtoVendaResponse, compradorResponse);
		
	}

	public CriarPedido converteModel(List<ProdutoVenda> produtosVendaLista, Usuario usuarioRecuperado) {
		
		return new CriarPedido(this.pagamento, produtosVendaLista, usuarioRecuperado);
	}

	

}
