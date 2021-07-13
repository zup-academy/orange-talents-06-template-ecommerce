package br.com.zup.ecommerce.model.carrinho;

public enum PlataformaEnum {
	Paypal("paypal"),
	Pagseguro("pagseguro");
	
	public String tipoPagamento;
	
	PlataformaEnum(String valor) {
		tipoPagamento = valor;
	}
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
}
