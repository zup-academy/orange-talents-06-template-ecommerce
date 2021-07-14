package br.com.zup.ecommerce.model.produtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristica")
public class CaracteristicasProduto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Integer quantidadeEmbalagem;
	
	@OneToOne(mappedBy = "caracteristicas")
	private Produto produto;
	
	public CaracteristicasProduto() {}
	
	public CaracteristicasProduto(String marca, String modelo, Integer quantidadeEmbalagem) {
		this.marca = marca;
		this.modelo = modelo;
		this.quantidadeEmbalagem = quantidadeEmbalagem;
	}
	
	public Long getId() {
		return id;
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
	
	
}
