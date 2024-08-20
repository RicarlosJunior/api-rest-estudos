package rest.api.adv.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.domain.model.Despesa;
import rest.api.adv.dto.AdiantamentoDespesaViagemDTO;
import rest.api.adv.dto.DespesaDTO;

@Component
public class AdiantamentoDespesaViagemMapper {

	 private final DespesaMapper despesaMapper;
	
	 public AdiantamentoDespesaViagemMapper(DespesaMapper despesaMapper) {
		this.despesaMapper = despesaMapper;
	}


	public AdiantamentoDespesaViagemDTO toDTO(AdiantamentoDespesaViagem entity) {
		 if (entity == null) {
	        return null;
		 }
	 	 AdiantamentoDespesaViagemDTO dto = new AdiantamentoDespesaViagemDTO();
         dto.setId(entity.getId());
         dto.setNumero(entity.getNumero());
         dto.setNomeColaborador(entity.getNomeColaborador());
         dto.setStatus(entity.getStatus());
         dto.setValor(entity.getValor());

         if (entity.getDespesas() != null) {
            List<DespesaDTO> despesasDTO = entity.getDespesas().stream()
                    .map(despesaMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setDespesas(despesasDTO);
         }
        return dto;
	}

	
	 public AdiantamentoDespesaViagem toEntity(AdiantamentoDespesaViagemDTO dto) {
		 	if (dto == null) {
	            return null;
	        }
	        AdiantamentoDespesaViagem entity = new AdiantamentoDespesaViagem();
	        entity.setId(dto.getId());
	        entity.setNumero(dto.getNumero());
	        entity.setNomeColaborador(dto.getNomeColaborador());
	        entity.setStatus(dto.getStatus());
	        entity.setValor(dto.getValor());

	        if (dto.getDespesas() != null) {
	            List<Despesa> despesas = dto.getDespesas().stream()
	                    .map(despesaMapper::toEntity)
	                    .collect(Collectors.toList());
	            entity.setDespesas(despesas);
	        }
	        return entity;
	}
	
}
