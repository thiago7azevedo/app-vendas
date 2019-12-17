package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;
import br.com.jcavi.javaweb.sisvendas.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> listarTodos(){
		return this.produtoRepository.findAll();
	}
	
	public Produto obter(Long id) {
		return this.produtoRepository.findById(id).orElseThrow(() ->
        		new ObjectNotFoundException("Produto não encontrado", Produto.class.getName()));
	}
	
	public void salvar(Produto produto) {
		this.produtoRepository.save(produto);
	}
		
	public void remover(Long id) {
		Produto produto = obter(id);
		this.produtoRepository.delete(produto);
	}
	
	public List<Produto> listarTodasCategoria(Categoria categoria){
		return this.produtoRepository.findAllByCategorias(categoria);
	}
}