package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Categoria;
import br.unisul.web.sexta.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	//BUSCAR POR ID
	public Categoria find (Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Categoria insert (Categoria obj) {
		obj.setId(null); //nulo para não salvar45
		return rep.save(obj);
	}
	
	//ATUAlIZAR
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
		
	//LISTAR
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
	public List<Categoria> search (String nome){
		return rep.findDistinctByNomeContainingOrderByNome(nome);
	}
	
}
