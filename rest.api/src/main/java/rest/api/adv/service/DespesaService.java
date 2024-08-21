package rest.api.adv.service;

import java.util.List;

import rest.api.adv.dto.DespesaDTO;

public interface DespesaService {
	
	List<DespesaDTO> findAll();
	
	DespesaDTO findById(Long id);
	
	DespesaDTO create(DespesaDTO despesa);
	
	void delete(Long id);
	
	DespesaDTO update(Long id, DespesaDTO despesa);
	
}
