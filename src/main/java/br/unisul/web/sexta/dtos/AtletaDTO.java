package br.unisul.web.sexta.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import br.unisul.web.sexta.domain.Atleta;

public class AtletaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=120, message="O tamanho deve ser entre 1 e 120 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer idade;
	private String equipe;
	
	public AtletaDTO() {
	}
	
	public AtletaDTO(Integer id, String nome, Integer idade, String equipe) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.equipe = equipe;
	}
	
	public AtletaDTO(Atleta obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.idade = obj.getIdade();
		this.equipe = obj.getEquipe();
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
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
		AtletaDTO other = (AtletaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
