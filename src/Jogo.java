public class Jogo {

    private Baralho baralho;
    private JogadorReal jogadorReal;
    private JogadorRandômico jogadorRandômico;



    //No construtor ele vai receber o tema do baralho e vai instaciar o baralho com o tema, toda a logica do tema está na classe baralho
    //Depois vai carregar o baralho e atribuir a cada jogador e com a metodo distribuir vai entregar a quantidade certa para cada jogador

    public Jogo(String tema, String nick) {
        baralho = new Baralho(tema);
        baralho.carregar();
    
        jogadorReal = new JogadorReal(nick, baralho);
        jogadorRandômico = new JogadorRandômico(nick, baralho);
    
        baralho.distribuir(jogadorReal, jogadorRandômico);
    }
    

    //Mostrar vencedor é mais para efeito visual, tem relação direta com a classe do jogador abstrato com a logica de monteVazio
    public void mostrarVencedor(){
        
        if(jogadorReal.monteVazio() && !jogadorRandômico.monteVazio()){
            System.out.println("\033[34m******____________**********___________******________");
            System.out.println(".   .   .    .Parabéns jogador, você venceu !!!.   .   .    .");
            System.out.println("******____________**********___________******________\033[0m");
        }
        else if(!jogadorReal.monteVazio() && jogadorRandômico.monteVazio()){
            System.out.println("\033[31m******____________**********___________******________");
            System.out.println(".   .   .    .A maquina venceu! Mais sorte na proxima !!!.   .   .    .");
            System.out.println("******____________**********___________******________\033[0m");
        }else{
            System.out.println("\033[33mDeu Empate, tente novamente.\033[0m]");
        }
    }

    //status é para ver o andamento do jogo 
    public void mostrarStatus(){
        System.out.println("=========Mostrar status=============");
        System.out.println("Jogador Real tem: " + jogadorReal.getQuantidadeCartas()+ "cartas");
        System.out.println("Jogador Randomico tem: " + jogadorRandômico.getQuantidadeCartas() + "cartas");
    }


    public void jogar() {
        baralho.embaralhar();
        baralho.distribuir(jogadorReal, jogadorRandômico);

        System.out.println("<<<<<<< SUPER TRUNFO - INICIADO >>>>>>");

        while (true) {
            System.out.println("\n______Turno do Jogador Real______");
            jogada(jogadorReal, jogadorRandômico);

            if (jogadorReal.monteVazio() || jogadorRandômico.monteVazio()) {
                break;
            }

            System.out.println("\n_____Turno do Jogador Adversário_____");
            jogada (jogadorRandômico, jogadorReal);

            if (jogadorReal.monteVazio() || jogadorRandômico.monteVazio()) {
                break;
            }
        }

        System.out.println("\n===== SuperTrunfo - Jogo Finalizado! =====");
        mostrarVencedor();
    }

    private void jogada(JogadorAbstrato jogadorAtivo, JogadorAbstrato jogadorPassivo) {
        Carta cartaJogadorAtivo = jogadorAtivo.getCartaSuperior();
        Atributo atributoEscolhido = jogadorAtivo.escolherAtributo(cartaJogadorAtivo.getAtributos());

        System.out.println("Jogador " + jogadorAtivo.getNick() + " escolheu o atributo: " + atributoEscolhido.getNome());

        Carta cartaJogadorPassivo = jogadorPassivo.getCartaSuperior();

        System.out.println("A carta do Jogador " + jogadorPassivo.getNick() + " é: " + cartaJogadorPassivo);

        int resultado = cartaJogadorAtivo.compararAtributo(cartaJogadorPassivo, atributoEscolhido);

        if (resultado > 0) {
            jogadorAtivo.adicionarCarta(cartaJogadorPassivo);
            jogadorPassivo.getCartaSuperior();
            System.out.println("Jogador " + jogadorAtivo.getNick() + " venceu a rodada!");
        } else if (resultado < 0) {
            jogadorPassivo.adicionarCarta(cartaJogadorAtivo);;
            jogadorAtivo.getCartaSuperior();
            System.out.println("Jogador " + jogadorPassivo.getNick() + " venceu a rodada!");
        } else {
            System.out.println("Empate! Ninguém ganhou a rodada.");
        }
    }
}
    
