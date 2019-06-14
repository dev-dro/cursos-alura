package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Acao {

  @Override
  public String executa(HttpServletRequest request, HttpServletResponse response) {
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");

    Usuario usuario = Banco.existeUsuario(login, senha);
    if (usuario != null) {
      HttpSession sessao = request.getSession();
      sessao.setAttribute("usuarioLogado", usuario);
      return "redirect:entrada?acao=ListaEmpresas";
    }
    else return "redirect:entrada?acao=LoginForm";
  }
}
