package br.unisul.web.sexta.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unisul.web.sexta.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

	//@Transactional(readOnly=true)
	//Evento findByNome(String nome);
	
	List<Evento> findDistinctByNomeContainingOrderByNome(String nome);
	
}
