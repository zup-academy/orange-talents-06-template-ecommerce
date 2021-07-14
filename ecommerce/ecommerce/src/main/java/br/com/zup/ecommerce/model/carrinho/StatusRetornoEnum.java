package br.com.zup.ecommerce.model.carrinho;

public enum StatusRetornoEnum {
		
	Sucesso("1"),
	ERRO("0");
	
	private String statuRetorno;
	
	StatusRetornoEnum(String statuRetorno) {
		this.statuRetorno = statuRetorno;
	}
	
	public String getStatuRetorno() {
		return statuRetorno;
	}
	
	
	
	
	
}
