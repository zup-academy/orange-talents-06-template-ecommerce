package br.com.zup.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ecommerce.controller.response.ImagemResponse;
import br.com.zup.ecommerce.model.Imagem;
import br.com.zup.ecommerce.repository.ImagemRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/imagens")
public class ImagemController {

	@Autowired
	private ImagemRepository imagemRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	private List<Imagem> listar() {
		return imagemRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImagemResponse> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Imagem> imagemRecuperado = imagemRepository.findById(id);
		Imagem imagemSalva = imagemRecuperado.get();
		ImagemResponse resposta = imagemSalva.converteModel();
		return imagemRecuperado.isPresent() ? ResponseEntity.ok(resposta) : ResponseEntity.notFound().build();
	}

}
