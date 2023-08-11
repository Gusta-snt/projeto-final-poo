import java.util.concurrent.ThreadLocalRandom;

public class JogadorRandômico extends JogadorAbstrato{

    public JogadorRandômico(String nome, String tema) {
        super(nome, tema);
    }

    @Override
    public Atributo<Number> escolherAtributo(Carta carta) {
        System.out.println(carta);
        int index = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        return carta.getAtributos()[index];
    }
}
