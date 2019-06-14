package br.com.alura.Teste;

import br.com.alura.Handlers.ProdutosHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.InputStream;

public class LerXMLComSAX {
    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        ProdutosHandler produtosHandler = new ProdutosHandler();
        reader.setContentHandler(produtosHandler);

        InputStream inputStream = new FileInputStream("src/venda.xml");
        InputSource source = new InputSource(inputStream);

        reader.parse(source);
        System.out.println(produtosHandler.getProdutos());
    }
}
