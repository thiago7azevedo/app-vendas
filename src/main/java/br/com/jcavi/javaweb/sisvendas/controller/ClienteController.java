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

	private final ClienteService clienteService;
	
	private final EnderecoService enderecoService;
	
	// O uso do lombok (@RequiredArgsConstructor(onConstructor=@__(@Autowired)))
	// faz com que não seja necessário criar o construtor recebendo os services
	// e marcar este construtor com @Autowired
	/*
	@Autowired
	public ClienteController(ClienteService clienteService, EnderecoService enderecoService) {
		this.clienteService = clienteService;
		this.enderecoService = enderecoService;
	}
	*/
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cliente/listar");
		List<Cliente> clientes = this.clienteService.listarTodos();
		mv.addObject("clientes", clientes);
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
		Cliente cliente = this.clienteService.obter(id);
		return carregaAdicionar(cliente);
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhar(@PathVariable("id") Long id) {
		Cliente cliente = this.clienteService.obter(id);
		ModelAndView mv = new ModelAndView("cliente/detalhes");
		mv.addObject("cliente", cliente);
		List<Endereco> enderecos = enderecoService.listarTodosEnderecos(cliente);
		mv.addObject("enderecos", enderecos);
		return mv;	
	}
	
	@PostMapping("/detalhes/{id}")
	public String salvarEndereco(@PathVariable("id") Long id, Endereco endereco) {
		Cliente cliente = this.clienteService.obter(id);
		endereco.setCliente(cliente);
		enderecoService.salvar(endereco);
		return "redirect:/cliente/detalhes/{id}";
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id")Long id) {
		Cliente cliente = this.clienteService.obter(id);
		this.clienteService.remover(cliente);
		return listar();		
	}
}