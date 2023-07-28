public class JogadorAbstrato {
        private String nick;
        private Baralho baralho;
    
        public JogadorAbstrato(String nick) {
            this.nick = nick;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public Baralho getBaralho() {
            return baralho;
        }

        public void setBaralho(Baralho baralho) {
            this.baralho = baralho;
        }

    

}
