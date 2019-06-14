package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListaEmpresas implements Acao{
  @Override
  public String executa(HttpServletRequest request, HttpServletResponse response) {
    List<Empresa> empresas = Banco.getEmpresas();
    request.setAttribute("empresas", empresas);
    return "forward:listaEmpresas.jsp";
  }
}
