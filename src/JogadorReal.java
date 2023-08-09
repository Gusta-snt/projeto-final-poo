import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe que representa um jogador controlado por um jogador real (usuário).
 * Herda da classe abstrata JogadorAbstrato.
 */
class JogadorReal extends JogadorAbstrato {

    /**
     * Construtor da classe JogadorReal.
     * 
     * @param monte O monte de cartas do jogador (não é utilizado neste construtor).
     */
    public JogadorReal(Baralho monte) {
        super(); // Chama o construtor da classe pai (JogadorAbstrato)
    }

    /**
     * Implementação do método abstrato escolherAtributo.
     * Permite que o jogador real (usuário) escolha um atributo a partir da entrada do console.
     * 
     * @param atributos Uma lista de atributos disponíveis na carta.
     * @return O atributo escolhido pelo jogador real.
     */
    @Override
    public Atributo escolherAtributo(LinkedList<Atributo> atributos) {
        Scanner scanner = new Scanner(System.in); // Cria uma instância de Scanner para ler a entrada do usuário

        System.out.println("Escolha um atributo:");
        for (int i = 0; i < atributos.size(); i++) {
            System.out.println((i + 1) + ". " + atributos.get(i).getNome());
        }

        int escolha = scanner.nextInt(); // Lê a escolha do jogador

        // Verificar se a escolha é válida
        while (escolha < 1 || escolha > atributos.size()) {
            System.out.println("Opção inválida. Escolha novamente:");
            escolha = scanner.nextInt(); // Lê a escolha novamente
        }

        return atributos.get(escolha - 1); // Retorna o atributo escolhido pelo jogador
    }
    
}
