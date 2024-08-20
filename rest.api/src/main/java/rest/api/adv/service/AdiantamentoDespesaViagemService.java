package rest.api.adv.service;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;

public interface AdiantamentoDespesaViagemService {
	
	AdiantamentoDespesaViagem findById(Long id);
	
	AdiantamentoDespesaViagem create(AdiantamentoDespesaViagem adiantamentoDespesaViagem);
	
}
