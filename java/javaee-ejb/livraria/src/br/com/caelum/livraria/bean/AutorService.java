package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AutorService {

  @Inject
  private AutorDao dao;

  public void adiciona(Autor autor) {
    this.dao.salva(autor);
  }

  public List<Autor> todosAutores() {
    return this.dao.todosAutores();
  }
}
