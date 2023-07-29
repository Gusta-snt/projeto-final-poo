public class Atributo {
    private String nome;
    private double valor;
    private String unidadeMedida;

    public Atributo(String nome, double valor, String unidadeMedida) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do atributo não pode ser nulo ou vazio.");
        }

        if (valor < 0) {
            throw new IllegalArgumentException("O valor do atributo não pode ser negativo.");
        }

        this.nome = nome;
        this.valor = valor;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    @Override
    public String toString() {
        if (unidadeMedida == null || unidadeMedida.isEmpty()) {
            return nome + ": " + valor;
        } else {
            return nome + ": " + valor + " " + unidadeMedida;
        }
    }
}
