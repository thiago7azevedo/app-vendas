package br.com.jcavi.javaweb.sisvendas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 7432755522641254584L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull(message = "Please enter id")
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@NotNull(message="Valor é obrigatório")
	@DecimalMin(message="Valor mínimo exigido",value="0.01")
	private Double valor;
	
	@NotNull(message="Quantidade é obrigatório")
	private Integer quantidade;

	private String logo;

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="produto_categoria",
			   joinColumns=@JoinColumn(name="id_categoria"),
			   inverseJoinColumns=@JoinColumn(name="id_produto"))
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy="id.produto", cascade=CascadeType.ALL)
	private Set<ItemPedido> itemPedidos = new HashSet<>();
			
	public Produto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
}