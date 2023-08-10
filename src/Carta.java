public class Carta {
    private Atributo[] atributos = new Atributo[4];
    private Boolean isSuperTrunfo;
    private String descricao;
    private String nome;
    private String codigo;

    public Carta(String[] nomeAtributos, String[] valorAtributos, String nome, String codigo, Boolean isSuperTrunfo, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.isSuperTrunfo = isSuperTrunfo;
        this.descricao = descricao;
        for(int i = 0; i < atributos.length; i++) {
            atributos[i] = new Atributo(nomeAtributos[i], valorAtributos[i]);
        }
    }

    public String toString() {
        return this.nome + " " + this.atributos[0].getNome() + ":" + this.atributos[0].getValor() + " " + this.atributos[1].getNome() + ":" + this.atributos[1].getValor() + " " + this.atributos[2].getNome() + ":" + this.atributos[2].getValor() + " " + this.atributos[3].getNome() + ":" + this.atributos[3].getValor() +  " # " + this.codigo + " = " + this.isSuperTrunfo + " - " + this.descricao;
    }
  
    public String getNome() {
        return nome;
    }
  
    public String setNome(String nome) {
        return this.nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Atributo[] getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributo[] atributos) {
        this.atributos = atributos;
    }
  }