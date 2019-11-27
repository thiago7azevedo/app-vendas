package br.com.jcavi.javaweb.sisvendas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Endereco extends BaseEntity {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -1894929885000943932L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Endereço é obrigatório")
	private String logradouro;
	
	@NotEmpty(message="Bairro é obrigatório")
	private String bairro;
	
	@NotEmpty(message="Cidade é obrigatório")
    private String cidade;
	
	@NotEmpty(message="UF é obrigatório")
	private String uf;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	
}