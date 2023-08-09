import java.util.LinkedList;
import java.util.Random;

/**
 * Classe que representa um jogador controlado por uma estratégia randômica.
 * Herda da classe abstrata JogadorAbstrato.
 */
public class JogadorRandômico extends JogadorAbstrato {

    /**
     * Construtor da classe JogadorRandômico.
     * 
     * @param monte O monte de cartas do jogador (não é utilizado neste construtor).
     */
    public JogadorRandômico(Baralho monte) {
        super(); // Chama o construtor da classe pai (JogadorAbstrato)
    }

    /**
     * Implementação do método abstrato escolherAtributo.
     * Escolhe um atributo aleatoriamente da lista de atributos disponíveis.
     * 
     * @param atributos Uma lista de atributos disponíveis na carta.
     * @return O atributo escolhido aleatoriamente.
     */
    @Override
    public Atributo escolherAtributo(LinkedList<Atributo> atributos) {
        Random random = new Random(); // Cria uma instância de Random para gerar números aleatórios
        int indexEscolhido = random.nextInt(atributos.size()); // Gera um índice aleatório baseado no tamanho da lista
        return atributos.get(indexEscolhido); // Retorna o atributo escolhido aleatoriamente
    }
}
