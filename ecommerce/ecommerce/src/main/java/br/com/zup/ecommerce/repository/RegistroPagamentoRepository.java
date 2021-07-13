package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.carrinho.RegistroPagamento;

public interface RegistroPagamentoRepository
extends JpaRepository<RegistroPagamento, Long>{

}
