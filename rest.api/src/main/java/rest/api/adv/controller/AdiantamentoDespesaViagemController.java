package rest.api.adv.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;
import rest.api.adv.service.AdiantamentoDespesaViagemService;

@RestController
@RequestMapping("/advs")
public class AdiantamentoDespesaViagemController {

	private final AdiantamentoDespesaViagemService adiantamentoDespesaViagemService;

	public AdiantamentoDespesaViagemController(AdiantamentoDespesaViagemService adiantamentoDespesaViagemService) {
		this.adiantamentoDespesaViagemService = adiantamentoDespesaViagemService;
	}

	
	@GetMapping("/{id}")
    public ResponseEntity<AdiantamentoDespesaViagem> findById(@PathVariable Long id) {
       var adiantamentoDespesaViagem = adiantamentoDespesaViagemService.findById(id);
       return ResponseEntity.ok(adiantamentoDespesaViagem);
    }
	
	
	@PostMapping
	public ResponseEntity<AdiantamentoDespesaViagem> create(@RequestBody AdiantamentoDespesaViagem adiantamentoDespesaViagem){
		var advCreated = adiantamentoDespesaViagemService.create(adiantamentoDespesaViagem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(advCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(advCreated);
	}
	
}
