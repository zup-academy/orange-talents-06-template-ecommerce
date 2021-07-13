package br.com.zup.ecommerce.model.carrinho;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "finaliza_compra")
public class FinalizaCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idTransaçao;

	@OneToMany(mappedBy = "finalizaCompra")
	private List<RegistroPagamento> registros;

	private boolean comunicacao;

	public FinalizaCompra() {
		// TODO Auto-generated constructor stub
	}

	public FinalizaCompra(String idTransaçao, List<RegistroPagamento> registros, boolean comunicacao) {
		this.idTransaçao = idTransaçao;
		this.registros = registros;
		this.comunicacao = comunicacao;
	}

	public Long getId() {
		return id;
	}

	public String getIdTransaçao() {
		return idTransaçao;
	}

	public List<RegistroPagamento> getRegistros() {
		return registros;
	}

	public boolean isComunicacao() {
		return comunicacao;
	}

}
