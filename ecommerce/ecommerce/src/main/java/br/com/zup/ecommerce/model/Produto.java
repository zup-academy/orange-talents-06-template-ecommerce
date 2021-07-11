package br.com.zup.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.zup.ecommerce.controller.response.ProdutoResponse;

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

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "caracteristica_id")
	private CaracteristicasProduto caracteristicas;

	@OneToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@OneToMany(mappedBy = "produto")
	private List<Imagem> imagens;
	
	@OneToMany(mappedBy = "produto")
	private List<Opiniao> opinioes;
	
	@OneToMany(mappedBy = "produto")
	private List<Pergunta> perguntas;
	
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao,
			CaracteristicasProduto caracteristicas, Categoria categoria, List<Imagem> imagens,
			Usuario usuario) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.registro = LocalDateTime.now();
		this.caracteristicas = caracteristicas;
		this.categoria = categoria;
		this.imagens = imagens;
		this.usuario = usuario;
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

	public List<Imagem> getImagens() {
		return imagens;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}
	
	public List<Opiniao> getOpinioes() {
		return opinioes;
	}

	public ProdutoResponse converterModel() {
		return new ProdutoResponse(this.nome, this.valor, this.quantidade, this.descricao, caracteristicas, categoria,
				imagens, usuario);
	}

}
