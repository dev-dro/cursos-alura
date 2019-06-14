package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UsuarioDAO {

    public boolean existe(Usuario usuario) {
        EntityManager em = new JPAUtil().getEntityManager();
        boolean resultado = false;
        try {
            resultado = em.createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha", Usuario.class)
                    .setParameter("pEmail", usuario.getEmail())
                    .setParameter("pSenha", usuario.getSenha())
                    .getSingleResult() != null;
        } catch (NoResultException ignored) {
        }

        em.close();
        return resultado;
    }
}
