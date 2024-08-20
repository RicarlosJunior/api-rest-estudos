package rest.api.adv.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdiantamentoDespesaViagemDTO {

	private Long id;
	private Integer numero;
	private String nomeColaborador;
	private String status;
	private BigDecimal valor;
	private List<DespesaDTO> despesas;
	
	public AdiantamentoDespesaViagemDTO() {
		this.despesas = new ArrayList<>();
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
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public List<DespesaDTO> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<DespesaDTO> despesas) {
		this.despesas = despesas;
	}
	
}
