import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Fase de teste e correção de erros:");
        System.out.println("Opção selecionada para teste será ben 10:");

        String tema = "Ben10";

        Jogo iniciJogo = new Jogo(tema);
        iniciJogo.jogar();

        reader.close();

    }
}
