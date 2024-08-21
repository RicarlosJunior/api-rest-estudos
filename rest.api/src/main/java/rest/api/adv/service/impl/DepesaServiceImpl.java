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
import rest.api.adv.dto.mapper.DespesaMapper;
import rest.api.adv.service.DespesaService;

@Service
public class DepesaServiceImpl implements DespesaService {

	private final DespesaMapper despesaMapper;

	private final DespesaRepository despesaRepository;
	
	private final AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository;

	public DepesaServiceImpl(DespesaMapper despesaMapper, DespesaRepository despesaRepository,
			AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository) {
		this.despesaMapper = despesaMapper;
		this.despesaRepository = despesaRepository;
		this.adiantamentoDespesaViagemRepository = adiantamentoDespesaViagemRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public DespesaDTO findById(Long id) {
		
		Despesa entity = despesaRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Despesa não encontrado para esse ID");
		});
		
		DespesaDTO dto = despesaMapper.toDTO(entity);

		return dto;
		
	}

	@Transactional
	@Override
	public DespesaDTO create(DespesaDTO despesaDTO) {
		
		AdiantamentoDespesaViagem entityADV = adiantamentoDespesaViagemRepository.findById(despesaDTO.getAdiantamentoDespesaViagemId()).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		
		Despesa entity = despesaMapper.toEntity(despesaDTO);
		entity.setAdiantamentoDespesaViagem(entityADV);
		
		entity = despesaRepository.save(entity);
		
		//Toda vez que adicionar uma despesa verifica se o status do ADV esta como PEN (Pendente de Fechamento)
		//Se não estiver faz updade
		if(entity.getId() > 0 && !entity.getAdiantamentoDespesaViagem().getStatus().equalsIgnoreCase("PEN")) {
			adiantamentoDespesaViagemRepository.updateStatus(entity.getId(), "PEN"); 
		}
		
		DespesaDTO dto = despesaMapper.toDTO(entity);
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<DespesaDTO> findAll() {
		
		List<Despesa> entitys = despesaRepository.findAll();
		
		List<DespesaDTO> dtos = entitys.stream().map(despesaMapper::toDTO).collect(Collectors.toList());
		
		return dtos;
	}


	@Transactional
	@Override
	public void delete(Long id) {
		if(!despesaRepository.existsById(id)) {
			throw new BusinessException("Despesa não encontrado para esse ID");
		}
		despesaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public DespesaDTO update(Long id, DespesaDTO despesaDTO) {
		if(!despesaRepository.existsById(id)) {
			throw new BusinessException("Despesa não encontrado para esse ID");
		}
		
		AdiantamentoDespesaViagem entityADV = adiantamentoDespesaViagemRepository.findById(despesaDTO.getAdiantamentoDespesaViagemId()).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		Despesa entity = despesaMapper.toEntity(despesaDTO);
		entity.setAdiantamentoDespesaViagem(entityADV);
		
		entity = despesaRepository.save(entity);
		
		DespesaDTO dto = despesaMapper.toDTO(entity);
		
		return dto;
	}

}
