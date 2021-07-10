package br.com.zup.ecommerce.controller.response;

import java.math.BigDecimal;
import java.util.List;

import br.com.zup.ecommerce.model.CaracteristicasProduto;
import br.com.zup.ecommerce.model.Categoria;
import br.com.zup.ecommerce.model.Imagem;
import br.com.zup.ecommerce.model.Usuario;

public class ProdutoResponse {

	private String nome;
	private BigDecimal valor;
	private Integer quantidade;
	private String descricao;
	private CaracteristicasProduto caracteristica;
	private Categoria categoria;
	private List<Imagem> imagem;
	private Usuario usuario;
	
	public ProdutoResponse(String nome, BigDecimal valor, Integer quantidade, String descricao,
			CaracteristicasProduto caracteristica, Categoria categoria, List<Imagem> imagem,
			Usuario usuario) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.caracteristica = caracteristica;
		this.categoria = categoria;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public CaracteristicasProduto getCaracteristica() {
		return caracteristica;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public List<Imagem> getImagem() {
		return imagem;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	
}
