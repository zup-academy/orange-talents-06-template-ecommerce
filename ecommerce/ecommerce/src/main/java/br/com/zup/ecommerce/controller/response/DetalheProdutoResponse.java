package br.com.zup.ecommerce.controller.response;

import java.math.BigDecimal;
import java.util.List;

import br.com.zup.ecommerce.model.produtos.CaracteristicasProduto;
import br.com.zup.ecommerce.model.produtos.Categoria;
import br.com.zup.ecommerce.model.produtos.Imagem;

public class DetalheProdutoResponse {
	private String nome;
	private BigDecimal valor;
	private Integer quantidade;
	private String descricao;
	private CaracteristicasProduto caracteristica;
	private Categoria categoria;
	private List<Imagem> imagem;

	private List<DetalheOpiniaoResponse> opiniao;
	private List<PerguntaDetalheResponse> pergunta;

	private UsuarioResponse usuario;
	private Float mediaProduto;

	public DetalheProdutoResponse(ProdutoResponse produto, List<DetalheOpiniaoResponse> opiniao,
			List<PerguntaDetalheResponse> pergunta, Float mediaProduto) {
		this.mediaProduto = mediaProduto;
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.quantidade = produto.getQuantidade();
		this.descricao = produto.getDescricao();
		this.caracteristica = produto.getCaracteristica();
		this.categoria = produto.getCategoria();
		this.imagem = produto.getImagem();
		this.opiniao = opiniao;
		this.pergunta = pergunta;
		this.usuario = produto.getUsuario();
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

	public List<DetalheOpiniaoResponse> getOpiniao() {
		return opiniao;
	}

	public List<PerguntaDetalheResponse> getPergunta() {
		return pergunta;
	}

	public UsuarioResponse getUsuario() {
		return usuario;
	}

	public Float getMediaProduto() {
		return mediaProduto;
	}

}
