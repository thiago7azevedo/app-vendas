package br.com.jcavi.javaweb.sisvendas.controller;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Endereco;
import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import br.com.jcavi.javaweb.sisvendas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final ClienteService clienteService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService, ClienteService clienteService) {
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @PostMapping("/salvar/{id}")
    public String salvarEndereco(@PathVariable("id") Long id, Endereco endereco) {
        Cliente cliente = clienteService.findById(id);
        endereco.setCliente(cliente);
        enderecoService.salvar(endereco);
        return "redirect:/cliente/detalhes/{id}";
    }

}