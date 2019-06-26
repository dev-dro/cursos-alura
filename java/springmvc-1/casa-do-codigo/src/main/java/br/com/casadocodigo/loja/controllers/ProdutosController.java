package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(Produto produto) {
        produtoDAO.gravar(produto);
        return new ModelAndView("podutos/ok");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }
}