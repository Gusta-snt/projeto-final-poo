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

    public int compararAtributo(Carta outraCarta, Atributo atributo) {
        double valorAtributoCartaAtual = 0;
        double valorAtributoOutraCarta = 0;

        for (Atributo a : atributos) {
            if (a.getNome().equals(atributo.getNome())) {
                valorAtributoCartaAtual = a.getValor();
                break;
            }
        }

        for (Atributo a : outraCarta.getAtributos()) {
            if (a.getNome().equals(atributo.getNome())) {
                valorAtributoOutraCarta = a.getValor();
                break;
            }
        }

        if (valorAtributoCartaAtual > valorAtributoOutraCarta) {
            return 1;
        } else if (valorAtributoCartaAtual < valorAtributoOutraCarta) {
            return -1;
        } else {
            return 0;
        }
    }



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
