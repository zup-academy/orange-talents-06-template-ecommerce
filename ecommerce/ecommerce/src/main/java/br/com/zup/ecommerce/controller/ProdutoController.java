package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.ecommerce.controller.request.CaracteristicaRequest;
import br.com.zup.ecommerce.controller.request.ProdutoRequest;
import br.com.zup.ecommerce.controller.response.ProdutoResponse;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;
import br.com.zup.ecommerce.model.CaracteristicasProduto;
import br.com.zup.ecommerce.model.Categoria;
import br.com.zup.ecommerce.model.Imagem;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.repository.CaracteristicaProdutoRepository;
import br.com.zup.ecommerce.repository.CategoriaRepository;
import br.com.zup.ecommerce.repository.ImagemRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CaracteristicaProdutoRepository caracteristicasRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ImagemRepository imagemRepository;

	@PersistenceContext
	private EntityManager manager;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponse> buscarPeloId(@PathVariable Long id) {
		Optional<Produto> produtoRecuperado = produtoRepository.findById(id);
		Produto produto = produtoRecuperado.get();
		UsuarioResponse usuarioResponse = produto.getUsuario().ConverteResponse();
		ProdutoResponse response = produto.converterModel(usuarioResponse);
		return produtoRecuperado.isPresent() ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest request,
			HttpServletResponse response) {
		CaracteristicasProduto caracteristica = salvaCaracteristica(request.getCaracteristica());
		Categoria categoria = recuperaCategoria(request.getCategoria());
		Usuario usuario = recuperaUsuario(request.getUsuario());

		Produto produto = request.toModel(caracteristica, categoria, usuario);
		Produto produtoSalvo = produtoRepository.save(produto);
		salvaImagem(request.getImagems(), produtoSalvo);
		UsuarioResponse usuarioResponse = produto.getUsuario().ConverteResponse();
		ProdutoResponse response1 = produtoSalvo.converterModel(usuarioResponse);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response1);
	}

	public CaracteristicasProduto salvaCaracteristica(CaracteristicaRequest request) {
		CaracteristicasProduto caracteristicaProd = request.ToModel();
		CaracteristicasProduto caracteristicasSalva = caracteristicasRepository.save(caracteristicaProd);
		return caracteristicasSalva;

	}

	public List<Imagem> salvaImagem(List<Imagem> list, Produto produto) {
		List<Imagem> listRetorno = new ArrayList<>();
		for (Imagem imagem : list) {
			Imagem imagemSalva = imagemRepository.save(new Imagem(imagem.getImagem(), produto));
			listRetorno.add(imagemSalva);
		}
		return listRetorno;

	}

	public Categoria recuperaCategoria(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.get();
	}

	public Usuario recuperaUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

}
