package rest.api.adv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.domain.repository.AdiantamentoDespesaViagemRepository;
import rest.api.adv.dto.AdiantamentoDespesaViagemDTO;
import rest.api.adv.dto.mapper.AdiantamentoDespesaViagemMapper;
import rest.api.adv.service.AdiantamentoDespesaViagemService;

@Service
public class AdiantamentoDespesaViagemServiceImpl implements AdiantamentoDespesaViagemService {
	
	private final AdiantamentoDespesaViagemMapper adiantamentoDespesaViagemMapper;
	
	private final AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository;
	
	

	public AdiantamentoDespesaViagemServiceImpl(AdiantamentoDespesaViagemMapper adiantamentoDespesaViagemMapper,
			AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository) {
		this.adiantamentoDespesaViagemMapper = adiantamentoDespesaViagemMapper;
		this.adiantamentoDespesaViagemRepository = adiantamentoDespesaViagemRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public AdiantamentoDespesaViagemDTO findById(Long id) {
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		AdiantamentoDespesaViagemDTO dto = adiantamentoDespesaViagemMapper.toDTO(entity);

		return dto;
	}

	@Transactional
	@Override
	public AdiantamentoDespesaViagemDTO create(AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO) {
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemMapper.toEntity(adiantamentoDespesaViagemDTO);
		
		entity = adiantamentoDespesaViagemRepository.save(entity);
		
		AdiantamentoDespesaViagemDTO dto = adiantamentoDespesaViagemMapper.toDTO(entity);
		
		return dto;
	}

	@Transactional(readOnly = true)
	@Override
	public List<AdiantamentoDespesaViagemDTO> findAll() {
		
		List<AdiantamentoDespesaViagem> entitys = adiantamentoDespesaViagemRepository.findAll();
		
		List<AdiantamentoDespesaViagemDTO> dtos = entitys.stream().map(adiantamentoDespesaViagemMapper::toDTO).collect(Collectors.toList());
		
		return dtos;
	}

	@Transactional
	@Override
	public void delete(Long id) {
		if(!adiantamentoDespesaViagemRepository.existsById(id)) {
			throw new NoSuchElementException();
		}
		adiantamentoDespesaViagemRepository.deleteById(id);
	}

	@Transactional
	@Override
	public AdiantamentoDespesaViagemDTO update(Long id, AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO) {
		if(!adiantamentoDespesaViagemRepository.existsById(id)) {
			throw new NoSuchElementException();
		}
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemMapper.toEntity(adiantamentoDespesaViagemDTO);
		
		entity = adiantamentoDespesaViagemRepository.save(entity);
		
		AdiantamentoDespesaViagemDTO dto = adiantamentoDespesaViagemMapper.toDTO(entity);
		
		return dto;
	}

}
