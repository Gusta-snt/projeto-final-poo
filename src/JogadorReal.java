import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class JogadorReal extends JogadorAbstrato {

    public JogadorReal(Baralho monte) {
        super();
    }


@Override
    public Atributo escolherAtributo(LinkedList<Atributo> atributos) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Escolha um atributo:");
    for (int i = 0; i < atributos.size(); i++) {
        System.out.println((i + 1) + ". " + atributos.get(i).getNome());
        }

    int escolha = scanner.nextInt();

    // Verificar se a escolha é válida
    while (escolha < 1 || escolha > atributos.size()) {
        System.out.println("Opção inválida. Escolha novamente:");
        escolha = scanner.nextInt();
        }

    return atributos.get(escolha - 1);
    }

}
