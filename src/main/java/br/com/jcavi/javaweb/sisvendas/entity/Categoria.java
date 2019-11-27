package br.com.jcavi.javaweb.sisvendas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Getter
@Setter
@NoArgsConstructor
public class Categoria extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2119591136104524986L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos; 		
}