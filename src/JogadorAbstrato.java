public abstract class JogadorAbstrato {
    protected String nick;
    protected Baralho baralho;
    public JogadorAbstrato(String nick, Baralho baralho) {
        this.nick = nick;
        this.baralho = baralho;
    }

    public void ToSpread(Carta carta) {
        baralho.add(carta);
    }

    public void clr() {
        baralho.clear();
    }

  
    public abstract String howAtrib(Carta carta);

  
    public String jogada() {
        StringBuilder tento = new StringBuilder();
        for (Carta carta : baralho) {
            tento.append(carta.toString()).append("\n");
        }
        return tento.toString();
    }

    public String getNick() {
        return nick;
    }
   public void setNick(String nick) {
        this.nick = nick;
   }
   
   
   public Baralho getBaralho() {
        return baralho;
   }

   public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
   }

@Override
public String toString() {
    return "JogadorAbstrato [nick=" + nick + ", baralho=" + baralho + "]";
}
}
