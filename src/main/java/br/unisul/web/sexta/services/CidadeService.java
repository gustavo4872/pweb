package br.unisul.web.sexta.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.unisul.web.sexta.domain.Cidade;
import br.unisul.web.sexta.repositories.CidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository rep;
	

	public List<Cidade> findByEstado(Integer estadoId) {
		return rep.findCidades(estadoId);
	}

}