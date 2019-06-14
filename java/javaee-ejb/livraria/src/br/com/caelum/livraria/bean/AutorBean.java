package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.modelo.Autor;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	@Inject
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.service.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.todosAutores();
	}
}
