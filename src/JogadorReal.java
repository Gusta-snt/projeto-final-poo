import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato{
    private Scanner scanner =  new Scanner(System.in);

    public JogadorReal(String nome, String tema) {
        super(nome, tema);
    }

    @Override
    public Atributo<Number> escolherAtributo(Carta carta) {
        System.out.println(carta);
        System.out.println("Escolha um atributo: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        return carta.getAtributos()[index];
    }

    
}
