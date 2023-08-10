/*<<<<<<< HEAD


public class Principal{
    public Principal() {


    }
    private Object iniciarJogo() {
        return null;
    }
    public static void main(String[] args) {
        

        Jogo jogo = new Jogo();
        jogo.jogar();

    }
    @Override
    public String toString() {
        return "Principal []";
=======*/
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== Super Trunfo ==============");
        System.out.println("Escolha um tema para o jogo: ");
        System.out.println("\tBen 10\n\tOne Piece\n\tBNHA\n\tDeuses");
        String tema = scanner.nextLine();
        Jogo jogo = new Jogo(tema);
        jogo.jogar();
        scanner.close();
//>>>>>>> da8c19f (testando primeiro protótipo integrado)
    }
}
 