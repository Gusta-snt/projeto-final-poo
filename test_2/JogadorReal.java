import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato {
    public JogadorReal(String nick, Baralho monte) {
        super(nick, monte);
    }

    public Atributo<?> escolherAtributo(Atributo<?>[] atributos) {
        try (Scanner scanner = new Scanner(System.in)) {
            int escolha;
            do {
                System.out.println("Escolha um atributo:");
                for (int i = 0; i < atributos.length; i++) {
                    System.out.println((i + 1) + ". " + atributos[i].getNome());
                }
                escolha = scanner.nextInt();
            } while (escolha < 1 || escolha > atributos.length);  // Correção aqui: ajustado o limite do loop

            return atributos[escolha - 1];
        }
    }

    @Override
    public void adicionarCarta(Carta carta) {
        monte.adicionarCarta(carta);
    }

    @Override
    public int getQuantidadeCartas() {
        return monte.size();
    }

    @Override
    public boolean monteVazio() {
        return monte.isEmpty();
    }

    @Override
    public Carta getCartaSuperior() {
        return monte.peek();
    }

}
