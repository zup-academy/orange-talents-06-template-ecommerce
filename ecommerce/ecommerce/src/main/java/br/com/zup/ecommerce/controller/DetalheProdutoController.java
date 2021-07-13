package br.com.zup.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ecommerce.controller.response.DetalheOpiniaoResponse;
import br.com.zup.ecommerce.controller.response.DetalheProdutoResponse;
import br.com.zup.ecommerce.controller.response.PerguntaDetalheResponse;
import br.com.zup.ecommerce.controller.response.ProdutoResponse;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;
import br.com.zup.ecommerce.model.produtos.Opiniao;
import br.com.zup.ecommerce.model.produtos.Pergunta;
import br.com.zup.ecommerce.model.produtos.Produto;
import br.com.zup.ecommerce.repository.OpiniaoRepository;
import br.com.zup.ecommerce.repository.PerguntaRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("/detalhes")
public class DetalheProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private OpiniaoRepository opiniaoRepository;
	@Autowired
	private PerguntaRepository perguntaRepository;

	@GetMapping("/{id}")
	public ResponseEntity<DetalheProdutoResponse> buscarPeloId(@PathVariable Long id) {
		Optional<Produto> produtoRecuperado = produtoRepository.findById(id);
		Produto produto = produtoRecuperado.get();
		UsuarioResponse usuarioResponse = produto.getUsuario().ConverteResponse();
		ProdutoResponse responseProduto = produto.converterModel(usuarioResponse);

		List<DetalheOpiniaoResponse> listaOpinioes = recuperaOpiniao(produto, responseProduto);
		List<PerguntaDetalheResponse> listaPerguntas = recuperaResposta(produto);
		float mediaCalculada = CalculaMedia(listaOpinioes);
		DetalheProdutoResponse response = new DetalheProdutoResponse(responseProduto, listaOpinioes, listaPerguntas,
				mediaCalculada);
		return produtoRecuperado.isPresent() ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
	}

	public List<DetalheOpiniaoResponse> recuperaOpiniao(Produto produto, ProdutoResponse response) {
		List<DetalheOpiniaoResponse> listaresponse = new ArrayList<>();
		List<Opiniao> listaOpiniao = opiniaoRepository.produto(produto);
		if (listaOpiniao.isEmpty())
			return null;
		for (Opiniao opiniao : listaOpiniao) {
			listaresponse.add(new DetalheOpiniaoResponse(opiniao.getId(), opiniao.getNota(), opiniao.getDescricao(),
					opiniao.getUsuario().getUsuario(), opiniao.getUsuario().getEmail()));
		}
		return listaresponse;
	}

	public List<PerguntaDetalheResponse> recuperaResposta(Produto produto) {
		List<PerguntaDetalheResponse> listaresponse = new ArrayList<>();
		List<Pergunta> listaPergunta = perguntaRepository.produto(produto);
		if (listaPergunta.isEmpty())
			return null;
		for (Pergunta resposta : listaPergunta) {
			listaresponse.add(new PerguntaDetalheResponse(resposta.getId(), resposta.getTitulo(),
					resposta.getUsuario().getUsuario(), resposta.getCriacao()));
		}
		return listaresponse;
	}

	public float CalculaMedia(List<DetalheOpiniaoResponse> listaOpinioes) {
		int soma = 0;
		int cont = 0;

		if (listaOpinioes.isEmpty())
			return 0;
		for (DetalheOpiniaoResponse opiniao : listaOpinioes) {
			soma = opiniao.getNota() + soma;
			cont++;
		}
		return (soma / cont);
	}

}
