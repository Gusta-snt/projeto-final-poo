import java.util.LinkedList;
/**
 * Classe abstrata que representa um jogador no jogo.
 */
abstract class JogadorAbstrato {
    private LinkedList<Carta> monte;
    private String nome;

    /**
     * Construtor da classe JogadorAbstrato.
     * Inicializa a lista que representa o monte de cartas do jogador.
     */
    public JogadorAbstrato() {
        monte = new LinkedList<>();
    }

    /**
     * Adiciona uma carta ao monte do jogador.
     * 
     * @param carta A carta a ser adicionada ao monte.
     */
    public void adicionarCarta(Carta carta) {
        monte.add(carta);
    }

    /**
     * Obtém a quantidade de cartas no monte do jogador.
     * 
     * @return A quantidade de cartas no monte.
     */
    public int getQuantidadeCartas() {
        return monte.size();
    }

    /**
     * Verifica se o monte do jogador está vazio.
     * 
     * @return true se o monte estiver vazio, false caso contrário.
     */
    public boolean monteVazio() {
        return monte.isEmpty();
    }

    /**
     * Obtém a carta superior do monte do jogador.
     * 
     * @return A carta superior do monte ou null se o monte estiver vazio.
     */
    public Carta getCartaSuperior() {
        if (!monte.isEmpty()) {
            return monte.get(monte.size() - 1);
        }
        return null;
    }

    /**
     * Método abstrato para escolher um atributo da carta.
     * 
     * @param atributos Uma lista de atributos disponíveis na carta.
     * @return O atributo escolhido pelo jogador.
     */
    public abstract Atributo escolherAtributo(LinkedList<Atributo> atributos);

    /**
     * Obtém o monte de cartas do jogador.
     * 
     * @return O monte de cartas do jogador.
     */
    public LinkedList<Carta> getMonte() {
        return monte;
    }

    /**
     * Define o monte de cartas do jogador.
     * 
     * @param monte O monte de cartas a ser definido.
     */
    public void setMonte(LinkedList<Carta> monte) {
        this.monte = monte;
    }

    /**
     * Obtém o nome do jogador.
     * 
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do jogador.
     * 
     * @param nome O nome a ser definido para o jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
