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
	
	@Autowired
	private EventoService eventoService;
	
	public List<Categoria> findByEvento(Integer eventoId) {
		return rep.findCategorias(eventoId);
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		obj.setEvento(eventoService.find(obj.getEvento().getId()));
		obj = rep.save(obj);
		return obj;
	}
	
	public Categoria find (Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
}
