package br.com.jcavi.javaweb.sisvendas.repository;


import java.util.List;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcavi.javaweb.sisvendas.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	public List<Pedido> findAll();

	//public Pedido findById(Long id);

	List<Pedido> findByCliente(Cliente cliente);

}
