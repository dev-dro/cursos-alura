package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Autor;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposConstrucao() {
		System.out.println("[INFO] - AudtorDao foi criado");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) {

		manager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return this.manager.find(Autor.class, autorId);
	}
}
