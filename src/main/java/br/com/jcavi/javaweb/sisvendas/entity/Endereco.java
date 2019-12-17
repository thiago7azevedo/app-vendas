package br.com.jcavi.javaweb.sisvendas.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -1894929885000943932L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}