import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Baralho extends LinkedList<Carta> {
    private String tema;

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void adicionarCarta(Carta carta) {
        this.add(carta);
    }

    public Baralho(String tema) {
        this.tema = tema;
    }

    public void carregar() {
        String arquivo = "./data/" + this.tema.replaceAll("\\s+", "").toLowerCase() + ".csv";
        BufferedReader reader = null;
        String linha = "";

        String[][] nomeAtributos = null;
        String[] nomeCartas = null;
        String[] codigo = null;
        String[] descricao = null;
        Boolean[] isSuperTrunfo = null;
        String[][] valorAtributosTabela = null;
        try {
            reader = new BufferedReader(new FileReader(arquivo));
            String[][] tabela = new String[34][9];
            int i = 0;
            while((linha = reader.readLine()) != null) {
                String[] palavrasLinha = linha.split(";");
                int j = 0;
                //System.out.printf("%d ", i);
                for(String palavra : palavrasLinha) {
                    tabela[i][j] = palavra;
                    //System.out.printf("%s ; ",palavra);
                    j++;
                }
                //System.out.println();
                i++;
            }

            // Construindo alguns arrays com a tabela criada: 
            nomeAtributos = new String[4][2];
            for(i = 0; i < 4; i++) {
                nomeAtributos[i] = tabela[0][i+1].split("-");
                //System.out.println(nomeAtributos[i]);
            }
            nomeCartas = new String[32];
            codigo = new String[32];
            isSuperTrunfo = new Boolean[32];
            descricao = new String[32];
            valorAtributosTabela = new String[32][4];
            for(i = 0; i < 32; i++) {
                nomeCartas[i] = tabela[i+1][0];
                codigo[i] = tabela[i+1][5];
                isSuperTrunfo[i] = Boolean.parseBoolean(tabela[i+1][6]);
                descricao[i] = tabela[i+1][7];
                for(int j = 0; j < 4; j++) {
                    valorAtributosTabela[i][j] = tabela[i+1][j+1];
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
            String[] valorAtributos = new String[4];
            for(int j = 0; j < 4; j++) {
                valorAtributos[j] = valorAtributosTabela[i][j];
            }
            Carta carta = new Carta(nomeAtributos, valorAtributos, nomeCartas[i], codigo[i], isSuperTrunfo[i], descricao[i]);
            this.add(carta);
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
        Iterator<Carta> iterator = this.iterator();

        JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;

        JogadorAbstrato toggleJogador = jogadores[ThreadLocalRandom.current().nextInt(0, 1 + 1)];

        while(iterator.hasNext()) {

            //toggleJogador.getMonte().add(iterator.next());
            iterator.remove();
            
            if(toggleJogador == jogador1) {
                toggleJogador = jogador2;
            }else{
                toggleJogador = jogador1;
            }
        }
    }

    public Carta pegarDoTopo() {
        return null;
    }
}
 