package br.com.zup.ecommerce.controller.response;

import java.time.LocalDateTime;

public class UsuarioResponse {
	private String usuario;
	private String email;
	public UsuarioResponse(String usuario, String email) {
		super();
		this.usuario = usuario;
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getEmail() {
		return email;
	}
	
	
	
	
	
}
