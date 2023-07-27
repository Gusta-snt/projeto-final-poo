import java.util.LinkedList;
import java.util.List;



abstract class JogadorAbstrato {
    private LinkedList<Carta> monte;
    private String nome;

    //Aqui o constructor so inicia uma lista que vai ser o monte de cartas
    public JogadorAbstrato() {
        monte = new LinkedList<>(null);
    }


    public void adicionarCarta(Carta carta) {
        monte.add(carta);
    }

    // esse metodo é apenas para saber quantas cartas cada jogador terá 
    public int getQuantidadeCartas(){
        return monte.size();
    }

    public boolean monteVazio(){
        return monte.isEmpty();
    }

    //Tira a carta de cima se não tiver vazio o monte
    public Carta getCartaSuperior() {
        if (!monte.isEmpty()) {
            return monte.get(monte.size() - 1);
        }
        return null;
    }

    public abstract Atributo escolherAtributo(List<Atributo> atributos);

    public LinkedList<Carta> getMonte() {
        return monte;
    }

    public void setMonte(LinkedList<Carta> monte) {
        this.monte = monte;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    } 

    
}

