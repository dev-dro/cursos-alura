package br.com.caelum.livraria;

import java.util.List;

public class TesteRequestSoapComJava {
  public static void main(String[] argv) {
    LivrariaWS service = new LivrariaWSService().getLivrariaWSPort();
    //invoke business method
    List<Livro> livros = service.getLivrosPorTitulo("JSF");
    livros.forEach(livro -> System.out.println(livro.getTitulo() + " : " + livro.getAutor().getNome()));
  }
}
