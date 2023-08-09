import java.util.Arrays;
import java.util.LinkedList;

public class Jogo {

    private Baralho baralho;
    private JogadorReal jogadorReal;
    private JogadorRandômico jogadorRandômico;

    // Construtor da classe Jogo
    public Jogo(String tema) {
        // Inicialização do baralho com o tema
        baralho = new Baralho(tema);
        baralho.carregar();

        // Criação dos jogadores reais e randômicos
        jogadorReal = new JogadorReal(baralho);
        jogadorReal.setNome(" \033[34m Eu \033[0m ");  // Defina o nome do jogador real aqui
        jogadorRandômico = new JogadorRandômico(baralho);
        jogadorRandômico.setNome(" \033[32mAdversário\033[0m "); // Defina um nome para o jogador adversário
    }

    // Método para mostrar o vencedor do jogo
    public void mostrarVencedor(){
        // Verificação de quem venceu ou se houve empate
        if(jogadorReal.monteVazio() && !jogadorRandômico.monteVazio()){
            // Mensagem de vitória do jogador real
            System.out.println("\033[34m******____________**********___________******________");
            System.out.println(".   .   .    .Parabéns jogador, você venceu !!!.   .   .    .");
            System.out.println("******____________**********___________******________\033[0m");
        }
        else if(!jogadorReal.monteVazio() && jogadorRandômico.monteVazio()){
            // Mensagem de vitória do jogador randômico
            System.out.println("\033[31m******____________**********___________******________");
            System.out.println(".   .   .    .A maquina venceu! Mais sorte na proxima !!!.   .   .    .");
            System.out.println("******____________**********___________******________\033[0m");
        }else{
            // Mensagem de empate
            System.out.println("\033[33mDeu Empate, tente novamente.\033[0m]");
        }
    }

    // Método para mostrar o status do jogo
    public void mostrarStatus(){
        // Exibe a quantidade de cartas dos jogadores
        System.out.println("=========Mostrar status=============");
        System.out.println("Jogador Real tem: " + jogadorReal.getQuantidadeCartas()+ "cartas");
        System.out.println("Jogador Randomico tem: " + jogadorRandômico.getQuantidadeCartas() + "cartas");
    }

    // Método principal para jogar
    public void jogar() {
        // Embaralha o baralho e distribui as cartas
        baralho.embaralhar();
        baralho.distribuir(jogadorReal, jogadorRandômico);

        System.out.println("<<<<<<< SUPER TRUNFO - INICIADO >>>>>>");

        // Loop principal do jogo
        while (true) {
            System.out.println("\n______Turno do Jogador Real______");
            jogada(jogadorReal, jogadorRandômico);

            // Verifica se algum jogador já não tem mais cartas
            if (jogadorReal.monteVazio() || jogadorRandômico.monteVazio()) {
                break; // Sai do loop se algum jogador ganhou
            }

            System.out.println("\n_____Turno do Jogador Adversário_____");
            jogada(jogadorRandômico, jogadorReal);

            // Verifica novamente se algum jogador já não tem mais cartas
            if (jogadorReal.monteVazio() || jogadorRandômico.monteVazio()) {
                break; // Sai do loop se algum jogador ganhou
            }
        }

        // Exibe o resultado final do jogo
        System.out.println("\n===== SuperTrunfo - Jogo Finalizado! =====");
        mostrarVencedor();
    }

    // Método para realizar uma jogada
    public void jogada(JogadorAbstrato jogadorAtivo, JogadorAbstrato jogadorPassivo) {
        // Obtém a carta do jogador ativo
        Carta cartaJogadorAtivo = jogadorAtivo.getCartaSuperior();
        
        // Converte os atributos da carta ativa em uma lista
        LinkedList<Atributo> atributosCartaJogadorAtivo = new LinkedList<>(Arrays.asList(cartaJogadorAtivo.getAtributos()));
        
        // Jogador ativo escolhe um atributo
        Atributo atributoEscolhido = jogadorAtivo.escolherAtributo(atributosCartaJogadorAtivo);

        System.out.println("Jogador " + jogadorAtivo.getNome() + " escolheu o atributo: " + atributoEscolhido.getNome());

        // Adiciona um atraso de 2 segundos para a próxima jogada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtém a carta do jogador passivo
        Carta cartaJogadorPassivo = jogadorPassivo.getCartaSuperior();

        System.out.println("A carta do Jogador " + jogadorPassivo.getNome() + " é: " + cartaJogadorPassivo);

        // Compara os atributos das cartas
        int resultado = cartaJogadorAtivo.compararAtributo(cartaJogadorPassivo, atributoEscolhido);

        // Exibe o resultado da rodada
        if (resultado > 0) {
            jogadorAtivo.adicionarCarta(cartaJogadorPassivo);
            jogadorPassivo.getCartaSuperior();
            System.out.println("\033[33mJogador " + jogadorAtivo.getNome() + " venceu a rodada!\033[0m");
        } else if (resultado < 0) {
            jogadorPassivo.adicionarCarta(cartaJogadorAtivo);
            jogadorAtivo.getCartaSuperior();
            System.out.println("\033[32mJogador " + jogadorPassivo.getNome() + " venceu a rodada!\033[0m");
        } else {
            System.out.println("\033[36mEmpate! Ninguém ganhou a rodada.\033[0m");
        }
    }
}
