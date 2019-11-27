package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.repository.EnderecoRepository;


@Service
public class EnderecoService {
	
	private final EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public List<Endereco> listarTodos(){
		return this.enderecoRepository.findAll();
	}

	public Endereco obter(Long id) {
		return this.enderecoRepository.findById(id).orElseThrow(() -> 
					new ObjectNotFoundException("Endereço não encontrado", Endereco.class.getName()));
	}
	
	public void salvar(Endereco endereco) {
		this.enderecoRepository.save(endereco);
	}
	
	public void remover(Endereco endereco) {
		Endereco enderecoBD = this.obter(endereco.getId());
		this.enderecoRepository.delete(enderecoBD);
	}
	
	public List<Endereco> listarTodosEnderecos(Cliente cliente){
		return this.enderecoRepository.findAllByCliente(cliente);
	}
}