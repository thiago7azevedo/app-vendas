package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.ItemPedido;
import br.com.jcavi.javaweb.sisvendas.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	
	public List<ItemPedido> listarTodos(){
		return this.itemPedidoRepository.findAll();
	}
	
	public ItemPedido obter(Long id) {
		return this.itemPedidoRepository.findById(id).orElseThrow(() ->
        		new ObjectNotFoundException("ItemPedido não encontrado", ItemPedido.class.getName()));
	}
	
	public void salvar(ItemPedido ItemPedido) {
		this.itemPedidoRepository.save(ItemPedido);
	}
		
//	public void remover(ItemPedido itemPedido) {
//		ItemPedido itemPedidoBD = obter(itemPedido.getId());
//		this.itemPedidoRepository.delete(itemPedidoBD);
//	}
}