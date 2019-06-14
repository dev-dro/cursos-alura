package br.com.alura.Teste;

import br.com.alura.Model.Venda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

public class MapeiaXML {
    public static void main(String[] args) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Venda.class);

        Venda venda = xmlParaObjeto(context);
        System.out.println(venda);

        String xml = objetoParaObjeto(context, venda);
        System.out.println(xml);
    }

    private static String objetoParaObjeto(JAXBContext context, Venda venda) throws Exception{
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(venda, writer);
        return writer.toString();
    }

    private static Venda xmlParaObjeto(JAXBContext context) throws Exception {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Venda) unmarshaller.unmarshal(new File("src/venda.xml"));
    }
}
