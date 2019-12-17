package br.com.jcavi.javaweb.sisvendas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/categoria")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class CategoriaController {

	private final CategoriaService categoriaService;
	
	//private final ProdutoService produtoService;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("categoria/listar");
		List<Categoria> categorias = this.categoriaService.listarTodas();
		mv.addObject("categorias", categorias);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView carregaAdicionar(Categoria categoria) {
		ModelAndView mv = new ModelAndView("categoria/adicionar");
		mv.addObject("categoria", categoria);
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView adicionar(@Valid Categoria categoria, BindingResult result) {
		if(result.hasErrors()) {
			return carregaAdicionar(categoria);
		}
		this.categoriaService.salvar(categoria);
		return listar();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Categoria categoria = this.categoriaService.obter(id);
		return carregaAdicionar(categoria);
	}

	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id")Long id) {
		Categoria categoria = this.categoriaService.obter(id);
		this.categoriaService.remover(categoria);
		return listar();
	}
}