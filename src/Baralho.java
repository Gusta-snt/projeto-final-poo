import java.util.LinkedList;
import java.util.Arrays;

public class Baralho extends LinkedList<Carta>{
    String tema;

    public Baralho(String tema) {
        this.tema = tema;
    }

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
}
