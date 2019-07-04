package br.com.casadocodigo.loja.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }

    public Integer getQuantidade() {
        return itens.values().stream().reduce(0, Integer::sum);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoItem item : getItens()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getTotal(getQuantidade(item));
    }

    public Collection<CarrinhoItem> getItens() {
        return itens.keySet();
    }

    public Integer getQuantidade(CarrinhoItem item) {
        if (!itens.containsKey(item)) {
            itens.put(item, 0);
        }
        return itens.get(item);
    }


}
