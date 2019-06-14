package br.com.alura.Teste;

import br.com.alura.Model.Produto;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LerXMLComSTAX {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = new FileInputStream("src/venda.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(inputStream);

        List<Produto> produtos = new ArrayList<>();

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
                Produto produto = montarProduto(reader);
                produtos.add(produto);
            }
        }

        System.out.println(produtos);
    }

    private static Produto montarProduto(XMLEventReader events) throws Exception{
        Produto produto = new Produto();

        while (events.hasNext()) {
            XMLEvent event = events.nextEvent();

            if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
                event = events.nextEvent();
                produto.setNome(event.asCharacters().getData());
            } else if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
                event = events.nextEvent();
                produto.setPreco(Double.valueOf(event.asCharacters().getData()));
            } else if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
                break;
            }
        }

        return produto;
    }
}
