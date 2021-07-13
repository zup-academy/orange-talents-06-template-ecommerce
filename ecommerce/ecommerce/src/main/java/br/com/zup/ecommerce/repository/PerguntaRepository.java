package br.com.zup.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.ecommerce.model.produtos.Pergunta;
import br.com.zup.ecommerce.model.produtos.Produto;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

	List<Pergunta> findByProduto(Long idProduto);

	List<Pergunta> produto(Produto produto);

	

}
