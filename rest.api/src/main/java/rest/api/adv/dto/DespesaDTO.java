package rest.api.adv.dto;

import java.math.BigDecimal;

public class DespesaDTO {
	
	private Long id;
	private Integer numero;
	private String descricao;
	private BigDecimal valor;
	private Long adiantamentoDespesaViagemId;
	
	public DespesaDTO() {
		
	}
	
	
	
	public DespesaDTO(Long id, Integer numero, String descricao, BigDecimal valor,
			Long adiantamentoDespesaViagemId) {
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
		this.valor = valor;
		this.adiantamentoDespesaViagemId = adiantamentoDespesaViagemId;
		
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getAdiantamentoDespesaViagemId() {
		return adiantamentoDespesaViagemId;
	}

	public void setAdiantamentoDespesaViagemId(Long adiantamentoDespesaViagemId) {
		this.adiantamentoDespesaViagemId = adiantamentoDespesaViagemId;
	}
	
}
