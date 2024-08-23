package rest.api.adv.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.api.adv.controller.exception.BusinessException;
import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.domain.model.Despesa;
import rest.api.adv.domain.repository.AdiantamentoDespesaViagemRepository;
import rest.api.adv.dto.AdiantamentoDespesaViagemDTO;
import rest.api.adv.service.AdiantamentoDespesaViagemService;

@Service
public class AdiantamentoDespesaViagemServiceImpl implements AdiantamentoDespesaViagemService {
	
	
	private final AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository;
	
	public AdiantamentoDespesaViagemServiceImpl(AdiantamentoDespesaViagemRepository adiantamentoDespesaViagemRepository) {
		this.adiantamentoDespesaViagemRepository = adiantamentoDespesaViagemRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public AdiantamentoDespesaViagemDTO findById(Long id) {
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		return new AdiantamentoDespesaViagemDTO(entity);
	}

	@Transactional
	@Override
	public AdiantamentoDespesaViagemDTO create(AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO) {
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemDTO.toEntity();
		
		entity = adiantamentoDespesaViagemRepository.save(entity);
		
		return new AdiantamentoDespesaViagemDTO(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AdiantamentoDespesaViagemDTO> findAll() {
		
		List<AdiantamentoDespesaViagem> entitys = adiantamentoDespesaViagemRepository.findAll();
		
		return  entitys.stream().map(AdiantamentoDespesaViagemDTO::new).collect(Collectors.toList());
		
	}

	@Transactional
	@Override
	public void delete(Long id) {
		
		//Metoque que valida o Adiantamento Despesa de Viagem
		validarAdiantamentoDespesaViagem(id);
		
		adiantamentoDespesaViagemRepository.deleteById(id);
	}

	

	@Transactional
	@Override
	public AdiantamentoDespesaViagemDTO update(Long id, AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO) {
		
		//Metoque que valida o Adiantamento Despesa de Viagem
		validarAdiantamentoDespesaViagem(id);
		
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemDTO.toEntity();
		
		entity = adiantamentoDespesaViagemRepository.save(entity);
		
		return new AdiantamentoDespesaViagemDTO(entity);
	}

	@Transactional
	@Override
	public void efetuarFechamento(Long id) {
		
		AdiantamentoDespesaViagem adv = adiantamentoDespesaViagemRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		if(adv.getDespesas() == null || adv.getDespesas().isEmpty()) {
			throw new BusinessException("Não existe Despesas Lançadas para esse Adiantamento de Despesa de Viagem");
		}
		
		
		BigDecimal valorTotalDespesa = adv.getDespesas().stream()
				.map(Despesa::getValor) // Mapeia a lista de Despesa para uma lista de BigDecimal
				.reduce(BigDecimal.ZERO, (total, valor) -> total.add(valor));
		
		String status = "REG"; //Fechamento regular
		if(adv.getValor().compareTo(valorTotalDespesa) != 0) {
			
			status = "IRG"; //Fechamento irregular
			
		}
		
		adiantamentoDespesaViagemRepository.updateStatus(adv.getId(), status);
	}
	
	private void validarAdiantamentoDespesaViagem(Long id) {
		AdiantamentoDespesaViagem entity = adiantamentoDespesaViagemRepository.findById(id).orElseThrow(() -> {
			throw new BusinessException("Adiantamento de Despesa de Viagem não encontrado para esse ID");
		});
		
		if(!entity.getStatus().equalsIgnoreCase("ABT") && !entity.getStatus().equalsIgnoreCase("PEN")) {
			throw new BusinessException("Não é possível realizar essa operação em Adiantamento de Despesa de Viagem que não esteja em ABERTO ou PENDENTE DE FECHAMENTO");
		}
	}

}
