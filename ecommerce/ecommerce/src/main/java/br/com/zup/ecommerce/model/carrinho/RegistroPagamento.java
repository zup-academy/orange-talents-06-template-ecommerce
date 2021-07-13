package br.com.zup.ecommerce.model.carrinho;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "registro_pagamento")
public class RegistroPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private StatusRetornoEnum retorno;
	private LocalDateTime registro;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_finaliza")
	private FinalizaCompra finalizaCompra;

	public RegistroPagamento() {
		// TODO Auto-generated constructor stub
	}

	public RegistroPagamento(StatusRetornoEnum retorno, LocalDateTime registro, FinalizaCompra finalizaCompra) {
		super();
		this.retorno = retorno;
		this.registro = registro;
		this.finalizaCompra = finalizaCompra;
	}

	public Long getId() {
		return id;
	}

	public StatusRetornoEnum getStatus() {
		return retorno;
	}

	public LocalDateTime getRegistro() {
		return registro;
	}

	public FinalizaCompra getFinalizaCompra() {
		return finalizaCompra;
	}

}
