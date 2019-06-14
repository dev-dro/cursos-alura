package br.com.caelum.livraria.webservice;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;
import java.util.List;

@WebService
@Stateless
public class LivrariaWS {

  @Inject
  private LivroDao dao;

  @WebResult(name = "Livro")
  public List<Livro> getLivrosPorTitulo(@WebParam(name = "titulo") String titulo) {
    System.out.println("[LivrariaWS] - Procurando pelo titulo: "  + titulo);
    return dao.livrosPorTitulo(titulo);
  }
}
