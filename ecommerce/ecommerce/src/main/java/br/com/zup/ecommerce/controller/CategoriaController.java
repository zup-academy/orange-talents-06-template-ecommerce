package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.ecommerce.controller.request.CategoriaRequest;
import br.com.zup.ecommerce.model.produtos.Categoria;
import br.com.zup.ecommerce.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody CategoriaRequest request, HttpServletResponse response) {
		Categoria categoria = request.toModel();
		Categoria categoriaSalvo = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(categoriaSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaSalvo);

	}

}
