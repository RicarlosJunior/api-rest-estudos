package rest.api.adv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;

@Repository
public interface AdiantamentoDespesaViagemRepository extends JpaRepository<AdiantamentoDespesaViagem, Long> {
	
}
