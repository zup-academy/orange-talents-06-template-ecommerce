package br.com.zup.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private BigDecimal valor;
	private Integer quantidade;
	private String descricao;
	private LocalDateTime registro;

	@OneToOne
	@JoinColumn(name = "caracteristica_id")
	private CaracteristicasProduto caracteristicas;

	@OneToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	/*
	 * @OneToMany(mappedBy = "produto") private List<Categoria> categoria;
	 */

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao,
			CaracteristicasProduto caracteristicas, Categoria categoria) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.registro = LocalDateTime.now();
		this.caracteristicas = caracteristicas;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getRegistro() {
		return registro;
	}

	public CaracteristicasProduto getCaracteristicas() {
		return caracteristicas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
