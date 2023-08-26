import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Baralho extends LinkedList<Carta>{
    private String tema;

    public Baralho(String tema) {
        this.tema = tema;
    }

    public void carregar() {
        String arquivo = "./data/" + this.tema + ".csv";
        BufferedReader reader = null;
        String linha = "";

        try {
            reader = new BufferedReader(new FileReader(arquivo));

            int i = 0;

            String[][] nomeAtributos = new String[4][2];

            while((linha = reader.readLine()) != null) {
                if(linha != "") {
                    String[] palavrasLinha = linha.split(";");
                    int j = 0;

                    String nomeCarta = null;
                    String codigo = null;
                    String descricao = null;
                    boolean isSuperTrunfo = false;
                    String[] valorAtributos = new String[4];

                    for(String palavra : palavrasLinha) {
                        if(i == 0 && j <= 4 && j >= 1) {
                            nomeAtributos[j - 1] = palavra.split("-");
                        }else{
                            switch(j) {
                                case 0:
                                    nomeCarta = palavra;
                                break;
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                    valorAtributos[j - 1] = palavra;
                                break;
                                case 5:
                                    codigo = palavra;
                                break;
                                case 6:
                                    isSuperTrunfo = Boolean.parseBoolean(palavra);
                                break;
                                case 7:
                                    descricao = palavra;
                                break;
                            }
                        }
                        j++;
                    }
                    if(i != 0) {
                        Carta carta = new Carta(nomeAtributos, valorAtributos, nomeCarta, codigo, isSuperTrunfo, descricao);
                        this.add(carta);
                    }
                    
                    i++;
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
    }

    public void embaralhar() {
        if(!this.isEmpty()){
            Collections.shuffle(this);
            Collections.shuffle(this);
        }else{
            System.out.println("Este baralho está vazio!");
        }
    }

    public void distribuir(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        this.getQtdCartas();
        Iterator<Carta> iterator = this.iterator();

        JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;

        JogadorAbstrato toggleJogador = jogadores[ThreadLocalRandom.current().nextInt(0, 1 + 1)];

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

    public void mostraCartas() {
        Iterator<Carta> iterator = this.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public int getQtdCartas() {
        return this.size();
    }

    public Carta getCartaTopo() {
        return this.removeFirst();
    }

    public void adicionarCarta(Carta carta) {
        this.addFirst(carta);
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
