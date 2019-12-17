package br.com.jcavi.javaweb.sisvendas.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.jcavi.javaweb.sisvendas.service.UploadService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;
import br.com.jcavi.javaweb.sisvendas.service.CategoriaService;
import br.com.jcavi.javaweb.sisvendas.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@Data
@Controller
@RequestMapping("/produto")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class ProdutoController {

	private final ProdutoService produtoService;
	
	private final CategoriaService categoriaService;

	private final UploadService uploadService;
		
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("produto/listar");
		List<Produto> produtos = produtoService.listarTodos();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView carregaAdicionar(Produto produto) {
		ModelAndView mv = new ModelAndView("produto/adicionar");
		mv.addObject("produto", produto);
		List<Categoria> categorias = categoriaService.listarTodas();
		mv.addObject("categorias", categorias);
		return mv;
	}
		
	@PostMapping("/adicionar")
	public ModelAndView adicionar(@Valid Produto produto, @RequestParam("file") MultipartFile file, BindingResult result) {
		if(result.hasErrors()) {
			return carregaAdicionar(produto);
		}
		uploadService.salvar(file);
		produto.setLogo(file.getOriginalFilename());
		this.produtoService.salvar(produto);
		return listar();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Produto produto = produtoService.obter(id);
		return carregaAdicionar(produto);
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		this.produtoService.remover(id);
		return listar();
	}
}