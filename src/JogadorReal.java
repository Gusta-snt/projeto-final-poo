/*import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato{
	private Scanner ler;
    public JogadorReal(String nick, Baralho baralho) {
        super(nick, baralho);
        ler = new Scanner(System.in);
    }

    @Override
    public Baralho getBaralho() {
        // TODO Auto-generated method stub
        return super.getBaralho();
    }

    @Override
    public String getNick() {
        // TODO Auto-generated method stub
        return super.getNick();
    }

    @Override
    public void setBaralho(Baralho baralho) {
        // TODO Auto-generated method stub
        super.setBaralho(baralho);
    }

    @Override
    public void setNick(String nick) {
        // TODO Auto-generated method stub
        super.setNick(nick);
    }

    public String wichAtrib(  carta) {
        System.out.println("Sua carta: \n" + carta.toString());
        System.out.print("Escolha um atributo para jogar: \n Digite A para escolher o primeiro atributo\n B para escolher o segundo\n C para o terceiro \n D para escolher o quarto");
        
        String selected = ler.nextLine();
        return selected; 
    }


    public Scanner getLer() {
        return ler;
    }

    public void setLer(Scanner ler) {
        this.ler = ler;
    }

    @Override
    public String toString() {
        return "JogadorReal [ler=" + ler + "]";
    }

    public static Carta jogarTurno() {
        return null;
    }
    
}
*/
import java.util.Scanner;
public class JogadorReal extends JogadorAbstrato {


    public JogadorReal(String nick, Baralho monte) {
        super(nick, monte);
    }

    public JogadorReal(Baralho baralho) {
    }

    @Override
    public Atributo<?> escolherAtributo(Atributo<?>[] atributos) {
        try (Scanner scanner = new Scanner(System.in)) {
            int escolha=0;
            do{
                System.out.println("Escolha um atributo:");
                for (int i = 0; i < atributos.length; i++) {
                    System.out.println((i + 1) + ". " + atributos[i].getNome());
                }
                escolha = scanner.nextInt();
                return atributos[escolha - 1];   
            }while(escolha<1 || escolha>4);
        }
    }

    @Override
    public void adicionarCarta(Carta carta) {
        monte.adicionarCarta(carta);
    }

    @Override
    public int getQuantidadeCartas() {
        return monte.size();
    }

    @Override
    public Carta getCartaSuperior() {
        return monte.pegarDoTopo();
    }

    @Override
    public boolean monteVazio() {
        if(monte.size()==0){
            return true;
        }
        return false;
    }
}