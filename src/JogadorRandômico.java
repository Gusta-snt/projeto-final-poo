
public class JogadorRandômico extends JogadorAbstrato{

    public JogadorRandômico(String nick, Baralho baralho) {
        super(nick);
        super(baralho);
    }

    @Override
    public String toString() {
        return "JogadorRandômico []";
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
    
}