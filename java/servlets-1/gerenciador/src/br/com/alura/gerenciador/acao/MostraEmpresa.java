package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraEmpresa implements Acao {
  @Override
  public String executa(HttpServletRequest request, HttpServletResponse response) {
    Integer id = Integer.parseInt(request.getParameter("id"));
    Empresa empresa = Banco.getEmpresa(id);
    request.setAttribute("empresa", empresa);
    return "forward:updateEmpresa.jsp";
  }
}
