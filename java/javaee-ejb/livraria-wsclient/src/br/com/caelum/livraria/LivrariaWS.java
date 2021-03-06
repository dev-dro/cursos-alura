
package br.com.caelum.livraria;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LivrariaWS", targetNamespace = "http://webservice.livraria.caelum.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LivrariaWS {


    /**
     * 
     * @param titulo
     * @return
     *     returns java.util.List<br.com.caelum.livraria.Livro>
     */
    @WebMethod
    @WebResult(name = "Livro", targetNamespace = "")
    @RequestWrapper(localName = "getLivrosPorTitulo", targetNamespace = "http://webservice.livraria.caelum.com.br/", className = "br.com.caelum.livraria.GetLivrosPorTitulo")
    @ResponseWrapper(localName = "getLivrosPorTituloResponse", targetNamespace = "http://webservice.livraria.caelum.com.br/", className = "br.com.caelum.livraria.GetLivrosPorTituloResponse")
    public List<Livro> getLivrosPorTitulo(
        @WebParam(name = "titulo", targetNamespace = "")
        String titulo);

}
