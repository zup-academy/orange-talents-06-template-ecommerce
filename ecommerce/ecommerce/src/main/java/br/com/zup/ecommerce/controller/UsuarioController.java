package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.ArrayList;
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

import br.com.zup.ecommerce.controller.request.UsuarioRequest;
import br.com.zup.ecommerce.controller.response.UsuarioResponse;
import br.com.zup.ecommerce.model.Usuario;
import br.com.zup.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<UsuarioResponse> listar() {
		List<UsuarioResponse> response = new ArrayList<>(); 
		List<Usuario> usuarioRetorno = usuarioRepository.findAll();
		for (Usuario usuario : usuarioRetorno) {
			response.add(usuario.ConverteResponse());
		}
		 return response;
	}

	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioRequest request, HttpServletResponse response) {
		Usuario usuario = request.toModel();
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(usuarioSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuarioSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
	}

}
