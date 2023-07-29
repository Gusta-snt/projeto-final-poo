import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Bem-vindo ao Super Trunfo! =====");
        System.out.println("Escolha um tema para o jogo:");
        System.out.println("1. Ben 10");
        System.out.println("2. Buko no hero");
        System.out.println("3. One Piece");
        System.out.print("Digite o número correspondente ao tema: ");

        int temaEscolhido = scanner.nextInt();

        String tema;

        switch (temaEscolhido) {
            case 1:
                tema = "Ben10";
                break;
            case 2:
                tema = "Bnha";
                break;
            case 3:
                tema = "One Piece";
                break;
            default:
                System.out.println("Tema inválido! Saindo do jogo...");
                return;
        }

        Jogo jogo = new Jogo(tema);
        jogo.jogar();

        scanner.close();
    }
}
