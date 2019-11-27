package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Pedido;
import br.com.jcavi.javaweb.sisvendas.repository.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public List<Pedido> listarTodos(){
		return this.pedidoRepository.findAll();
	}
	
	public Pedido obter(Long id) {
		return this.pedidoRepository.findById(id).orElseThrow(() ->
        		new ObjectNotFoundException("Pedido não encontrado", Pedido.class.getName()));
	}
	
	public void salvar(Pedido Pedido) {
		this.pedidoRepository.save(Pedido);
	}
		
	public void remover(Pedido pedido) {
		Pedido pedidoBD = obter(pedido.getId());
		this.pedidoRepository.delete(pedidoBD);
	}
}