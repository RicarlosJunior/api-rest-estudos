package rest.api.adv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rest.api.adv.domain.model.AdiantamentoDespesaViagem;

@Repository
public interface AdiantamentoDespesaViagemRepository extends JpaRepository<AdiantamentoDespesaViagem, Long> {
	
	@Modifying
	@Query("UPDATE AdiantamentoDespesaViagem a SET a.status =:status WHERE a.id =:id")
	void updateStatus(@Param("id") Long id, @Param("status") String status);
}
