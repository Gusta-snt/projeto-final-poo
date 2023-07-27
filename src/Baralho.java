import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Baralho extends LinkedList<Carta>{
    private String tema;

    public Baralho(String tema) {
        this.tema = tema;
    }

    public void carregar() {
        String arquivo = "./data/" + this.tema.replaceAll("\\s+", "").toLowerCase() + ".csv";
        BufferedReader reader = null;
        String linha = "";

        String[] nomeAtributos = null;
        String[] nomeCartas = null;
        String[] codigo = null;
        int[][] valorAtributosTabela = null;
        try {
            reader = new BufferedReader(new FileReader(arquivo));
            String[][] tabela = new String[33][6];
            int i = 0;
            while((linha = reader.readLine()) != null) {
                String[] palavrasLinha = linha.split(",");
                int j = 0;
                for(String palavra : palavrasLinha) {
                    tabela[i][j] = palavra;
                    j++;
                }
                i++;
            }

            // Construindo alguns arrays com a tabela criada: 
            nomeAtributos = new String[4];
            for(i = 0; i < 4; i++) {
                nomeAtributos[i] = tabela[0][i+1];
            }
            nomeCartas = new String[32];
            codigo = new String[32];
            valorAtributosTabela = new int[32][4];
            for(i = 0; i < 32; i++) {
                nomeCartas[i] = tabela[i+1][0];
                codigo[i] = tabela[i+1][5];
                for(int j = 0; j < 4; j++) {
                    valorAtributosTabela[i][j] = Integer.parseInt(tabela[i+1][j+1]);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch(IOException e) {
                System.out.println("Não consigo fechar o leitor!");
            }

        }

        for(int i = 0; i < 32; i++) {
            int[] valorAtributos = new int[4];
            for(int j = 0; j < 4; j++) {
                valorAtributos[j] = valorAtributosTabela[i][j];
            }
            Carta carta = new Carta(nomeAtributos, valorAtributos, nomeCartas[i], codigo[i]);
            this.add(carta);
            carta.mostraCarta();
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

            //toggleJogador.monte.add(iterator.next());
            iterator.remove();
            
            if(toggleJogador == jogador1) {
                toggleJogador = jogador2;
            }else{
                toggleJogador = jogador1;
            }
        }
    }
}
