public class Atributo<T> {
    private String nome;
    private T valor;
    private String unidade;

    public Atributo(String nome, T valor, String unidade) {
        this.nome = nome;
        this.valor = valor;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public T getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    @Override
    public String toString() {
        return nome + ": " + valor + " " + unidade;
    }
}
