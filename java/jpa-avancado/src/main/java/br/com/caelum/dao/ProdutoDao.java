package br.com.caelum.dao;

import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);

		Path<String> nomePath = root.get("nome");
		Path<Integer> lojaPath = root.<Loja> get("loja").get("id");
		Path<Integer> categoriaPath = root.join("categorias").get("id");

		List<Predicate> predicates = new ArrayList<>();

		if (!nome.isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, nome);
			predicates.add(nomeIgual);
		}

		if (categoriaId != null) {
			Predicate categoriaIgual = criteriaBuilder.equal(categoriaPath, categoriaId);
			predicates.add(categoriaIgual);
		}

		if (lojaId != null) {
			Predicate lojaIgual = criteriaBuilder.equal(lojaPath, lojaId);
			predicates.add(lojaIgual);
		}

		query.where((Predicate[]) predicates.toArray());

		TypedQuery<Produto> typedQuery = em.createQuery(query);
		typedQuery.setHint("org.hibernate.cacheable", "true");
		return typedQuery.getResultList();
	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
