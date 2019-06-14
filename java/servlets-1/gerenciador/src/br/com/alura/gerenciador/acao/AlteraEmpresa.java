package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AlteraEmpresa implements Acao {
  @Override
  public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    Empresa empresa = new Empresa();
    try {
      empresa.setId(Integer.parseInt(request.getParameter("id")));
      empresa.setNome(request.getParameter("nome"));

      String data = request.getParameter("data");
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      empresa.setDataAbertura(format.parse(data));
    } catch (ParseException e) {
      throw new ServletException(e);
    }

    Banco.updateEmpresa(empresa);
    return "redirect:entrada?acao=ListaEmpresas";
  }
}
