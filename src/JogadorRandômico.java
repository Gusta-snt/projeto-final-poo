import java.util.Random;

public class JogadorRandômico extends JogadorAbstrato{

    private Random random;
    private String selected=("");
    
    public JogadorRandômico(String nick, Baralho baralho, String selected) {
        super(nick, baralho);
       	random = new Random();
        this.selected=selected;
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

    @Override
    public String howAtrib(Carta carta) {
        // TODO Auto-generated method stub
        
        random.nextInt(4);
        if(random.equals(1)){
            selected=("A");
        }
        if(random.equals(2)){
            selected=("B");        
        }
        if(random.equals(3)){
            selected=("C");        
        }
        if(random.equals(4)){
            selected=("D");
        }
    return selected;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "JogadorRandômico [random=" + random + ", selected=" + selected + "]";
    }
    
}
