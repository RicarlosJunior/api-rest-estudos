/*package rest.api.adv.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import rest.api.adv.domain.model.Despesa;
import rest.api.adv.service.DespesaService;

@RestController
@RequestMapping("/despesa")
public class DespesaController {
	
	private final DespesaService despesaService;

	public DespesaController(DespesaService despesaService) {
		this.despesaService = despesaService;
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Consultar por id", description = "Recurso que consulta uma despesa por id", tags = "Despesa")
    public ResponseEntity<Despesa> findById(@PathVariable("id") Long id){
       var despesa = despesaService.findById(id);
       return ResponseEntity.ok(despesa);
    }
	
	
	@PostMapping
	@Operation(summary = "Criar despesa", description = "Recurso que cria uma despesa", tags = "Despesa")
	public ResponseEntity<Despesa> create(@RequestBody Despesa despesa){
		var despesaCreated = despesaService.create(despesa);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(despesaCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(despesaCreated);
	}
	
	
	
}*/
