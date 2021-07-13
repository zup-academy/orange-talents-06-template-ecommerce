package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.produtos.CaracteristicasProduto;

public interface CaracteristicaProdutoRepository extends JpaRepository<CaracteristicasProduto, Long>{

}
