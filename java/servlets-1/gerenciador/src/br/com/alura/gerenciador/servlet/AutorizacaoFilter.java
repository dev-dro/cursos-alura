package br.com.alura.gerenciador.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutorizacaoFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String paramName = request.getParameter("acao");

    HttpSession sessao = request.getSession();
    boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
    boolean ehUmaAcaoProtegida = !(paramName.equals("Login") || paramName.equals("LoginForm"));
    if (usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
      response.sendRedirect("entrada?acao=LoginForm");
      return;
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
  }
}
