package rest.api.adv.domain.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_adiantamento_despesa_viagem")
public class AdiantamentoDespesaViagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numero;
	
	private String nomeColaborador;
	
	private String status;
	
	@Column(precision = 13, scale = 2)
	private BigDecimal valor;
	
	@OneToMany(mappedBy = "adiantamentoDespesaViagem", cascade = CascadeType.ALL)
	private List<Despesa> despesas;
	
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
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
	public List<Despesa> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	
	
}
