
public abstract class JogadorAbstrato {
    protected String nick;
    protected Baralho monte;

    public JogadorAbstrato(String nick, Baralho monte) {
        this.nick = nick;
        this.monte = monte;
    }

    public abstract void adicionarCarta(Carta carta);
    public abstract int getQuantidadeCartas();
    public abstract boolean monteVazio();
    public abstract Atributo<?>  escolherAtributo(Atributo<?>[] atributos);
    public abstract Carta getCartaSuperior();

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Baralho getMonte() {
        return monte;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

}
