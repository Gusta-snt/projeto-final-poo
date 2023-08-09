public class Carta {
    // Atributos
    private String nome;
    private String codigo;
    private String curiosidade;
    private Atributo[] atributos; // Correção: Declarar como array de Atributo
    private boolean superTrunfo;

    // Construtor de Carta
    public Carta(String nome, String codigo, String curiosidade, Atributo[] atributos, boolean superTrunfo) {
        this.nome = nome;
        this.codigo = codigo;
        this.curiosidade = curiosidade;
        this.atributos = atributos;
        this.superTrunfo = superTrunfo;
    }
    
    // Métodos:
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

    // Na classe Carta
@Override
    public String toString() {
        StringBuilder attributesString = new StringBuilder();
        for (Atributo atributo : atributos) {
            attributesString.append(atributo.getNome()).append(": ").append(atributo.getValor()).append(", ");
        }
        attributesString.setLength(attributesString.length() - 2); // Remove a última vírgula e espaço

        return "Carta: " + nome + '\'' +"\natributo: " + attributesString.toString();
}


    // Getter e setter da classe
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

    public String getCuriosidade() {
        return curiosidade; 
    }

    public void setCuriosidade(String curiosidade) { 
        this.curiosidade = curiosidade;
    }

    public boolean isSuperTrunfo() {
        return superTrunfo;
    }

    public void setSuperTrunfo(boolean superTrunfo) {
        this.superTrunfo = superTrunfo;
    }

    public Atributo[] getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributo[] atributos) {
        this.atributos = atributos;
    }
}