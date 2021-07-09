package br.com.zup.ecommerce.controller.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zup.ecommerce.model.CaracteristicasProduto;
import br.com.zup.ecommerce.model.Categoria;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.validator.ExistsId;

public class ProdutoRequest {
	@NotBlank
	private String nome;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer=10, fraction=2)
	private BigDecimal valor;
	@NotNull
	@Min(1)
	private Integer quantidade;
	@NotBlank
	@Size(max=1000)
	private String descricao;
	//O produto possui pelo menos três características
	private CaracteristicaRequest caracteristica;
	@NotNull
	@ExistsId(domainClass = Produto.class,fieldName = "id", message = "Categoria deve ser previamente cadastrada")
	private Long categoria;

	public ProdutoRequest(String nome, BigDecimal valor, Integer quantidade, String descricao, 
			LocalDateTime registro, CaracteristicaRequest caracteristica, Long categoria) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.caracteristica = caracteristica;
		this.categoria = categoria;
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

	public CaracteristicaRequest getCaracteristica() {
		return caracteristica;
	}

	public Long getCategoria() {
		return categoria;
	}

	public Produto toModel(CaracteristicasProduto caracteristicaModel, Categoria categoriaModel) {
		return new Produto(this.nome, this.valor, this.quantidade, this.descricao, caracteristicaModel, categoriaModel);
	}

}
