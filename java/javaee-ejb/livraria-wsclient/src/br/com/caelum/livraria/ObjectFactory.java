
package br.com.caelum.livraria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.livraria package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLivrosPorTitulo_QNAME = new QName("http://webservice.livraria.caelum.com.br/", "getLivrosPorTitulo");
    private final static QName _GetLivrosPorTituloResponse_QNAME = new QName("http://webservice.livraria.caelum.com.br/", "getLivrosPorTituloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.livraria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLivrosPorTituloResponse }
     * 
     */
    public GetLivrosPorTituloResponse createGetLivrosPorTituloResponse() {
        return new GetLivrosPorTituloResponse();
    }

    /**
     * Create an instance of {@link GetLivrosPorTitulo }
     * 
     */
    public GetLivrosPorTitulo createGetLivrosPorTitulo() {
        return new GetLivrosPorTitulo();
    }

    /**
     * Create an instance of {@link Livro }
     * 
     */
    public Livro createLivro() {
        return new Livro();
    }

    /**
     * Create an instance of {@link Autor }
     * 
     */
    public Autor createAutor() {
        return new Autor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivrosPorTitulo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.livraria.caelum.com.br/", name = "getLivrosPorTitulo")
    public JAXBElement<GetLivrosPorTitulo> createGetLivrosPorTitulo(GetLivrosPorTitulo value) {
        return new JAXBElement<GetLivrosPorTitulo>(_GetLivrosPorTitulo_QNAME, GetLivrosPorTitulo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivrosPorTituloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.livraria.caelum.com.br/", name = "getLivrosPorTituloResponse")
    public JAXBElement<GetLivrosPorTituloResponse> createGetLivrosPorTituloResponse(GetLivrosPorTituloResponse value) {
        return new JAXBElement<GetLivrosPorTituloResponse>(_GetLivrosPorTituloResponse_QNAME, GetLivrosPorTituloResponse.class, null, value);
    }

}
