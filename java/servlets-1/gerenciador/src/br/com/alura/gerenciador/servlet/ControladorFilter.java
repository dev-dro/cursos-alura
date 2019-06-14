package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.Acao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String className = "br.com.alura.gerenciador.acao." + request.getParameter("acao");

    try {
      Acao acao = (Acao) Class.forName(className).newInstance();
      String[] caminho = acao.executa(request, response).split(":");

      if (caminho[0].equals("redirect")) {
        response.sendRedirect(caminho[1]);
      } else if (caminho[0].equals("forward")) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/" + caminho[1]);
        dispatcher.forward(request, response);
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  public void destroy() {
  }
}
