public class Carta {

  private Atributo[] atributos = new Atributo[4];

  private String nome;

  public Carta( String[] nomeAtributos, Atributo atributos, String[] nomeAtributos,int[] valorAtributos ) {
    this.nome = nome;
    atributos[0] = new Atributo(nomeAtributo[0], valorAtributos[0]);
    atributos[1] = new Atributos(nomeAtributos[1], valorAtributos[1]);
    atributos[2] = new Atributos(nomeAtributos[2], valorAtributos[2]);
    atributos[3] = new Atributos(nomeAtributos[3], valorAtributos[3]);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    return nome;
  }
}
