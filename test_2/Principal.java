import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    	String nick ="";
    	String tema = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== Super Trunfo ==============");
        System.out.println("Escolha um tema para o jogo: ");
        System.out.println("\tBen 10\n\tOne Piece\n\tBNHA\n\tDeuses");
        tema = scanner.nextLine();
        System.out.println("Digite seu nome: ");
        nick = scanner.nextLine();
        scanner.close();
        Jogo jogo = new Jogo(tema, nick);


        jogo.jogar();
    }
}