/**
 * Classe que representa um atributo de uma carta, contendo nome, valor e unidade de medida (opcional).
 */
public class Atributo {
    private String nome;
    private double valor;
    private String unidadeMedida;

    /**
     * Construtor da classe Atributo.
     * 
     * @param nome O nome do atributo.
     * @param valor O valor do atributo.
     * @param unidadeMedida A unidade de medida do atributo (pode ser nula ou vazia).
     * @throws IllegalArgumentException Se o nome for nulo ou vazio, ou se o valor for negativo.
     */
    public Atributo(String nome, double valor, String unidadeMedida) throws IllegalArgumentException {
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

    /**
     * Obtém o nome do atributo.
     * 
     * @return O nome do atributo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o valor do atributo.
     * 
     * @return O valor do atributo.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Obtém a unidade de medida do atributo.
     * 
     * @return A unidade de medida do atributo (pode ser nula ou vazia).
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * Retorna uma representação em string do atributo.
     * Se houver uma unidade de medida, ela será incluída na representação.
     * 
     * @return A representação em string do atributo.
     */
    @Override
    public String toString() {
        if (unidadeMedida == null || unidadeMedida.isEmpty()) {
            return nome + ": " + valor;
        } else {
            return nome + ": " + valor + " " + unidadeMedida;
        }
    }
}
