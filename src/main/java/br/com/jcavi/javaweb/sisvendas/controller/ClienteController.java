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

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import br.com.jcavi.javaweb.sisvendas.service.EnderecoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class ClienteController {

	@Autowired
	private final ClienteService clienteService;

	@Autowired
	private final EnderecoService enderecoService;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cliente/listar");
		List<Cliente> cliente = this.clienteService.findAll();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView carregaAdicionar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/adicionar");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView adicionar(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return carregaAdicionar(cliente);
		}
		this.clienteService.salvar(cliente);
		return listar();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.findById(id);
		return carregaAdicionar(cliente);
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.findById(id);
		ModelAndView mv = new ModelAndView("cliente/detalhes");
		mv.addObject("cliente", cliente);
		List<Endereco> enderecos = enderecoService.listarTodosEnderecos(cliente);
		mv.addObject("enderecos", enderecos);
		return mv;	
	}

	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		clienteService.delete(id);
		return listar();		
	}
}