   // package supertrunfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Baralho extends LinkedList<Carta>{
    String txt;
   

    public Baralho(String tema, String txt) {
        if (tema.equals("divindades")){
            txt=("tema/1.txt");
        }if (tema.equals("heróis")){
            txt=("tema/2.txt");
        }if (tema.equals("insetos")){
            txt=("tema/3.txt");
        }if (tema.equals("mutantes")){
            txt=("tema/4.txt");
        }
        carregar();
    }

    public void carregar(){

        LinkedList<Carta> listaCartas = new LinkedList<Carta>();

        try {
         //   if(txt==1){
                BufferedReader br = new BufferedReader(new FileReader(txt));
        //    }
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] elementos = linha.split(" ");
                Carta carta = new Carta(Carta.name, Carta.code, Carta.infoA, Carta.infoB, Carta.infoC, elementos);
                listaCartas.add(carta);
            }

            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        for (Carta carta : listaCartas) {
            String[] elementos = carta.getElementos();
            System.out.print("Carta(");
            for (int i = 0; i < elementos.length; i++) {
                System.out.print("\"" + elementos[i] + "\"");
                if (i < elementos.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }    

    }
    
    public void embaralhar() {
    
    }
    
    public List<Carta> distribuir(int quantidade) {
    
    }

}
