package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao {
  @Override
  public String executa(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Banco.deleteEmpresa(id);
    return "redirect:entrada?acao=ListaEmpresas";
  }
}
