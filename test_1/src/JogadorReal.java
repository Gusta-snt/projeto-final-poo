import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato {
    public JogadorReal(String nick, Baralho monte) {
        super(nick, monte);
    }

    public Atributo<?> escolherAtributo(Atributo[] atributos) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarCarta'");
    }

    @Override
    public int getQuantidadeCartas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidadeCartas'");
    }

    @Override
    public boolean monteVazio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monteVazio'");
    }

    @Override
    public Carta getCartaSuperior() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCartaSuperior'");
    }
}
