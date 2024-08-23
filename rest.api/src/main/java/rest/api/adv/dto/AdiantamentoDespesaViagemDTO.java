package rest.api.adv.dto;


import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import java.math.BigDecimal;
import java.util.List;


//Muito importante!!!
//Para deixar o codigo menos verboso e para fins de estudos
//Utilizamos metodos estaticos (ofNullable, emptyList, toList) no construtor e no metodo toEntity sem descrever o nome da classe
//a qual esse metodo pertence (Optional.ofNullable(), Collections.emptyList(), Collectors.toList()) 
//para que isso seja possivel  e necessario que as importacoes sejam estaticas como informado abaixo

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.Collections.emptyList;


public record AdiantamentoDespesaViagemDTO (Long id, Integer numero, String nomeColaborador, String status, BigDecimal valor, List<DespesaDTO> despesas) {

	
	public AdiantamentoDespesaViagemDTO(AdiantamentoDespesaViagem entity) {
		this(entity.getId(),
				entity.getNumero(),
				entity.getNomeColaborador(),
				entity.getStatus(),
				entity.getValor(),
				ofNullable(entity.getDespesas()).orElse(emptyList()).stream().map(DespesaDTO::new).collect(toList())
			);
	}
	
	public AdiantamentoDespesaViagem toEntity() {
	 	
        AdiantamentoDespesaViagem entity = new AdiantamentoDespesaViagem();
        entity.setId(this.id);
        entity.setNumero(this.numero);
        entity.setNomeColaborador(this.nomeColaborador);
        entity.setStatus(this.status);
        entity.setValor(this.valor);
        entity.setDespesas(ofNullable(this.despesas).orElse(emptyList()).stream().map(DespesaDTO::toEntity).collect(toList()));
        return entity;
}
	
}
