package br.com.zup.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.produtos.Opiniao;
import br.com.zup.ecommerce.model.produtos.Produto;

public interface OpiniaoRepository extends JpaRepository<Opiniao, Long>{

	List<Opiniao> findByProduto(Long id);

	List<Opiniao> produto(Produto produto);

	

	
}
