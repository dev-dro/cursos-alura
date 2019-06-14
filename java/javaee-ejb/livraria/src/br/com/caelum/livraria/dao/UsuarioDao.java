package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		return this.manager.createQuery("select u from Usuario u where login = :pLogin", Usuario.class)
				.setParameter("pLogin", login).getSingleResult();
	}
}
