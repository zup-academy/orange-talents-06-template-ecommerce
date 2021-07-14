package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.ecommerce.model.carrinho.CriarPedido;

@Repository
public interface CriarPedidoRepository extends JpaRepository<CriarPedido, Long> {

}
