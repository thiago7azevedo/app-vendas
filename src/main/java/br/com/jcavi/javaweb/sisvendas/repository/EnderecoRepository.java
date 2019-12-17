package br.com.jcavi.javaweb.sisvendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	public List<Endereco> findAllByCliente(Cliente cliente);

}
