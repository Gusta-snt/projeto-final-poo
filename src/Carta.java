public class Carta {

  private Atributo[] atributos = new Atributo[4];
  private String nome;
  private String codigo;
  private String isSuperTrunfo;
  private String descricao;

  public Carta(String[][] nomeUnidadeAtributos, int[] valorAtributos, String nome, String codigo, boolean isSuperTrunfo, String descricao) {
    this.nome = nome;

    for(int i = 0; i < 4; i++) {
      atributos[i] = new Atributo(nomeUnidadeAtributos[i][0], valorAtributos[i], nomeUnidadeAtributos[i][1]);
    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Atributo[] getAtributos() {
    return atributos;
  }

  public void setAtributos(Atributo[] atributos) {
    this.atributos = atributos;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getIsSuperTrunfo() {
    return isSuperTrunfo;
  }

  public void setIsSuperTrunfo(String isSuperTrunfo) {
    this.isSuperTrunfo = isSuperTrunfo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "Carta [atributos=" + atributos.toString() + ", nome=" + nome + ", codigo=" + codigo
        + ", isSuperTrunfo=" + isSuperTrunfo + ", descricao=" + descricao + "]";
  }
}
