package br.com.zup.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

	List<Pergunta> findByProduto(Long idProduto);

}
