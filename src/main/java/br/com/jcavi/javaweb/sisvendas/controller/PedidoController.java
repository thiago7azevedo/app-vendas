package br.com.jcavi.javaweb.sisvendas.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Pedido;

import br.com.jcavi.javaweb.sisvendas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/venda")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("venda/listar");
        List<Pedido> pedidos = pedidoService.listarTodos();
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView carregaAdicionar(Pedido pedido) {
        ModelAndView mv = new ModelAndView("venda/adicionar");
        List<Cliente> clientes = clienteService.listarTodos();
        List<Produto> produtos = produtoService.listarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("clientes", clientes);
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(@Valid Pedido pedido, BindingResult result) {
        if (result.hasErrors()) {
            return carregaAdicionar(pedido);
        }
        pedidoService.salvar(pedido);
        return listar();
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable Long id) {
        pedidoService.remover(id);
        return listar();
    }
}