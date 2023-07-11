import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um tema:");
        System.out.println("1. Carros");
        System.out.println("2. Dinossauros");
        System.out.println("3. Países");
        System.out.println("4. Times de Futebol");

        int temaEscolhido = scanner.nextInt();

        String tema;

        switch (temaEscolhido) {
            case 1:
                tema = "Carros";
                break;
            case 2:
                tema = "Dinossauros";
                break;
            case 3:
                tema = "Países";
                break;
            case 4:
                tema = "Times de Futebol";
                break;
            default:
                tema = "Carros";
                break;
        }

        Baralho baralho = new Baralho();

    }
}
