package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

  @AroundInvoke
  public Object intercepta(InvocationContext context) throws Exception {
    long milis = System.currentTimeMillis();

    Object proceed = context.proceed();

    String classe = context.getTarget().getClass().getSimpleName();
    String metodo = context.getMethod().getName();
    System.out.println("[INFO] - Tempo gasto para acessar " + classe + " : " + metodo + " -> " + (System.currentTimeMillis() - milis) + " ms");

    return proceed;
  }
}
