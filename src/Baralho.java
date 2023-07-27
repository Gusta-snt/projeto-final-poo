import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Baralho extends LinkedList<Carta>{
    private String tema;

    public Baralho(String tema) {
        this.tema = tema;
    }


    // temos que analisar a logica dessa classe
    public void carregar() {
        String[] cartas = new String[32];
        if(this.tema == "Ben 10") {
            cartas = Arrays.asList(
                "Heatblast",
                "Four Arms",
                "XLR8",
                "Diamondhead",
                "Upgrade",
                "Ripjaws",
                "Stinkfly",
                "Ghostfreak",
                "Grey Matter",
                "Wildmutt",
                "Cannonbolt",
                "Wildvine",
                "Upchuck",
                "Ditto",
                "Eye Guy",
                "Way Big",
                "Articguana",
                "Buzzshock",
                "Frankenstrike",
                "Snare-oh",
                "Blitzwolfer",
                "Benwolf",
                "Big Chill",
                "Chromastone",
                "Lodestar",
                "Rath",
                "Water Hazard",
                "Terraspin",
                "NRG",
                "Fasttrack",
                "Eatle",
                "Feedback"
            ).toArray(new String[0]);
        }else{
            if(this.tema == "Dinossauros") {
                cartas = Arrays.asList(
                    "Tyrannosaurus rex",
                    "Velociraptor",
                    "Triceratops",
                    "Stegosaurus",
                    "Brachiosaurus",
                    "Ankylosaurus",
                    "Spinosaurus",
                    "Allosaurus",
                    "Dilophosaurus",
                    "Pterodactyl",
                    "Utahraptor",
                    "Apatosaurus",
                    "Parasaurolophus",
                    "Iguanodon",
                    "Carnotaurus",
                    "Archaeopteryx",
                    "Deinonychus",
                    "Gallimimus",
                    "Compsognathus",
                    "Pachycephalosaurus",
                    "Baryonyx",
                    "Diplodocus",
                    "Allosaurus",
                    "Brontosaurus",
                    "Coelophysis",
                    "Mosasaurus",
                    "Microraptor",
                    "Oviraptor",
                    "Protoceratops",
                    "Quetzalcoatlus",
                    "Spinosaurus",
                    "Troodon"
                ).toArray(new String[0]);
            }else{
                System.out.println("Tema inválido!");
            }
        }

        String[] letra = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for(int i = 0; i < cartas.length; i++) {
            int grupo = ((int) i / 8) + 1;
            this.add(new Carta(cartas[i], grupo + letra[grupo - 1]));
        }
    }

    public void embaralhar() {
        if(!this.isEmpty()){
            Collections.shuffle(this);
        }else{
            System.out.println("Este baralho está vazio! Use o método carregar() antes de poder embaralhar.");
        }
    }

    public void distribuir(JogadorReal jogador1, JogadorRandômico jogador2) {
        Iterator<Carta> iterator = this.iterator();
        Random random = new Random();

        JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;

        JogadorAbstrato toggleJogador = jogadores[random.nextInt((2 - 1) + 1) + 1];

        while(iterator.hasNext()) {

            toggleJogador.getMonte().add(iterator.next());
            iterator.remove();
            
            if(toggleJogador == jogador1) {
                toggleJogador = jogador2;
            }else{
                toggleJogador = jogador1;
            }
        }
    }
}