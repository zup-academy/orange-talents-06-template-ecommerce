package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import br.com.zup.ecommerce.model.CaracteristicasProduto;
import br.com.zup.ecommerce.model.Categoria;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.repository.CaracteristicaProdutoRepository;
import br.com.zup.ecommerce.repository.CategoriaRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CaracteristicaProdutoRepository caracteristicasRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPeloId(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> criar(@Valid @RequestBody ProdutoRequest request, HttpServletResponse response) {
		CaracteristicasProduto caracteristica = salvaCaracteristica(request.getCaracteristica());
		Categoria categoria = recuperaCategoria(request.getCategoria());
		Produto produto = request.toModel(caracteristica, categoria);
		Produto produtoSalvo = produtoRepository.save(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(produtoSalvo);
	}

	public CaracteristicasProduto salvaCaracteristica(CaracteristicaRequest request) {
		CaracteristicasProduto caracteristicaProd = request.ToModel();
		System.out.println(caracteristicaProd.getMarca());
		CaracteristicasProduto caracteristicasSalva = caracteristicasRepository.save(caracteristicaProd);
		System.out.println(caracteristicasSalva.getMarca());
		return caracteristicasSalva;

	}

	public Categoria recuperaCategoria(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.get();
	}

}
