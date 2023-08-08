import java.util.Scanner;
public class Jogo {
    protected static Baralho baralho;
    public static Object tema;
    static String txt;

    public static Baralho getBaralho() {
        return baralho;
    }

    public static void setBaralho(Baralho baralho) {
        Jogo.baralho = baralho;
    }

   // public static void main(String[] args) {
    public Jogo(){
        String tema=("");
        String nick=("");
        int op=0;
        String selecao=("");
        System.out.print("Deseja jogar? ");
        System.out.printf("Deseja jogar?\nSim(s)\tNão,sou beta!()n ");
        try (Scanner leitor = new Scanner( System.in )) {
            selecao=leitor.nextLine();
        }
        if(selecao.equals("n")){
            System.exit(0);
        }if(selecao.equals("s")){
            System.out.println("É hora do duelo!!");
        }

        //------------------------------------------------------------//
        System.out.println("Você vai jogar contra outra pessoa(p) ou contra a máquina(m)?");
        try (Scanner leitor = new Scanner( System.in )) {
            selecao=leitor.nextLine();
        }
        if(selecao.equals("p")){
            System.out.println("Jogador 1, escolha o seu nickname:");
            nick = leitor.nextLine();
            JogadorReal Jogador1 = new JogadorReal(nick, null);

            System.out.println("Jogador 2, escolha o seu nickname:");
            nick = leitor.nextLine();
            JogadorReal Jogador2 = new JogadorReal(nick, null);
        }if(selecao.equals("m")){
            System.out.println("Escolha o seu nickname:");
            nick = leitor.nextLine();
            JogadorReal Jogador1 = new JogadorReal(nick, null);
            JogadorRandômico Jogador2 = new JogadorRandômico("skynet", null, selecao);
        }

//----------------------------------------------------------------------------------//
        switch (op){
            case 1:
            tema=("divindades");
            break;
            case 2:
            tema=("heróis");
            break;
            case 3:
            tema=("insetos");
            break;
            case 4:
            tema=("mutantes");
            break;
            
        }

        baralho = new Baralho(tema, txt);

        
    }
    
        public void jogar() {
        while (!JogadorReal.baralho.isEmpty() && !JogadorRandômico.baralho.isEmpty()) {
            System.out.println("ROUND");
            Carta cartaJogador = JogadorReal.jogarTurno();
            Carta cartaRandomico = JogadorRandômico.jogarTurno();
            
            System.out.println("\nSelecione um atributo: ");
            
            System.out.println("\nStatus:");
            System.out.println("Jogador: " + JogadorReal.baralho.size() + " cartas");
            System.out.println("Computador: " + JogadorAbstrato.baralho.size() + " cartas");
            System.out.println("----------------------------\n");
        }
        System.out.println(" O vencedor é o Jogador: " );
    }

    public static Object getTema() {
        return tema;
    }

    public static void setTema(Object tema) {
        Jogo.tema = tema;
    }

    public static String getTxt() {
        return txt;
    }

    public static void setTxt(String txt) {
        Jogo.txt = txt;
    }
}
