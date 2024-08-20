package rest.api.adv.service;

import java.util.List;

import rest.api.adv.dto.AdiantamentoDespesaViagemDTO;

public interface AdiantamentoDespesaViagemService {
	
	List<AdiantamentoDespesaViagemDTO> findAll();
	
	AdiantamentoDespesaViagemDTO findById(Long id);
	
	AdiantamentoDespesaViagemDTO create(AdiantamentoDespesaViagemDTO adiantamentoDespesaViagem);
	
	void delete(Long id);
	
	AdiantamentoDespesaViagemDTO update(Long id, AdiantamentoDespesaViagemDTO adiantamentoDespesaViagem);
	
}
