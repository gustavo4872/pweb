package br.unisul.web.sexta.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unisul.web.sexta.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
//JpaRepository<Domain, Chave primaria domain>
	
	//@Transactional(readOnly=true)
	//public List<Estado> findAllByOrderByNome();
	List<Estado> findDistinctByNomeContainingOrderByNome(String nome);
}
