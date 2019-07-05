package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Atleta;
import br.unisul.web.sexta.domain.Categoria;
import br.unisul.web.sexta.repositories.AtletaRepository;
import br.unisul.web.sexta.repositories.CategoriaRepository;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepository rep;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Atleta find (Integer id) {
		Optional<Atleta> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Atleta insert (Atleta obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public Atleta update (Atleta obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
		
	public List<Atleta> findAll(){
		return rep.findAll();
	}
	
	public List<Atleta> search(String nome, List<Integer> ids) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndCategoriasIn(nome, categorias);
	}
}
