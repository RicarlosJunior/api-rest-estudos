package rest.api.adv.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_despesa")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numero;
	
	private String descricao;
	
	@Column(precision = 13, scale = 2)
	private BigDecimal valor;
	
	@ManyToOne
    @JoinColumn(name = "adiantamento_despesa_viagem_id")
	private AdiantamentoDespesaViagem adiantamentoDespesaViagem;
	
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
	public AdiantamentoDespesaViagem getAdiantamentoDespesaViagem() {
		return adiantamentoDespesaViagem;
	}
	public void setAdiantamentoDespesaViagem(AdiantamentoDespesaViagem adiantamentoDespesaViagem) {
		this.adiantamentoDespesaViagem = adiantamentoDespesaViagem;
	}
	
}
