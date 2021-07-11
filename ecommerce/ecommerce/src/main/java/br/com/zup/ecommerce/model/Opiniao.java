package br.com.zup.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zup.ecommerce.controller.response.OpiniaoResponse;
import br.com.zup.ecommerce.controller.response.ProdutoResponse;

@Entity
public class Opiniao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nota;
	private String descricao;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Opiniao() {
	}

	public Opiniao(Integer nota, String descricao, Usuario usuario, Produto produto) {
		this.nota = nota;
		this.descricao = descricao;
		this.usuario = usuario;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public Integer getNota() {
		return nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	
	public OpiniaoResponse converteOpinicao(Opiniao opiniaoSalvo, ProdutoResponse produtoResponse) {
		// TODO Auto-generated method stub
		return new OpiniaoResponse(this.id, this.nota, this.descricao, produtoResponse, this.usuario);
	}

}
