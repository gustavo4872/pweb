package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.unisul.web.sexta.domain.Evento;
import br.unisul.web.sexta.dtos.EventoDTO;
import br.unisul.web.sexta.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;
	
	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Evento update(Evento obj) {
		Evento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public List<Evento> findAll() {
		return repo.findAll();
	}
	
	public Evento fromDTO(EventoDTO objDto) {
		return new Evento(objDto.getId(), objDto.getNome(), objDto.getData());
	}
	
	private void updateData(Evento newObj, Evento obj) {
		newObj.setNome(obj.getNome());
		newObj.setData(obj.getData());
	}
	
	@Transactional
	public Evento insert(Evento obj) {
		obj.setId(null);
		obj = repo.save(obj);		
		return obj;
	}
	
	public List<Evento> search (String nome){
		return repo.findDistinctByNomeContainingOrderByNome(nome);
	}
	
}
