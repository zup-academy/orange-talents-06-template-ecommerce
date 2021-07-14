package br.com.zup.ecommerce.controller.request;

import java.util.List;

import br.com.zup.ecommerce.model.carrinho.FinalizaCompra;
import br.com.zup.ecommerce.model.carrinho.RegistroPagamento;
import br.com.zup.ecommerce.model.carrinho.StatusRetornoEnum;

public class FinalizaCompraRequest {
	private String idTransaçao;
	private StatusRetornoEnum status;
	private List<RegistroPagamento> registros;
	private Boolean comunicacao;

	public FinalizaCompraRequest(String idTransaçao, StatusRetornoEnum status, List<RegistroPagamento> registros) {
		this.idTransaçao = idTransaçao;
		this.status = status;
		this.registros = registros;
		this.comunicacao = false;
	}

	public String getIdTransaçao() {
		return idTransaçao;
	}

	public StatusRetornoEnum getStatus() {
		return status;
	}

	public FinalizaCompra toModel() {
		return new FinalizaCompra(this.idTransaçao, 
				this.registros, this.comunicacao);
	}

}
