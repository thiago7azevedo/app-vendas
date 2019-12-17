package br.com.jcavi.javaweb.sisvendas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findAll();
	
	public List<Produto> findAllByNome(String nome);
	
	public Produto findByNome(String nome);
	
	public List<Produto> findAllByValorBetween(BigDecimal inicio, BigDecimal fim);
	
	public List<Produto> findAllByCategorias(Categoria categoria);

}
