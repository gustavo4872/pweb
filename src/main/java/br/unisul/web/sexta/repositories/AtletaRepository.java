package br.unisul.web.sexta.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.unisul.web.sexta.domain.Atleta;
import br.unisul.web.sexta.domain.Categoria;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

	List<Atleta> findDistinctByNomeContainingAndCategoriasIn(
			String nome,
			List<Categoria> categorias
	);
}
