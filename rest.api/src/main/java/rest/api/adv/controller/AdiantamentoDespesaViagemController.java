package rest.api.adv.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import rest.api.adv.dto.AdiantamentoDespesaViagemDTO;
import rest.api.adv.service.AdiantamentoDespesaViagemService;

@RestController
@RequestMapping("/advs")
public class AdiantamentoDespesaViagemController {

	private final AdiantamentoDespesaViagemService adiantamentoDespesaViagemService;

	public AdiantamentoDespesaViagemController(AdiantamentoDespesaViagemService adiantamentoDespesaViagemService) {
		this.adiantamentoDespesaViagemService = adiantamentoDespesaViagemService;
	}

	
	@GetMapping("/{id}")
	@Operation(summary = "Consultar por id", description = "Recurso que consulta um adiantamento de despesa de viagem por id", tags = "ADV")
    public ResponseEntity<AdiantamentoDespesaViagemDTO> findById(@PathVariable("id") Long id){
       var adiantamentoDespesaViagemDTO = adiantamentoDespesaViagemService.findById(id);
       return ResponseEntity.ok(adiantamentoDespesaViagemDTO);
    }
	
	
	@PostMapping
	@Operation(summary = "Criar A.D.V", description = "Recurso que cria um adiantamento de despesa de viagem", tags = "ADV")
	public ResponseEntity<AdiantamentoDespesaViagemDTO> create(@RequestBody AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO){
		var advDTO = adiantamentoDespesaViagemService.create(adiantamentoDespesaViagemDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(advDTO.id())
				.toUri();
		return ResponseEntity.created(location).body(advDTO);
	}
	
	
	@GetMapping
	@Operation(summary = "Consultar todos os A.D.V", description = "Recurso que consulta todos os adiantamento de despesa de viagens", tags = "ADV")
	public ResponseEntity<List<AdiantamentoDespesaViagemDTO>> findAll(){
		 var dtos = adiantamentoDespesaViagemService.findAll();
		 return ResponseEntity.ok(dtos);
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar por id", description = "Recurso que deleta um adiantamento de despesa de viagens por id", tags = "ADV")
	public ResponseEntity<AdiantamentoDespesaViagemDTO> delete(@PathVariable("id") Long id){
		adiantamentoDespesaViagemService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Alterar um A.D.V por id", description = "Recurso que altera um adiantamento de despesa de viagens por id", tags = "ADV")
	public ResponseEntity<AdiantamentoDespesaViagemDTO> update(@PathVariable("id") Long id, @RequestBody AdiantamentoDespesaViagemDTO adiantamentoDespesaViagemDTO){
		adiantamentoDespesaViagemService.update(id, adiantamentoDespesaViagemDTO);
		return ResponseEntity.ok(adiantamentoDespesaViagemDTO);
	
	}
	
	
	@PutMapping("/fechar/{id}")
	@Operation(summary = "Efetuar o fechamento de um A.D.V por id", description = "Recurso que efetua um fechamento de um adiantamento de despesa de viagens por id", tags = "ADV")
	public ResponseEntity<AdiantamentoDespesaViagemDTO> efetuarFechamento(@PathVariable("id") Long id){
		adiantamentoDespesaViagemService.efetuarFechamento(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
