package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.carrinho.FinalizaCompra;

public interface FinalizaCompraRepository extends JpaRepository<FinalizaCompra, Long>{

}
