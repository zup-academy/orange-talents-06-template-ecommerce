package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.produtos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
