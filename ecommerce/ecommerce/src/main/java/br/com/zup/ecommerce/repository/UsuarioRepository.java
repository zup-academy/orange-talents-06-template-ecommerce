package br.com.zup.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ecommerce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
