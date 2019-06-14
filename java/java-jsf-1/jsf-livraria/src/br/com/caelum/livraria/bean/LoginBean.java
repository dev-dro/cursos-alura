package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LoginBean {

    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public RedirectView efetuarLogin() {
        System.out.println("Verificando Login para o usuario " + this.usuario.getEmail());
        FacesContext context = FacesContext.getCurrentInstance();

        if (new UsuarioDAO().existe(this.usuario)) {
            context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
            return new RedirectView("livros");
        }

        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Email ou Senha inválidos"));
        return new RedirectView("login");
    }

    public RedirectView deslogar() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        return new RedirectView("login");
    }
}
