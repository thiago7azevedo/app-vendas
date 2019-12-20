package br.com.jcavi.javaweb.sisvendas.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = -2119591136104524986L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
//	@NotNull(message="Preço é obrigatório")
	private Double preco;
	
	@NotNull(message="Quantidade é obrigatório")
	private Integer quantidade;
	
	private Double desconto;	
	
	public ItemPedido() {}
	
	public ItemPedido(Produto produto, Pedido pedido, Double preco, Integer qtde, Double desc) {
		this.id.setProduto(produto);
		this.id.setPedido(pedido);
		this.preco = preco;
		this.quantidade = qtde;
		this.desconto = desc;
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return this.id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		this.id.setProduto(produto);
	}
	
	public Pedido getPedido() {
		return this.id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		this.id.setPedido(pedido);
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}	
}