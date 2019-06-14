package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.RedirectView;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class AutorBean {

    private Autor autor = new Autor();

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getAutores() {
        return new DAO<>(Autor.class).listaTodos();
    }

    public RedirectView gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
            new DAO<>(Autor.class).adiciona(this.autor);
        } else {
            new DAO<>(Autor.class).atualiza(this.autor);
        }

        return new RedirectView("livros");
    }

    public void carregar(Autor autor) {
        System.out.println("Carregando Autor " + autor.getNome());
        this.autor = autor;
    }

    public void remover(Autor autor) {
        System.out.println("Removendo Autor " + autor.getNome());
        new DAO<>(Autor.class).remove(autor);
    }

    public void carregaPelaId() {
        Integer id = this.autor.getId();
        this.autor = new DAO<>(Autor.class).buscaPorId(id);
        if (this.autor == null) {
            this.autor = new Autor();
        }
    }
}
