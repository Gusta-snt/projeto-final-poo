public class Atributo {
    //Atributos
    private String nome;
    private double valor;
    private String unidade;

    //Construtor
    public Atributo(String nome, double valor, String unidade) {
        this.nome = nome;
        this.valor = valor;
        this.unidade = unidade;
    }


    //Metodos:


    
    //getter e setters 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }    
    
}
