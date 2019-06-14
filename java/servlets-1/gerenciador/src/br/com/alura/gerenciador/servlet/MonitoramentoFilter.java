package br.com.alura.gerenciador.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MonitoramentoFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException { }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    long inicio = System.currentTimeMillis();
    filterChain.doFilter(servletRequest, servletResponse);
    long fim = System.currentTimeMillis();
    System.out.println("Tempo de execussao: " + (fim - inicio) + " ms");
  }

  @Override
  public void destroy() { }
}
