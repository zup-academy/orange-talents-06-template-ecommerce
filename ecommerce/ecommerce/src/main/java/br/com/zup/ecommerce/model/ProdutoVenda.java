package br.com.zup.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.ecommerce.controller.response.ProdutoResponse;
import br.com.zup.ecommerce.controller.response.ProdutoVendaResponse;

@Entity
@Table(name = "venda")
public class ProdutoVenda {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantidade;
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public ProdutoVenda() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public ProdutoVenda(Integer quantidade, BigDecimal valor, Produto produto) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.produto = produto;
	}

	public ProdutoVendaResponse converterSemProduto(String descricao, String nome) {
		return new ProdutoVendaResponse(this.id, this.quantidade, this.valor, descricao, nome);
	}
	
	public ProdutoVenda toModel(Produto produto) {
		return new ProdutoVenda(this.quantidade, this.valor, produto); 
	}
	
	
	
	
	

}
