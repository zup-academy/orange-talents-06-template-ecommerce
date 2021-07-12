package br.com.zup.ecommerce.model;

public enum Plataforma {
	Paypal("paypal"),
	Pagseguro("pagseguro");
	
	public String tipoPagamento;
	
	Plataforma(String valor) {
		tipoPagamento = valor;
	}
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
}
