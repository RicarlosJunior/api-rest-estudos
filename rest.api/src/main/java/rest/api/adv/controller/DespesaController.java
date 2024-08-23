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
import rest.api.adv.dto.DespesaDTO;
import rest.api.adv.service.DespesaService;

@RestController
@RequestMapping("/despesa")
public class DespesaController {
	
	private final DespesaService despesaService;

	public DespesaController(DespesaService despesaService) {
		this.despesaService = despesaService;
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Consultar por id", description = "Recurso que consulta uma despesa por id", tags = "Despesas")
    public ResponseEntity<DespesaDTO> findById(@PathVariable("id") Long id){
       var despesaDTO = despesaService.findById(id);
       return ResponseEntity.ok(despesaDTO);
    }
	
	
	@PostMapping
	@Operation(summary = "Criar despesa", description = "Recurso que cria uma despesa", tags = "Despesas")
	public ResponseEntity<DespesaDTO> create(@RequestBody DespesaDTO despesaDTO){
		var despesaDTOCreated = despesaService.create(despesaDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(despesaDTOCreated.id())
				.toUri();
		return ResponseEntity.created(location).body(despesaDTOCreated);
	}
	
	
	@GetMapping
	@Operation(summary = "Consultar todos as despesas", description = "Recurso que consulta todosv as despesa", tags = "Despesas")
	public ResponseEntity<List<DespesaDTO>> findAll(){
		 var dtos = despesaService.findAll();
		 return ResponseEntity.ok(dtos);
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar por id", description = "Recurso que deleta uma despesa por id", tags = "Despesas")
	public ResponseEntity<DespesaDTO> delete(@PathVariable("id") Long id){
		despesaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Alterar uma despesa por id", description = "Recurso que altera uma despesa por id", tags = "Despesas")
	public ResponseEntity<DespesaDTO> update(@PathVariable("id") Long id, @RequestBody DespesaDTO despesaDTO){
		despesaService.update(id, despesaDTO);
		return ResponseEntity.ok(despesaDTO);
	
	}
	
}
