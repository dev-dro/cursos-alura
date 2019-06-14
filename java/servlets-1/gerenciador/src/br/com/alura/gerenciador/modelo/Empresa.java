package br.com.alura.gerenciador.modelo;

import java.util.Date;
import java.util.Objects;

public class Empresa {

  private Integer id;
  private String nome;
  private Date dataAbertura = new Date();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(Date dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Empresa empresa = (Empresa) o;
    return Objects.equals(id, empresa.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
