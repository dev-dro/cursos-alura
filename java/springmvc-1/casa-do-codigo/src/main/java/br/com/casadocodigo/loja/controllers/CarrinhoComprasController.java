package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping(value = "/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
        CarrinhoItem item = createItem(produtoId, tipoPreco);
        carrinho.add(item);

        return new ModelAndView("redirect:/produtos");
    }

    private CarrinhoItem createItem(Integer produtoId, TipoPreco tipoPreco) {
        return new CarrinhoItem(produtoDAO.find(produtoId), tipoPreco);
    }
}
