package br.com.alura.Teste;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConverterParaHtml {
    public static void main(String[] args) throws Exception{
        InputStream xsl = new FileInputStream("src/xmlParaHtml.xsl");
        StreamSource xslSource = new StreamSource(xsl);

        InputStream vendasXML = new FileInputStream("src/venda.xml");
        StreamSource xmlSource = new StreamSource(vendasXML);

        Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
        StreamResult result = new StreamResult("src/vendas.html");
        transformer.transform(xmlSource, result);

        System.out.println("Arquivo convertido.");
    }
}
