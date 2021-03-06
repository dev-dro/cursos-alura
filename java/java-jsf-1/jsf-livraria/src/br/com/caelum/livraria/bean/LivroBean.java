package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class LivroBean {

    private Livro livro = new Livro();
    private Integer autorId;

    public List<Autor> getAutores() {
        return new DAO<>(Autor.class).listaTodos();
    }

    public void gravarAutor() {
        Autor autor = new DAO<>(Autor.class).buscaPorId(autorId);
        this.livro.adicionaAutor(autor);
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());

        if (livro.getAutores().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor"));
            return;
        }

        if (this.livro.getId() == null) {
            new DAO<>(Livro.class).adiciona(this.livro);
        } else {
            new DAO<>(Livro.class).atualiza(this.livro);
        }

        this.livro = new Livro();
    }

    public void remover(Livro livro) {
        System.out.println("Removendo livro " + livro.getTitulo());
        new DAO<>(Livro.class).remove(livro);
    }

    public void carregar(Livro livro) {
        System.out.println("Carregando livro " + livro.getTitulo());
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public List<Livro> getLivros() {
        return new DAO<>(Livro.class).listaTodos();
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }

    public void removerAutor(Autor autor) {
        this.livro.removerAutor(autor);
    }

    public void carregaPelaId() {
        Integer id = this.livro.getId();
        this.livro = new DAO<>(Livro.class).buscaPorId(id);
        if (this.livro == null) this.livro = new Livro();
    }
}
