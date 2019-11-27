package br.com.jcavi.javaweb.sisvendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public List<Cliente> findAll();
	
	public List<Cliente> findAllByNome(String nome);
	
	public Cliente findByNome(String nome);

}
