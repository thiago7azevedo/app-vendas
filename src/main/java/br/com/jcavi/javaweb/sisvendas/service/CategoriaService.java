package br.com.jcavi.javaweb.sisvendas.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;
import br.com.jcavi.javaweb.sisvendas.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
		
	public List<Categoria> listarTodas(){
		return this.categoriaRepository.findAll();
	}
	
	public Categoria obter(Long id) {
		return this.categoriaRepository.findById(id).orElseThrow(() ->
        		new ObjectNotFoundException("Categoria não encontrada", Categoria.class.getName()));
	}
	
	public void salvar(Categoria Categoria) {
		this.categoriaRepository.save(Categoria);
	}
		
	public void remover(Categoria categoria) {
		Categoria categoriaBD = obter(categoria.getId());
		this.categoriaRepository.delete(categoriaBD);
	}
	
	public List<Categoria> listarTodasCategorias(Produto produto){
		return this.categoriaRepository.findAllByProdutos(produto);
	}
	
	public List<Categoria> obterCategorias(List<Long> ids){
		return this.categoriaRepository.findAllById(ids);
	}
}