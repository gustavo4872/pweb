package br.unisul.web.sexta.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Atleta;
import br.unisul.web.sexta.domain.Categoria;
import br.unisul.web.sexta.domain.Evento;
import br.unisul.web.sexta.repositories.AtletaRepository;
import br.unisul.web.sexta.repositories.CategoriaRepository;
import br.unisul.web.sexta.repositories.EventoRepository;

@Service
public class DbService {
	
	@Autowired
	private EventoRepository eveRep;
	
	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private AtletaRepository atlRep;
	
	public void inicializaBancoDeDados() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
		
		Evento eve1 = new Evento(null, "Cortuba Meia Maratona Tubarão",  sdf.parse("10/10/2019 19:35"));
		
		Categoria cat1 = new Categoria(null, "5Km Masculino", eve1);
		Categoria cat2 = new Categoria(null, "5Km Feminino", eve1);
		Categoria cat3 = new Categoria(null, "10Km Masculino", eve1);
		Categoria cat4 = new Categoria(null, "10Km Feminino", eve1);
		Categoria cat5 = new Categoria(null, "21Km Masculino", eve1);
		Categoria cat6 = new Categoria(null, "21Km Feminino", eve1);
		
		Atleta atl1 = new Atleta(null, "XXXX XXXX", 18, "XX");
		Atleta atl2 = new Atleta(null, "XXXX XXXX", 19, "XX");
		Atleta atl3 = new Atleta(null, "XXXX XXXX", 20, "XX");
		Atleta atl4 = new Atleta(null, "XXXX XXXX", 21, "XX");
		Atleta atl5 = new Atleta(null, "XXXX XXXX", 22, "XX");
		Atleta atl6 = new Atleta(null, "XXXX XXXX", 23, "XX");
		Atleta atl7 = new Atleta(null, "XXXX XXXX", 24, "XX");
		Atleta atl8 = new Atleta(null, "XXXX XXXX", 25, "XX");
		Atleta atl9 = new Atleta(null, "XXXX XXXX", 26, "XX");
		Atleta atl10 = new Atleta(null, "XXXX XXXX", 27, "XX");
		
		eve1.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6));
		atl1.getCategorias().addAll(Arrays.asList(cat1));
		atl2.getCategorias().addAll(Arrays.asList(cat2));
		atl3.getCategorias().addAll(Arrays.asList(cat3));
		atl4.getCategorias().addAll(Arrays.asList(cat4));
		atl5.getCategorias().addAll(Arrays.asList(cat5));
		atl6.getCategorias().addAll(Arrays.asList(cat6));
		atl7.getCategorias().addAll(Arrays.asList(cat1));
		atl8.getCategorias().addAll(Arrays.asList(cat1));
		atl9.getCategorias().addAll(Arrays.asList(cat2));
		atl10.getCategorias().addAll(Arrays.asList(cat3));
		
		eveRep.saveAll(Arrays.asList(eve1));
		catRep.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6));
		atlRep.saveAll(Arrays.asList(atl1,atl2,atl3,atl4,atl5,atl6,atl7,atl8,atl9,atl10));
	}

}
