import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato{
    private Scanner scanner =  new Scanner(System.in);

    public JogadorReal(String nome, String tema) {
        super(nome, tema);
    }

    @Override
    public Atributo<Number> escolherAtributo(Carta carta) {
        int index;
        System.out.println(carta);
        System.out.println("Escolha um atributo (de 1 até 4): ");
        index = scanner.nextInt();
        scanner.nextLine();
        while(index < 1 || index > 4) {
            System.out.println("Por favor, insira um número de 1 até 4: ");
            index = scanner.nextInt();
            scanner.nextLine();
        }
        return carta.getAtributos()[index - 1];
    }

    
}
