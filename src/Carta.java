public class Carta{

    private Atributo<Number>[] atributos;
    private String nome;
    private String codigo;
    private boolean isSuperTrunfo;
    private String descricao;
  
    public Carta(
        String[][] nomeUnidadeAtributos, 
        String[] valorAtributos, 
        String nome, 
        String codigo, 
        boolean isSuperTrunfo, 
        String descricao
    ) {
      this.nome = nome;
      this.codigo = codigo;
      this.isSuperTrunfo = isSuperTrunfo;
      this.descricao = descricao;
      atributos = new Atributo[4];
  
      for(int i = 0; i < 4; i++) {
        try{
          atributos[i] = new Atributo<Number>(nomeUnidadeAtributos[i][0], valorAtributos[i], nomeUnidadeAtributos[i][1]);
        }catch(IllegalStateException err) {
          System.err.println(err.getMessage());
        }
      }
    }
  
    public String getNome() {
      return nome;
    }
  
    public void setNome(String nome) {
      this.nome = nome;
    }
  
    public Atributo<Number>[] getAtributos() {
      return atributos;
    }
  
    public void setAtributos(Atributo<Number>[] atributos) {
      this.atributos = atributos;
    }
  
    public String getCodigo() {
      return codigo;
    }
  
    public void setCodigo(String codigo) {
      this.codigo = codigo;
    }
  
    public boolean getIsSuperTrunfo() {
      return isSuperTrunfo;
    }
  
    public void setIsSuperTrunfo(boolean isSuperTrunfo) {
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
      return "Carta: " + nome + "\nAtributos:\n (1 " + atributos[0].toString() + ",\n (2 " + atributos[1].toString() + ",\n (3 " + atributos[2].toString() + ",\n (4 " + atributos[3].toString() + "\nCódigo: " + codigo
          + "\nÉ um super trunfo: " + isSuperTrunfo + "\nDescrição: " + descricao;
    }
  }
