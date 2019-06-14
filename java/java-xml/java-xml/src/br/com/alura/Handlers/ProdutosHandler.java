package br.com.alura.Handlers;

import br.com.alura.Model.Produto;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ProdutosHandler extends DefaultHandler {

    private List<Produto> produtos = new ArrayList<>();
    private Produto produto;
    private StringBuilder conteudo;

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("produto")) {
            produto = new Produto();
        }

        conteudo = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        conteudo.append( new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("nome")) {
            produto.setNome(conteudo.toString());
        } else if (qName.equals("preco")) {
            produto.setPreco(Double.valueOf(conteudo.toString()));
        } else if (qName.equals("produto")) {
            produtos.add(produto);
        }
    }
}
