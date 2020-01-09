package br.com.jcavi.javaweb.sisvendas.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import br.com.jcavi.javaweb.sisvendas.auth.ClienteLogado;
import br.com.jcavi.javaweb.sisvendas.entity.*;

import br.com.jcavi.javaweb.sisvendas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/venda")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("venda/listar");
        UserSS userSS = ClienteLogado.authenticated();
        Cliente cliente = clienteService.findById(userSS.getId());
        List<Pedido> pedidos = pedidoService.buscarPedidoCliente(cliente);
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView carregaAdicionar(Pedido pedido) {
        ModelAndView mv = new ModelAndView("venda/adicionar");
        List<Cliente> clientes = clienteService.findAll();
        List<Produto> produtos = produtoService.listarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("clientes", clientes);
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(Pedido pedido,
                                  @RequestParam("produtos[]") List<Long> produtos,
                                  @RequestParam("quantidades[]") List<Integer> quantidades,
                                  @RequestParam("descontos[]") List<Double> descontos, BindingResult result) {
        pedido.setDataPedido(LocalDate.now());

        if (result.hasErrors()) {
            return carregaAdicionar(pedido);
        }

        Set<ItemPedido> itens = new HashSet<>();
        ItemPedido itemPedido = null;
        Produto produto = null;
        for (int i = 0; i < produtos.size(); i++) {
            itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            produto = produtoService.obter(produtos.get(i));
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(quantidades.get(i));
            itemPedido.setDesconto(descontos.get(i));
            itens.add(itemPedido);
        }
        pedido.setItemPedidos(itens);
        pedidoService.salvar(pedido);
        return listar();
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable Long id) {
        pedidoService.remover(id);
        return listar();
    }
}