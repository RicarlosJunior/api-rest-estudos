package rest.api.adv.dto;

import java.math.BigDecimal;

public class DespesaDTO {
	
	private Long id;
	private Integer numero;
	private String descricao;
	private BigDecimal valor;
	private AdiantamentoDespesaViagemDTO adiantamentoDespesaViagem;
	
	public DespesaDTO() {
		this.adiantamentoDespesaViagem = new AdiantamentoDespesaViagemDTO();
	}
	
	
	
	public DespesaDTO(Long id, Integer numero, String descricao, BigDecimal valor,
			AdiantamentoDespesaViagemDTO adiantamentoDespesaViagem) {
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
		this.valor = valor;
		this.adiantamentoDespesaViagem = adiantamentoDespesaViagem;
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

	public AdiantamentoDespesaViagemDTO getAdiantamentoDespesaViagem() {
		return adiantamentoDespesaViagem;
	}
	public void setAdiantamentoDespesaViagem(AdiantamentoDespesaViagemDTO adiantamentoDespesaViagem) {
		this.adiantamentoDespesaViagem = adiantamentoDespesaViagem;
	}
	
}
