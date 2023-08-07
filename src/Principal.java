import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame{
    public JanelaPrincipal() {

        setTitle("Jogo Super Trunfo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 


        JLabel tituloLabel = new JLabel("Bem-vindo ao Jogo Super Trunfo!");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setVerticalAlignment(JLabel.CENTER);

        JButton iniciarButton = new JButton("Iniciar Jogo");
        iniciarButton.setFont(new Font("Arial", Font.PLAIN, 18));
        iniciarButton.addActionListener(e -> iniciarJogo());


        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(tituloLabel, BorderLayout.CENTER);
        painelPrincipal.add(iniciarButton, BorderLayout.SOUTH);

        add(painelPrincipal);
    }
    public static void main(String[] args) {
        
            	SwingUtilities.invokeLater(() -> {
        	JanelaPrincipal janela = new JanelaPrincipal();
           	janela.setVisible(true);
      		});
        
        Jogo jogo = new Jogo();
        jogo.jogar();
    }
}
