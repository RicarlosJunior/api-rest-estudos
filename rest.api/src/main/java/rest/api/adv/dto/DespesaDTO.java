package rest.api.adv.dto;

import java.math.BigDecimal;

import rest.api.adv.domain.model.Despesa;

public record DespesaDTO (Long id, Integer numero, String descricao, BigDecimal valor, Long adiantamentoDespesaViagemId) {
	
	public DespesaDTO(Despesa entity) {
		this(entity.getId(),
			 entity.getNumero(),
			 entity.getDescricao(),
			 entity.getValor(),
			 entity.getAdiantamentoDespesaViagem().getId()
			);
	}
	
	 public Despesa toEntity() {
        Despesa despesa = new Despesa();
        despesa.setId(this.id);
        despesa.setNumero(this.numero);
        despesa.setDescricao(this.descricao);
        despesa.setValor(this.valor);
        return despesa;
	  }

	
}
