package rest.api.adv.service;

import rest.api.adv.dto.DespesaDTO;

public interface DespesaService {
	
	Iterable<DespesaDTO> findAll();
	
	DespesaDTO findById(Long id);
	
	DespesaDTO create(DespesaDTO despesa);
	
	void delete(Long id);
	
	DespesaDTO update(Long id, DespesaDTO despesa);
	
}
