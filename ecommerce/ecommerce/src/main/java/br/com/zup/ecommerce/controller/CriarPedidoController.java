package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.ecommerce.controller.request.CriarPedidoRequest;
import br.com.zup.ecommerce.controller.request.ProdutoVendaRequest;
import br.com.zup.ecommerce.controller.response.CriarPedidoResponse;
import br.com.zup.ecommerce.controller.response.ProdutoVendaResponse;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.model.carrinho.CriarPedido;
import br.com.zup.ecommerce.model.carrinho.ProdutoVenda;
import br.com.zup.ecommerce.model.produtos.Produto;
import br.com.zup.ecommerce.repository.CriarPedidoRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/compras")
public class CriarPedidoController {
	@Autowired
	private CriarPedidoRepository criarPedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	private List<CriarPedido> listar() {
		return criarPedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CriarPedidoResponse> buscarPeloCodigo(@PathVariable Long id) {

		Optional<CriarPedido> pedidoRecuperado = criarPedidoRepository.findById(id);
		CriarPedido pedidoSalvo = pedidoRecuperado.get();

		Usuario comprador = recuperaUsuario(pedidoSalvo.getComprador().getId());
		UsuarioResponse compradorResponse = comprador.ConverteResponse();

		List<ProdutoVendaResponse> listaProdutoVendaResponse = new ArrayList<>();
		List<ProdutoVenda> produtosVendaLista = pedidoSalvo.getProdutoVenda();

		for (ProdutoVenda produtoVenda : produtosVendaLista) {
			ProdutoVendaResponse converte = produtoVenda.converterSemProduto(produtoVenda.getProduto().getDescricao(),
					produtoVenda.getProduto().getNome());

			listaProdutoVendaResponse.add(converte);
		}

		CriarPedidoResponse response = pedidoSalvo.converteModel(compradorResponse, listaProdutoVendaResponse);
		return pedidoRecuperado.isPresent() ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<CriarPedidoResponse> criar(@Valid @RequestBody CriarPedidoRequest request,
			HttpServletResponse response) {

		Usuario usuarioRecuperado = recuperaUsuario(request.getComprador());

		List<ProdutoVenda> produtosVendaLista = new ArrayList<>();
		List<ProdutoVendaResponse> produtoVendaResponse = new ArrayList<>();
		List<ProdutoVendaRequest> produtoVendaModel = request.getVendas();

		for (ProdutoVendaRequest produtoVenda : produtoVendaModel) {
			Produto produto = recuperaProduto(produtoVenda.getIdProduto());
			ProdutoVenda produtoModel = produtoVenda.toModel(produtoVenda.getQuantidade(), produto);
			produtosVendaLista.add(produtoModel);
		}

		CriarPedido criarPedidoModel = request.ToModel(usuarioRecuperado, produtosVendaLista);
		CriarPedido opiniaoSalvo = criarPedidoRepository.save(criarPedidoModel);

		UsuarioResponse usuarioResponse = opiniaoSalvo.getComprador().ConverteResponse();

		List<ProdutoVendaResponse> listaProdutoVendaResponse = new ArrayList<>();
		List<ProdutoVenda> produtosVendas = produtosVendaLista;

		for (ProdutoVenda produtoVenda : produtosVendas) {
			ProdutoVendaResponse converte = produtoVenda.converterSemProduto(produtoVenda.getProduto().getDescricao(),
					produtoVenda.getProduto().getNome());

			listaProdutoVendaResponse.add(converte);
		}

		CriarPedidoResponse responsePedidoResponse = opiniaoSalvo.converteModel(usuarioResponse,
				listaProdutoVendaResponse);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(responsePedidoResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(responsePedidoResponse);
	}

	public Usuario recuperaUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	public Produto recuperaProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

}
