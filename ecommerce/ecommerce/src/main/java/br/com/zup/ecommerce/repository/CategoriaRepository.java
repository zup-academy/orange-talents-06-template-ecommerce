package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	
}
