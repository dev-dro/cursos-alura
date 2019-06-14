package br.com.alura.Teste;

import br.com.alura.Model.Produto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class LerXMLComDOM {
    static {

    }

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("src/venda.xml");

        buscarComXPath(document);

//        buscarVendaCompleta(document);
    }

    private static void buscarVendaCompleta(Document document) {

        String formaDePagamento = document.getElementsByTagName("formaDePagamento").item(0).getTextContent();
        System.out.println("Forma de Pagamento: " + formaDePagamento);

        String moeda = document.getDocumentElement().getAttribute("moeda");
        System.out.println("Moeda: " + moeda);

        NodeList tagProdutos = document.getElementsByTagName("produto");
        System.out.println("Produtos: ");
        for (int i = 0; i < tagProdutos.getLength(); i++) {
            Element element = (Element) tagProdutos.item(i);
            Produto produto = extrairProduto(element);
            System.out.println(produto);
        }
    }

    private static void buscarComXPath(Document document) throws Exception {

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/venda/produtos/produto";
        XPathExpression xPathExpression = xPath.compile(expression);

        NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Produto produto = extrairProduto(element);
            System.out.println(produto);
        }
    }

    private static Produto extrairProduto(Element element) {
        String nome = element.getElementsByTagName("nome").item(0).getTextContent();
        Double preco = Double.valueOf(element.getElementsByTagName("preco").item(0).getTextContent());
        return new Produto(nome, preco);
    }
}
