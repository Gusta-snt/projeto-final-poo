public class Jogo {

    private Baralho baralho;
    private JogadorReal jogadorReal;
    private JogadorRandômico jogadorRandômico;



    //No construtor ele vai receber o tema do baralho e vai instaciar o baralho com o tema, toda a logica do tema está na classe baralho
    //Depois vai carregar o baralho e atribuir a cada jogador e com a metodo distribuir vai entregar a quantidade certa para cada jogador

    public Jogo(String tema, String nomeJogador) {
        baralho = new Baralho(tema);
        baralho.carregar();
        baralho.embaralhar();

        jogadorReal = new JogadorReal(nomeJogador, baralho.getTema());
        jogadorRandômico = new JogadorRandômico("CPU" , baralho.getTema());

        baralho.distribuir(jogadorReal, jogadorRandômico);
    }

    //Mostrar vencedor é mais para efeito visual, tem relação direta com a classe do jogador abstrato com a logica de monteVazio
    public void mostrarVencedor(){
        
        if(!jogadorReal.monteVazio() && jogadorRandômico.monteVazio()){
            System.out.println("\033[34m******____________**********___________******________");
            System.out.println(".   .   .    .Parabéns jogador, você venceu !!!.   .   .    .");
            System.out.println("******____________**********___________******________\033[0m");
        }
        else if(jogadorReal.monteVazio() && !jogadorRandômico.monteVazio()){
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
        System.out.println("Jogador Real tem: " + jogadorReal.getMonte().getQtdCartas()+ "cartas");
        System.out.println("Jogador Randomico tem: " + jogadorRandômico.getMonte().getQtdCartas() + "cartas");
    }


    public void jogar() {

        System.out.println("<<<<<<< SUPER TRUNFO - INICIADO >>>>>>");
        JogadorAbstrato jogadorDaVez = jogadorReal;

        while (true) {
            
            if(jogadorDaVez instanceof JogadorRandômico) {
                System.out.println("\n______Turno do Computador______");
                jogada(jogadorRandômico, jogadorReal);
                jogadorDaVez = jogadorReal;
            }else{
                System.out.println("\n______Turno do Jogador " + jogadorReal.getNome() + "______");
                jogada(jogadorReal, jogadorRandômico);
                jogadorDaVez = jogadorRandômico;
            }
            mostrarStatus();
            jogadorRandômico.getMonte().embaralhar();
            jogadorReal.getMonte().embaralhar();

            if (jogadorReal.monteVazio() || jogadorRandômico.monteVazio()) {
                break;
            }

        }

        System.out.println("\n===== SuperTrunfo - Jogo Finalizado! =====");
        mostrarVencedor();
    }

    private void jogada(JogadorAbstrato jogadorAtivo, JogadorAbstrato jogadorPassivo) {
        Carta cartaJogadorAtivo = jogadorAtivo.getMonte().getFirst();
        Atributo<Number> atributoEscolhido = jogadorAtivo.escolherAtributo(cartaJogadorAtivo);

        System.out.println("Jogador " + jogadorAtivo.getNome() + " escolheu o atributo: " + atributoEscolhido.getNome());

        Carta cartaJogadorPassivo = jogadorPassivo.getMonte().getFirst();

        System.out.println("A carta do Jogador " + jogadorPassivo.getNome() + " é: " + cartaJogadorPassivo);
        
        Atributo<Number> atributoPassivo = null;
        for(int i = 0; i < 4; i++) {
            atributoPassivo = cartaJogadorPassivo.getAtributos()[i];
            if(atributoEscolhido.getNome() == atributoPassivo.getNome()){
                break;
            }
        }

        boolean c1IsSuperTrunfo = verificaSuperTrunfo(
            cartaJogadorAtivo,
            cartaJogadorPassivo,
            atributoEscolhido.getValor(),
            atributoPassivo.getValor(),
            jogadorAtivo,
            jogadorPassivo
        );
        
        boolean c2IsSuperTrunfo = verificaSuperTrunfo(
            cartaJogadorPassivo,
            cartaJogadorAtivo,
            atributoEscolhido.getValor(),
            atributoPassivo.getValor(),
            jogadorPassivo,
            jogadorAtivo
        );

        if(!c1IsSuperTrunfo && !c2IsSuperTrunfo) {
            comparaAtributos(atributoEscolhido.getValor(), atributoPassivo.getValor(), jogadorPassivo, jogadorAtivo);
        }
    }

    public void comparaAtributos(double atributoPassivo, double atributoAtivo, JogadorAbstrato jogadorPassivo, JogadorAbstrato jogadorAtivo) {
        if (atributoAtivo > atributoPassivo) {

            jogadorAtivo.getMonte().adicionarCarta(jogadorPassivo.getMonte().getCartaTopo());
            System.out.println("Jogador " + jogadorAtivo.getNome() + " venceu a rodada!");

        } else if (atributoAtivo < atributoPassivo) {

            jogadorPassivo.getMonte().adicionarCarta(jogadorAtivo.getMonte().getCartaTopo());
            System.out.println("Jogador " + jogadorPassivo.getNome() + " venceu a rodada!");

        } else {
            System.out.println("Empate! Ninguém ganhou a rodada.");
        }
    }

    public boolean verificaSuperTrunfo(
        Carta cartaJogadorAtivo,
        Carta cartaJogadorPassivo,
        double atributoAtivo,
        double atributoPassivo,
        JogadorAbstrato jogadorAtivo,
        JogadorAbstrato jogadorPassivo
    ) {
        if (cartaJogadorAtivo.getIsSuperTrunfo()) {
            if (cartaJogadorPassivo.getCodigo().contains("A")) {
                comparaAtributos(atributoAtivo, atributoPassivo, jogadorPassivo, jogadorAtivo);
            }else{
                Carta carta = jogadorPassivo.getMonte().getCartaTopo();
                jogadorAtivo.getMonte().adicionarCarta(carta);
                System.out.println("SUPER TRUNFO!");
                System.out.println("Jogador " + jogadorAtivo.getNome() + " venceu a rodada!");
            }
            return true;
        }
        return false;
    }
}
