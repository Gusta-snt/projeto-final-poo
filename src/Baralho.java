
import java.util.Collections;
import java.util.LinkedList;

public class Baralho {
    //Atributos
    private LinkedList<Carta> cartas;

    //Construtor vazio para quando a classe for intaceada ele inciar a lista
    public Baralho() {
        this.cartas = new LinkedList<Carta>();
    }

    //Metodos
    public void embaralhar(){
        Collections.shuffle(cartas); //usando a classe Collections e o metodo shuffle embaralhamos a lista de cartas
    }

    public void distribuir(){}

    public void adicionarCarta(Carta carta) {
        cartas.add(carta); //Usando uma função da propria LinkedList addicionamos as cartas a lista
    }

    public void carregar(String tema) {
        //Possivel começo do metodo carregar
        switch (tema) {
            case "Carros":
            //Com as condições criadas so temos que passar os parametros do construtor de Carta
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
            break;
            case "Dinossauros":
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                break;
            case "Futbol":
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                break;
            case "Paises":
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                this.add(new Carta());
                break;
    }


    }

    //getter e setter
    public LinkedList<Carta> getCartas() {
        return cartas;
    } 
}
