package br.com.zup.ecommerce.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.ecommerce.model.Usuario;

public class UsuarioRequest {

	@NotBlank
	// @Size(min=3, max=20)
	private String usuario;
	@NotBlank
	@Email
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;

	public UsuarioRequest(String usuario, String login, String senha) {
		this.usuario = usuario;
		this.login = login;
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(this.usuario, this.login, this.senha);
	}

}
