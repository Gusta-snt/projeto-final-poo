import java.util.Scanner;

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

    public String wichAtrib(Carta carta) {
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
