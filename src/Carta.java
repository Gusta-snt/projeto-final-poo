import java.util.LinkedList;

public class Carta {
    //Atributos
    private String nome;
    private String codigo;
    private LinkedList<String> curiosidade;
    private LinkedList<Atributo> atributos;
    private boolean superTrunfo;

    //Contrutor de Carta
    public Carta(String nome, String codigo, LinkedList<String> curiosidade, 
        LinkedList<Atributo> atributos, boolean superTrunfo) {

        this.nome = nome;
        this.codigo = codigo;
        this.curiosidade = curiosidade;
        this.atributos = atributos;
        this.superTrunfo = superTrunfo;
    }
    
    //Metodos:




    //getter e setter da classe
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LinkedList<String> getCuriosidade() {
        return curiosidade;
    }

    public void setCuriosidade(LinkedList<String> curiosidade) {
        this.curiosidade = curiosidade;
    }

    public LinkedList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(LinkedList<Atributo> atributos) {
        this.atributos = atributos;
    }

    public boolean isSuperTrunfo() {
        return superTrunfo;
    }

    public void setSuperTrunfo(boolean superTrunfo) {
        this.superTrunfo = superTrunfo;
    }
}
