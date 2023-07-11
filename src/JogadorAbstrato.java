abstract class JogadorAbstrato {
    private Baralho monte;

    public JogadorAbstrato(Baralho monte) {
        this.monte = monte;
    }

    public abstract void jogarTurno();

    public void adicionarCarta(Carta carta) {
        monte.adicionarCarta(carta);
    }
}

