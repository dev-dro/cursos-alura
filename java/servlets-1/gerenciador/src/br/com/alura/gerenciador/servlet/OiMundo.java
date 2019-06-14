package br.com.alura.gerenciador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/oi")
public class OiMundo extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    PrintWriter writer = resp.getWriter();

    writer.println("<html>");
    writer.println("<body>");
    writer.println("Hello World!");
    writer.println("</body>");
    writer.println("</html>");

    System.out.println("Servlet OiMundo acessado.");
  }
}
