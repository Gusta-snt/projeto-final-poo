import java.util.List;
import java.util.Random;

public class JogadorRandômico extends JogadorAbstrato {

    public JogadorRandômico(Baralho monte) {
        super();
    }

    @Override
    public Atributo escolherAtributo(List<Atributo> atributos) {
        Random random = new Random();
        int indexEscolhido = random.nextInt(atributos.size());
        return atributos.get(indexEscolhido);
    }
}
