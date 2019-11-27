package br.com.jcavi.javaweb.sisvendas.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.Pedido;

import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import br.com.jcavi.javaweb.sisvendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcavi.javaweb.sisvendas.entity.Categoria;
import br.com.jcavi.javaweb.sisvendas.entity.Produto;
import br.com.jcavi.javaweb.sisvendas.service.CategoriaService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/pedido")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final CategoriaService categoriaService;

    @GetMapping("")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("pedido/listar");
        List<Pedido> pedidos = pedidoService.listarTodos();
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView carregaAdicionar(Produto produto) {
        ModelAndView mv = new ModelAndView("pedido/adicionar");
        mv.addObject("produto", produto);
        List<Cliente> cliente = clienteService.listarTodos();
        mv.addObject("cliente", cliente);
        return mv;
    }
    // falta daqui para baixo
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
        Produto produto = this.produtoService.obter(id);
        return carregaAdicionar(produto);
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhar(@PathVariable("id") Long id) {
        Produto produto = this.produtoService.obter(id);
        ModelAndView mv = new ModelAndView("produto/detalhes");
        mv.addObject("produto", produto);
        List<Categoria> categorias = categoriaService.listarTodasCategorias(produto);
        mv.addObject("categorias", categorias);
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable("id")Long id) {
        Produto produto = this.produtoService.obter(id);
        this.produtoService.remover(produto);
        return listar();

    }

}