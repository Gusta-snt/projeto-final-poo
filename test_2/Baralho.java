import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
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

    public void removerCartaSuperior(Carta carta) {
        this.remove(carta);
    }

    public Baralho(String tema) {
        this.tema = tema;
    }

    public void carregar() {
        String arquivo = "data/" + this.tema.replaceAll("\\s+", "").toLowerCase() + ".csv";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(arquivo));
            String[][] tabela = new String[34][9];
            int i = 0;
            String linha;

while ((linha = reader.readLine()) != null) {
    String[] palavrasLinha = linha.split(";");
    if (palavrasLinha.length >= 9) {
        int j = 0;
        for (String palavra : palavrasLinha) {
            if (palavra != null) {
                tabela[i][j] = palavra;
            } else {
                tabela[i][j] = "";
            }
            j++;
        }
        i++;
    } else {
        for (int j = 0; j < 9; j++) { // Adicione um loop para preencher todas as colunas
            tabela[i][j] = "";
        }
        i++;
    }
}


            String[][] nomeAtributos = new String[4][2];
            for (i = 0; i < 4; i++) {
                if (tabela[0][i + 1] != null) {
                    nomeAtributos[i] = tabela[0][i + 1].split("-");
                } else {
                    nomeAtributos[i] = new String[0]; // Preenche com um array vazio se for nulo
                }
            }

            String[] nomeCartas = new String[32];
            String[] codigo = new String[32];
            Boolean[] isSuperTrunfo = new Boolean[32];
            String[] descricao = new String[32];
            String[][] valorAtributosTabela = new String[32][4];
            for (i = 0; i < 32; i++) {
                nomeCartas[i] = tabela[i + 1][0];
                codigo[i] = tabela[i + 1][5];
                if (tabela[i + 1][6] != null && !tabela[i + 1][6].isEmpty()) {
                    isSuperTrunfo[i] = Boolean.parseBoolean(tabela[i + 1][6]);
                } else {
                	isSuperTrunfo[i] = false;
                }
                descricao[i] = tabela[i + 1][7];
                for (int j = 0; j < 4; j++) {
                    valorAtributosTabela[i][j] = tabela[i + 1][j + 1];
                }
            }

            for (i = 0; i < 32; i++) {
                String[] valorAtributos = new String[4];
                for (int j = 0; j < 4; j++) {
                    valorAtributos[j] = valorAtributosTabela[i][j];
                }
                Carta carta = new Carta(nomeAtributos, valorAtributos, nomeCartas[i], codigo[i], isSuperTrunfo[i], descricao[i]);
                this.add(carta);
            }
        } catch (IOException e) {
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
    }

    public void embaralhar() {
        if (!this.isEmpty()) {
            Collections.shuffle(this);
            Collections.shuffle(this);
        } else {
            System.out.println("Este baralho está vazio!");
        }
    }

    public void distribuir(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        Iterator<Carta> iterator = this.iterator();

        JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;

        JogadorAbstrato toggleJogador = jogadores[ThreadLocalRandom.current().nextInt(0, 1 + 1)];

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();

            if (toggleJogador == jogador1) {
                toggleJogador = jogador2;
            } else {
                toggleJogador = jogador1;
            }
        }
    }

    public Carta pegarDoTopo() {
        return null;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tema);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baralho other = (Baralho) obj;
		return Objects.equals(tema, other.tema);
	}

	@Override
	public String toString() {
		return "Baralho [tema=" + tema + "]";
	}
}
