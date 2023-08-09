import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Baralho extends LinkedList<Carta> {
    private String tema;

    /**
     * Construtor da classe Baralho.
     * 
     * @param tema O tema do baralho, usado para carregar as cartas correspondentes.
     */
    public Baralho(String tema) {
        this.tema = tema;
    }

    /**
     * Carrega as cartas do arquivo CSV correspondente ao tema.
     * As informações são extraídas do arquivo e usadas para criar objetos Carta.
     */
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
            while ((linha = reader.readLine()) != null) {
                String[] palavrasLinha = linha.split(",");
                int j = 0;
                for (String palavra : palavrasLinha) {
                    tabela[i][j] = palavra;
                    j++;
                }
                i++;
            }

            // Extrai informações das cartas e atributos do arquivo
            nomeAtributos = new String[4];
            for (i = 0; i < 4; i++) {
                nomeAtributos[i] = tabela[0][i + 1];
            }
            nomeCartas = new String[32];
            codigo = new String[32];
            valorAtributosTabela = new int[32][4];
            for (i = 0; i < 32; i++) {
                nomeCartas[i] = tabela[i + 1][0];
                codigo[i] = tabela[i + 1][5];
                for (int j = 0; j < 4; j++) {
                    valorAtributosTabela[i][j] = Integer.parseInt(tabela[i + 1][j + 1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Não consigo fechar o leitor!");
            }
        }

        // Cria e adiciona as cartas ao baralho
        for (int i = 0; i < 32; i++) {
            int[] valorAtributos = valorAtributosTabela[i];
            Atributo[] atributos = new Atributo[4];

            for (int j = 0; j < 4; j++) {
                atributos[j] = new Atributo(nomeAtributos[j], valorAtributos[j], null);
            }

            // Criação da carta e adição ao baralho
            Carta carta = new Carta(nomeCartas[i], codigo[i], null, atributos, false);
            this.add(carta);
        }
    }

    /**
     * Embaralha as cartas no baralho.
     * Se o baralho estiver vazio, imprime uma mensagem de erro.
     */
    public void embaralhar() {
        if (!this.isEmpty()) {
            Collections.shuffle(this);
        } else {
            System.out.println("Este baralho está vazio! Use o método carregar() antes de poder embaralhar.");
        }
    }

    /**
     * Distribui as cartas entre os jogadores.
     * 
     * @param jogador1 O primeiro jogador.
     * @param jogador2 O segundo jogador.
     */
    public void distribuir(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        Iterator<Carta> iterator = this.iterator();
        Random random = new Random();

        JogadorAbstrato[] jogadores = {jogador1, jogador2}; 
        JogadorAbstrato toggleJogador = jogadores[random.nextInt(2)]; 

        // Distribuição das cartas aos jogadores alternadamente
        while (iterator.hasNext()) {
            toggleJogador.getMonte().add(iterator.next());
            iterator.remove();

            toggleJogador = (toggleJogador == jogador1) ? jogador2 : jogador1; 
        }
    }
}
