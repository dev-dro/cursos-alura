package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Livro;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LivroDao {

  @PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> livrosPorTitulo(String titulo) {
		return manager.createQuery("select l from Livro l where titulo like :pTitulo", Livro.class)
				.setParameter("pTitulo", "%" + titulo + "%")
				.getResultList();
	}
}
