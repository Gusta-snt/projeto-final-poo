public class Atributo<N extends Number> {
    private String nome;
    private N valor;
    private String unidade;

    public Atributo(String nome, String valor, String unidade) {
        this.nome = nome;
        this.unidade = unidade;
        try {
            // Tente converter a string em um Integer
            this.valor = (N) Integer.valueOf(valor);
        } catch (NumberFormatException e) {
            try {
                // Se a conversão falhar, tente converter a string em um Double
                this.valor = (N) Double.valueOf(valor);
            } catch (NumberFormatException ex) {
                // Se ambos falharem, você pode lançar uma exceção ou definir um valor padrão, conforme necessário
                throw new IllegalArgumentException("Valor inválido: " + valor);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor.doubleValue();
    }

    public void setValor(N valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return nome + ": " + valor + " " + unidade + ")";
    }

    
}
