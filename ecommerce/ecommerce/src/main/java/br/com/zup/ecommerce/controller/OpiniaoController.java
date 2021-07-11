package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.ecommerce.controller.request.OpiniaoRequest;
import br.com.zup.ecommerce.controller.response.OpiniaoResponse;
import br.com.zup.ecommerce.controller.response.ProdutoResponse;
import br.com.zup.ecommerce.model.Opiniao;
import br.com.zup.ecommerce.model.Produto;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.repository.OpiniaoRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/opinioes")
public class OpiniaoController {
	@Autowired
	private OpiniaoRepository opiniaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Opiniao> listar() {
		return opiniaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<OpiniaoResponse> criar(@Valid @RequestBody OpiniaoRequest request, 
			HttpServletResponse response) {
		Usuario usuario = recuperaUsuario(request.getUsuario());
		Produto produto = recuperaProduto(request.getProduto());
		Opiniao opiniao = request.toModel(usuario, produto);
		Opiniao opiniaoSalvo = opiniaoRepository.save(opiniao);
		
		ProdutoResponse produtoResponse = produto.converterModel();
		OpiniaoResponse responseOpiniao = opiniaoSalvo.converteOpinicao(opiniaoSalvo, produtoResponse);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(responseOpiniao.getId())
				.toUri();
		return ResponseEntity.created(uri).body(responseOpiniao);
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
