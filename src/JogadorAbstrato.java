/*public abstract class JogadorAbstrato {
    protected String nick;
    protected static Baralho baralho;
    public JogadorAbstrato(String nick) {
        this.nick = nick;
    }

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

  
    public abstract String wichAtrib(Carta carta);

  
<<<<<<< HEAD
  /*  public String jogada() {
        StringBuilder tento = new StringBuilder();
        for (Carta carta : baralho) {
            tento.append(carta.toString()).append("\n");
        }
        return tento.toString();
    }*/
//=======
  //  public String jogada() {
   //     StringBuilder tento = new StringBuilder();
     //   for (Carta carta : baralho) {
       //     tento.append(carta.toString()).append("\n");
        //}
        //return tento.toString();
    //}
//>>>>>>> da8c19f (testando primeiro protótipo integrado)
/* 
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
*/

public abstract class JogadorAbstrato {
    protected String nick;
    protected Baralho monte;

    public JogadorAbstrato(String nick, Baralho monte) {
        this.nick = nick;
        this.monte = monte;
    }

    public abstract Atributo<?> escolherAtributo(Atributo<?>[] atributos);
    public abstract void adicionarCarta(Carta carta);
    public abstract int getQuantidadeCartas();
    public abstract Carta getCartaSuperior();
    public abstract boolean monteVazio();

}