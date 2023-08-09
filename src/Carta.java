public class Carta {
    // Atributos
    private String nome;             // Nome da carta
    private String codigo;           // Código identificador da carta
    private String curiosidade;      // Curiosidade sobre a carta
    private Atributo[] atributos;    // Array de atributos da carta
    private boolean superTrunfo;     // Indica se a carta é um Super Trunfo

    // Construtor de Carta
    public Carta(String nome, String codigo, String curiosidade, Atributo[] atributos, boolean superTrunfo) {
        this.nome = nome;
        this.codigo = codigo;
        this.curiosidade = curiosidade;
        this.atributos = atributos;
        this.superTrunfo = superTrunfo;
    }

    // Método para comparar um atributo entre duas cartas
    public int compararAtributo(Carta outraCarta, Atributo atributo) {
        double valorAtributoCartaAtual = 0;
        double valorAtributoOutraCarta = 0;

        // Encontra o valor do atributo da carta atual
        for (Atributo a : atributos) {
            if (a.getNome().equals(atributo.getNome())) {
                valorAtributoCartaAtual = a.getValor();
                break;
            }
        }

        // Encontra o valor do atributo da outra carta
        for (Atributo a : outraCarta.getAtributos()) {
            if (a.getNome().equals(atributo.getNome())) {
                valorAtributoOutraCarta = a.getValor();
                break;
            }
        }

        // Compara os valores dos atributos e retorna o resultado da comparação
        if (valorAtributoCartaAtual > valorAtributoOutraCarta) {
            return 1;    // A carta atual vence
        } else if (valorAtributoCartaAtual < valorAtributoOutraCarta) {
            return -1;   // A outra carta vence
        } else {
            return 0;    // Empate
        }
    }

    // Método toString para exibir informações da carta
    @Override
    public String toString() {
        StringBuilder attributesString = new StringBuilder();
        for (Atributo atributo : atributos) {
            attributesString.append(atributo.getNome()).append(": ").append(atributo.getValor()).append(", ");
        }
        attributesString.setLength(attributesString.length() - 2); // Remove a última vírgula e espaço

        return "Carta: " + nome + '\'' +"\natributo: " + attributesString.toString();
    }

    // Getters e setters da classe
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
