package br.com.zup.ecommerce.controller.response;

public class DetalheOpiniaoResponse {
	private Long id;
	private Integer nota;
	private String descricao;
	private String usuarioOpiniao;
	private String emailOpiniao;
	
	public DetalheOpiniaoResponse(Long id, Integer nota, String descricao, String usuarioOpiniao, String emailOpiniao) {
		this.id = id;
		this.nota = nota;
		this.descricao = descricao;
		this.usuarioOpiniao = usuarioOpiniao;
		this.emailOpiniao = emailOpiniao;
	}
	public Long getId() {
		return id;
	}
	public Integer getNota() {
		return nota;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getUsuarioOpiniao() {
		return usuarioOpiniao;
	}
	public String getEmailOpiniao() {
		return emailOpiniao;
	}
	
	
	
}
