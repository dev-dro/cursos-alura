package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empresas")
public class EmpresasServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Empresa> empresas = Banco.getEmpresas();
    request.setAttribute("empresas", empresas);

    String accept = request.getHeader("Accept");
    if (accept.endsWith("json")) {
      Gson gson = new Gson();
      String json = gson.toJson(empresas);

      response.setContentType("applitacion/json");
      response.getWriter().print(json);
    } else if (accept.endsWith("xml")) {
      XStream xStream = new XStream();
      xStream.alias("empresa", Empresa.class);
      String xml = xStream.toXML(empresas);

      response.setContentType("application/xml");
      response.getWriter().print(xml);
    } else {
      response.setContentType("application/json");
      response.getWriter().print("{'message': 'no content'}");
    }
  }
}
