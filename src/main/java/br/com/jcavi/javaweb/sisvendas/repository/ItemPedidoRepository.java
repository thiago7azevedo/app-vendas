package br.com.jcavi.javaweb.sisvendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcavi.javaweb.sisvendas.entity.ItemPedido;
import br.com.jcavi.javaweb.sisvendas.entity.Pedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

	public List<ItemPedido> findAll();
	
	//public List<ItemPedido> findAllByPedido(Pedido pedido);
}
