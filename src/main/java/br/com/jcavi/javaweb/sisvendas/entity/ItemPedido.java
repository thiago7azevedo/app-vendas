package br.com.jcavi.javaweb.sisvendas.entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class ItemPedido extends BaseEntity {

	private static final long serialVersionUID = -2119591136104524986L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	@NotEmpty(message="Preço é obrigatório")
	private BigDecimal preco;
	
	@NotEmpty(message="Quantidade é obrigatório")
	private Integer quantidade;
	
	private Double desconto;	
	
	public ItemPedido() {}
	
	public ItemPedido(Produto produto, Pedido pedido, BigDecimal preco, Integer qtde, Double desc) {
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
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
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