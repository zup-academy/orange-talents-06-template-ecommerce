package br.com.zup.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_mae")
	private Categoria vinculoCategoria;

	public Categoria() {
	}

	public Categoria(String nome, Categoria vinculoCategoria) {
		this.nome = nome;
		this.vinculoCategoria = vinculoCategoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getVinculoCategoria() {
		return vinculoCategoria;
	}

}
