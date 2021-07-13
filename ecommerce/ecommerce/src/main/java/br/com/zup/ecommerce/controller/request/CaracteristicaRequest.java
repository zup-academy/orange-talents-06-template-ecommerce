package br.com.zup.ecommerce.controller.request;

import br.com.zup.ecommerce.model.produtos.CaracteristicasProduto;

public class CaracteristicaRequest {
	private String marca;
	private String modelo;
	private Integer quantidadeEmbalagem;
	public CaracteristicaRequest(String marca, String modelo, Integer quantidadeEmbalagem) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.quantidadeEmbalagem = quantidadeEmbalagem;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public Integer getQuantidadeEmbalagem() {
		return quantidadeEmbalagem;
	}
	public CaracteristicasProduto ToModel() {
		return new CaracteristicasProduto(this.marca, this.modelo, this.quantidadeEmbalagem);
	}
	
	
}
