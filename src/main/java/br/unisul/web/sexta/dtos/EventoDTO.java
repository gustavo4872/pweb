package br.unisul.web.sexta.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import br.unisul.web.sexta.domain.Evento;

public class EventoDTO implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=120, message="O tamanho deve ser entre 1 e 120 caracteres")
	private String nome;	
	@NotEmpty(message="Preenchimento obrigatório")	
	private Date data;

	public EventoDTO() {
	}
	
	public EventoDTO(Integer id, String nome, Date data) {
		this.id = id;
		this.nome = nome;
		this.data = data;
	}
	
	public EventoDTO(Evento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.data = obj.getData();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoDTO other = (EventoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
