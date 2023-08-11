public abstract class JogadorAbstrato {
    private Baralho monte;
    private String nome;


    public JogadorAbstrato(String nome, String tema) {
        this.nome = nome;
        this.monte = new Baralho(tema);
    }

    public abstract Atributo<Number> escolherAtributo(Carta carta);
    public boolean monteVazio() {
        return this.getMonte().isEmpty();
    }

    public Baralho getMonte() {
        return monte;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
