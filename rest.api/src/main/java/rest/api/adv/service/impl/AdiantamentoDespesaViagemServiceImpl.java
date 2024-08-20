package rest.api.adv.service.impl;

import org.springframework.stereotype.Service;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.domain.repository.AdiantamentoDespesaViagemRepository;
import rest.api.adv.service.AdiantamentoDespesaViagemService;

@Service
public class AdiantamentoDespesaViagemServiceImpl implements AdiantamentoDespesaViagemService {
	
	private final AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository;
	
	public AdiantamentoDespesaViagemServiceImpl(AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository) {
		this.adiantamentoDespesaViagemRepository = adiantamentoDespesaViagemRepository;
	}

	@Override
	public AdiantamentoDespesaViagem findById(Long id) {
		return adiantamentoDespesaViagemRepository.findById(id).get();
	}

	@Override
	public AdiantamentoDespesaViagem create(AdiantamentoDespesaViagem adiantamentoDespesaViagem) {
		return adiantamentoDespesaViagemRepository.save(adiantamentoDespesaViagem);
	}

}
