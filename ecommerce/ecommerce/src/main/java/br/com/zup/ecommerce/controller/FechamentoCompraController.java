package br.com.zup.ecommerce.controller;

import java.net.URI;
import java.util.List;

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

import br.com.zup.ecommerce.controller.request.CriarPedidoRequest;
import br.com.zup.ecommerce.controller.request.FinalizaCompraRequest;
import br.com.zup.ecommerce.controller.response.CriarPedidoResponse;
import br.com.zup.ecommerce.model.carrinho.CriarPedido;
import br.com.zup.ecommerce.model.carrinho.FinalizaCompra;
import br.com.zup.ecommerce.model.carrinho.RegistroPagamento;
import br.com.zup.ecommerce.repository.FinalizaCompraRepository;
import br.com.zup.ecommerce.repository.RegistroPagamentoRepository;

@RestController
@RequestMapping("/fechamentos")
public class FechamentoCompraController {

	@Autowired
	private RegistroPagamentoRepository registroPagamentoRepository;
	
	@Autowired
	private FinalizaCompraRepository finalizaCompraRepository;
	
	@GetMapping
	private List<FinalizaCompra> listar() {
		return finalizaCompraRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<FinalizaCompra> criar(@Valid @RequestBody FinalizaCompraRequest request,
			HttpServletResponse response) {
		
		FinalizaCompra finalizaCompra= request.toModel();
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(finalizaCompra.getId()).toUri();
		return ResponseEntity.created(uri).body(finalizaCompra);
	}
	
}
