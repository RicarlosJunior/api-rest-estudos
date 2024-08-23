package rest.api.adv.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.api.adv.controller.exception.BusinessException;
import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.domain.model.Despesa;
import rest.api.adv.domain.repository.AdiantamentoDespesaViagemRepository;
import rest.api.adv.domain.repository.DespesaRepository;
import rest.api.adv.dto.DespesaDTO;
import rest.api.adv.service.DespesaService;

@Service
public class DepesaServiceImpl implements DespesaService {


	private final DespesaRepository despesaRepository;
	
	private final AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository;

	public DepesaServiceImpl(DespesaRepository despesaRepository,
							AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository) {
		
		
		this.despesaRepository = despesaRepository;
		this.adiantamentoDespesaViagemRepository = adiantamentoDespesaViagemRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public DespesaDTO findById(Long id) {
		
		Despesa entity = despesaRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Despesa não encontrado para esse ID");
		});
		
		return new DespesaDTO(entity);
		
	}

	@Transactional
	@Override
	public DespesaDTO create(DespesaDTO despesaDTO) {
		
		//Metoque que valida o Adiantamento Despesa de Viagem
		AdiantamentoDespesaViagem entityADV = validarAdiantamentoDespesaViagem(despesaDTO.adiantamentoDespesaViagemId());
		
		
		Despesa entity = despesaDTO.toEntity();
		entity.setAdiantamentoDespesaViagem(entityADV);
		
		entity = despesaRepository.save(entity);
		
		//Toda vez que adicionar uma despesa verifica se o status do ADV esta como PEN (Pendente de Fechamento)
		//Se não estiver faz updade
		if(entity.getId() > 0 && !entity.getAdiantamentoDespesaViagem().getStatus().equalsIgnoreCase("PEN")) {
			adiantamentoDespesaViagemRepository.updateStatus(entity.getId(), "PEN"); 
		}
		
		return new DespesaDTO(entity);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<DespesaDTO> findAll() {
		
		List<Despesa> entitys = despesaRepository.findAll();
		
		return entitys.stream().map(DespesaDTO::new).collect(Collectors.toList());
		
	
	}


	@Transactional
	@Override
	public void delete(Long id) {
		Despesa entity = despesaRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Despesa não encontrado para esse ID");
		});
		
		//Metoque que valida o Adiantamento Despesa de Viagem
		validarAdiantamentoDespesaViagem(entity.getAdiantamentoDespesaViagem().getId());
		
		despesaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public DespesaDTO update(Long id, DespesaDTO despesaDTO) {
		if(!despesaRepository.existsById(id)) {
			throw new BusinessException("Despesa não encontrado para esse ID");
		}
		
		//Metoque que valida o Adiantamento Despesa de Viagem
		AdiantamentoDespesaViagem entityADV = validarAdiantamentoDespesaViagem(despesaDTO.adiantamentoDespesaViagemId());
		
		Despesa entity = despesaDTO.toEntity();
		entity.setAdiantamentoDespesaViagem(entityADV);
		
		entity = despesaRepository.save(entity);
		
		return new DespesaDTO(entity);
	}
	
	private AdiantamentoDespesaViagem validarAdiantamentoDespesaViagem(Long id) {
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		if(!entity.getStatus().equalsIgnoreCase("ABT") && !entity.getStatus().equalsIgnoreCase("PEN")) {
			throw new BusinessException("Não é possível realizar essa operação em Adiantamento de Despesa de Viagem que não esteja em ABERTO ou PENDENTE DE FECHAMENTO");
		}
		
		return entity;
	}

}
