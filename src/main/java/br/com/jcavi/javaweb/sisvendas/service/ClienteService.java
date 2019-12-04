package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> listarTodos(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente obter(Long id) {
		return this.clienteRepository.findById(id).orElseThrow(() ->
        		new ObjectNotFoundException("Cliente não encontrado", Cliente.class.getName()));
	}
	
	public void salvar(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		Cliente cliente = obter(id);
		clienteRepository.delete(cliente);
	}
}