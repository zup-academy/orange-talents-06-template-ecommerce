package br.com.zup.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.zup.ecommerce.controller.response.UsuarioResponse;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usuario;
	private String email;
	private String senha;
	private LocalDateTime dataCadastro;

	public Usuario() {
	}

	public Usuario(String usuario, String email, String senha) {
		this.usuario = usuario;
		this.email = email;
		this.senha = criarSenha(senha);
		this.dataCadastro = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
	private String criarSenha(String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}

	public UsuarioResponse ConverteResponse() {
		return new UsuarioResponse(this.usuario, this.email);
	}

}
