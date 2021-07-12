package br.com.zup.ecommerce.controller.response;

import br.com.zup.ecommerce.model.CaracteristicasProduto;

public class ProdutoResumoResponse {
	private String nome;
	//private BigDecimal valor;
	//private Integer quantidade;
	private String descricao;
	private CaracteristicasProduto caracteristica;
	//private Categoria categoria;
	//private List<Imagem> imagem;
	private UsuarioResponse vendedor;
	
	
	public ProdutoResumoResponse(String nome, String descricao, CaracteristicasProduto caracteristica,
			UsuarioResponse vendedor) {
		this.nome = nome;
		this.descricao = descricao;
		this.caracteristica = caracteristica;
		this.vendedor = vendedor;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public CaracteristicasProduto getCaracteristica() {
		return caracteristica;
	}
	public UsuarioResponse getUsuario() {
		return vendedor;
	}
	
	
	
	
}
