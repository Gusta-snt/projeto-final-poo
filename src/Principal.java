/*
 * Integrantes:
 *  - Gustavo Ferreira dos Santos
 *  - Elizeu Andrade de Jesus
 *  - Higor Ferreira Silva
 *  - Rhadyja Almeida Barbosa
 *  - Thiago Honorato Ferreira
 * */

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== Super Trunfo ==============");
        System.out.println("Qual é o seu nome? ");
        String nomeJogador = scanner.nextLine();
        System.out.println("Escolha um tema para o jogo: ");
        System.out.println("\tBen 10\n\tOne Piece\n\tBNHA\n\tDeuses");
        String tema = scanner.nextLine();
        tema = tema.replaceAll("\\s+", "").toLowerCase();

        while(!tema.equals("ben10") && !tema.equals("onepiece") && !tema.equals("bnha") && !tema.equals("deuses")) {
            System.out.println("Por favor, insira um tema válido dentre os listados: ");
            tema = scanner.nextLine();
            tema = tema.replaceAll("\\s+", "").toLowerCase();
        }

        Jogo jogo = new Jogo(tema, nomeJogador);
        jogo.jogar();
        scanner.close();
    }
}
