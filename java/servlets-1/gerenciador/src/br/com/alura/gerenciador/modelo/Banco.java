package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

  private static List<Empresa> empresas = new ArrayList<>();
  private static List<Usuario> usuarios = new ArrayList<>();
  private static Integer id = 1;

  static {
    Empresa empresa1 = new Empresa();
    empresa1.setNome("Alura");
    Banco.addEmpresa(empresa1);

    Empresa empresa2 = new Empresa();
    empresa2.setNome("Caelum");
    Banco.addEmpresa(empresa2);

    Usuario usuario1 = new Usuario();
    usuario1.setLogin("usuario");
    usuario1.setSenha("123456");
    usuarios.add(usuario1);

    Usuario usuario2 = new Usuario();
    usuario2.setLogin("admin");
    usuario2.setSenha("123456");
    usuarios.add(usuario2);
  }

  private Banco() {}

  public static List<Empresa> getEmpresas() {
    return empresas;
  }

  public static void addEmpresa(Empresa empresa) {
    if (empresa != null) {
      empresa.setId(Banco.id++);
      empresas.add(empresa);
    }
  }

  public static Empresa getEmpresa(Integer id) {
    for (Empresa empresa : empresas) {
      if (empresa.getId().equals(id)) return empresa;
    }
    return null;
  }

  public static void updateEmpresa(Empresa empresa) {
    int index = empresas.indexOf(empresa);
    empresas.get(index).setNome(empresa.getNome());
    empresas.get(index).setDataAbertura(empresa.getDataAbertura());
  }

  public static void deleteEmpresa(Integer id) {
    Empresa empresa = new Empresa();
    empresa.setId(id);
    empresas.remove(empresa);
  }

  public static Usuario existeUsuario(String login, String senha) {
    for (Usuario usuario : usuarios) {
      if (usuario.ehIgual(login, senha)) return usuario;
    }
    return null;
  }
}
