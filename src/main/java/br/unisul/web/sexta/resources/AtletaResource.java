package br.unisul.web.sexta.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.unisul.web.sexta.domain.Atleta;
import br.unisul.web.sexta.dtos.AtletaDTO;
import br.unisul.web.sexta.resources.utils.URL;
import br.unisul.web.sexta.services.AtletaService;

@RestController
@RequestMapping(value = "/atletas")
public class AtletaResource {

	@Autowired
	private AtletaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atleta> find(@PathVariable Integer id) {
		Atleta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias) {

		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> cods = URL.decodeIntList(categorias);
		List<Atleta> list = service.search(nomeDecoded, cods);
		List<AtletaDTO> listDto = new ArrayList<AtletaDTO>();
		for (Atleta a : list) {
			listDto.add(new AtletaDTO(a));
		}
		return ResponseEntity.ok().body(listDto);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Atleta obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
