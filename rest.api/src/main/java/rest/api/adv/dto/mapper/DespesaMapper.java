package rest.api.adv.dto.mapper;

import org.springframework.stereotype.Component;

import rest.api.adv.domain.model.Despesa;
import rest.api.adv.dto.DespesaDTO;

@Component
public class DespesaMapper {

	public DespesaDTO toDTO(Despesa entity) {
        if (entity == null) {
            return null;
        }
        DespesaDTO dto = new DespesaDTO();
        dto.setId(entity.getId());
        dto.setNumero(entity.getNumero());
        dto.setDescricao(entity.getDescricao());
        dto.setValor(entity.getValor());
        //dto.setAdiantamentoDespesaViagem(convertToDTO(despesa.getAdiantamentoDespesaViagem()));
        return dto;
    }

    public Despesa toEntity(DespesaDTO dto) {
        if (dto == null) {
            return null;
        }
        Despesa despesa = new Despesa();
        despesa.setId(dto.getId());
        despesa.setNumero(dto.getNumero());
        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());
        //despesa.setAdiantamentoDespesaViagem(convertToEntity(dto.getAdiantamentoDespesaViagem()));
        return despesa;
    }
	
	
}
