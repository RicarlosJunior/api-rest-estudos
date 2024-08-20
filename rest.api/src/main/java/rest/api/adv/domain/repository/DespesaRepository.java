package rest.api.adv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.api.adv.domain.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
