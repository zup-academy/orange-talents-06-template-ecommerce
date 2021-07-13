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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.ecommerce.controller.request.PerguntaRequest;
import br.com.zup.ecommerce.controller.response.PerguntaResponse;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.model.produtos.Pergunta;
import br.com.zup.ecommerce.model.produtos.Produto;
import br.com.zup.ecommerce.repository.PerguntaRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("perguntas")
public class PerguntaController {
	@Autowired
	private PerguntaRepository perguntaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<PerguntaResponse> listar() {
		List<PerguntaResponse> response = new ArrayList<>();
		List<Pergunta> perguntas = perguntaRepository.findAll();
		for (Pergunta pergunta : perguntas) {
			PerguntaResponse responseConvertido = pergunta.ConverteResponse();
			response.add(responseConvertido);
		}
		return response;
	}

	@PostMapping
	public ResponseEntity<PerguntaResponse> criar(@Valid @RequestBody PerguntaRequest request,
			HttpServletResponse response) {
		Usuario usuario = recuperaUsuario(request.getUsuario());
		Produto produto = recuperaProduto(request.getProduto());
		Pergunta pergunta = request.toModel(usuario, produto);
		Pergunta perguntaSalvo = perguntaRepository.save(pergunta);

		PerguntaResponse responsePergunta = perguntaSalvo.ConverteResponse();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(responsePergunta.getId()).toUri();
		return ResponseEntity.created(uri).body(responsePergunta);
	}

	public Usuario recuperaUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	public Produto recuperaProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	public void enviaEmail() {
		System.out.println("Enviar email");
	}

}
