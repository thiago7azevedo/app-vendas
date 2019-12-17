package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import br.com.jcavi.javaweb.sisvendas.entity.Role;
import br.com.jcavi.javaweb.sisvendas.repository.RoleRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository, RoleRepository roleRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException("Cliente não encontrado", Cliente.class.getName()));
	}

	public Cliente findByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}

	public void salvar(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
	}

//	public List<Cliente> buscarPorEmail(String email) {
//		return clienteRepository.findByEmail(email);
//	}
//	public List<Cliente> checaListaNaoVazia(List<Cliente> clientes) {
//		if (clientes.size() > 0) {
//			return clientes;
//		} else {
//			return null;
//		}
//	}
//	public List<Cliente> buscarPorLogin(String login) {
//		List<Cliente> clientes = clienteRepository.findByEmail(login);
//
//		return checaListaNaoVazia(clientes);
//	}

}