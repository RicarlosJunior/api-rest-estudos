package rest.api.adv.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import rest.api.adv.domain.repository.DespesaRepository;
import rest.api.adv.dto.DespesaDTO;
import rest.api.adv.service.DespesaService;

@Service
public class DepesaServiceImpl implements DespesaService {

	private final DespesaRepository despesaRepository;


	public DepesaServiceImpl(DespesaRepository despesaRepository) {
		this.despesaRepository = despesaRepository;
	}

	@Override
	public DespesaDTO findById(Long id) {
		return null;
	}

	@Override
	public DespesaDTO create(DespesaDTO despesa) {
		return null;
	}
	
	@Override
	public Iterable<DespesaDTO> findAll() {
		return null;
	}


	@Override
	public void delete(Long id) {
		if(!despesaRepository.existsById(id)) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public DespesaDTO update(Long id, DespesaDTO despesa) {
		if(!despesaRepository.existsById(id)) {
			throw new NoSuchElementException();
		}
		return null;
	}

}
