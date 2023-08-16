
import java.util.concurrent.ThreadLocalRandom;

public class JogadorRandômico extends JogadorAbstrato {
    public JogadorRandômico(String nick, Baralho monte) {
        super(nick, monte);
    }

    
    public Atributo<?> escolherAtributo(Atributo<?>[] atributos) {
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0,4);
            return atributos[indiceAleatorio];
    }

 
    public void adicionarCarta(Carta carta) {
        monte.adicionarCarta(carta);
    }

    @Override
    public int getQuantidadeCartas() {
        return monte.size();
    }

    @Override
    public Carta getCartaSuperior() {
        return monte.peek();
    }

   
    @Override
    public boolean monteVazio() {
        return monte.isEmpty();
    }



}
