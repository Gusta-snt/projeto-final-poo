
public class Carta {

    private Atributo<? extends Number>[] atributos;
    private String nome;
    private String codigo;
    private boolean isSuperTrunfo;
    private String descricao;
    
    public Carta(String[][] nomeUnidadeAtributos, String[] valorAtributos, String nome, String codigo, boolean isSuperTrunfo, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.isSuperTrunfo = isSuperTrunfo;
        this.descricao = descricao;
        atributos = new Atributo[4];
    
        for (int i = 0; i < 4; i++) {
            // Converter valorAtributos para tipos numéricos (por exemplo, Integer)
            Number valorNumerico = Double.parseDouble(valorAtributos[i]);
            atributos[i] = new Atributo<>(nomeUnidadeAtributos[i][0], valorNumerico, nomeUnidadeAtributos[i][1]);
        }
    }
    

    public Carta(String[][] nomeAtributos, String[] valorAtributos, String string, String string2, Boolean boolean1,
            String string3) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atributo<? extends Number>[] getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributo<? extends Number>[] atributos) {
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
        return "Carta [atributos=[" + atributos[0].toString() + ", " + atributos[1].toString() + ", " + atributos[2].toString() + ", " + atributos[3].toString() + "], nome=" + nome + ", codigo=" + codigo
                + ", isSuperTrunfo=" + isSuperTrunfo + ", descricao=" + descricao + "]";
    }

    public int compararAtributo(Carta cartaJogadorPassivo, Atributo atributoEscolhido) {
        return 0;
    }
}
