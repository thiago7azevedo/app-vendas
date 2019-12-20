package br.com.jcavi.javaweb.sisvendas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 7432755522641254584L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@NotEmpty(message="Data é obrigatório")
	private LocalDate dataPedido;
			
	@ManyToOne
	@JoinColumn(name="id_cliente")
//	@NotEmpty(message="Cliente é obrigatório")
	private Cliente cliente;
	
	@OneToMany(mappedBy="id.pedido", cascade=CascadeType.ALL)
	private Set<ItemPedido> itemPedidos = new HashSet<>();
			
	public Pedido() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}		
}