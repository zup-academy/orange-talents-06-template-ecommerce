package br.com.zup.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

	Optional<Imagem> findByProduto(Long idProduto);
	
}
