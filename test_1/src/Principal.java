import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    private JComboBox<String> themeComboBox;
    private JButton startButton;
    private JTextArea statusTextArea;

    public Principal() {
        setTitle("Super Trunfo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        themeComboBox = new JComboBox<>(new String[]{"Ben 10", "One Piece", "BNHA", "Deuses"});
        startButton = new JButton("Iniciar Jogo");
        statusTextArea = new JTextArea();

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Escolha um tema:"));
        topPanel.add(themeComboBox);
        topPanel.add(startButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(statusTextArea), BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTheme = (String) themeComboBox.getSelectedItem();
                startGame(selectedTheme);
            }
        });
    }

    private void startGame(String theme) {
        Jogo jogo = new Jogo(theme);
        jogo.jogar();
        updateStatus(jogo.mostrarStatus());
        updateWinner(jogo.mostrarVencedor());
    }

    private void updateStatus(String status) {
        statusTextArea.append("\n" + status + "\n");
    }

    private void updateWinner(String winner) {
        statusTextArea.append("\n" + winner + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal janela new Principal();
            janela.setVisible(true);
        });
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== Super Trunfo ==============");
        System.out.println("Escolha um tema para o jogo: ");
        System.out.println("\tBen 10\n\tOne Piece\n\tBNHA\n\tDeuses");
        String tema = scanner.nextLine();
        System.out.println("Digite seu nome: ");
        String nick = scanner.nextLine();
        Jogo jogo = new Jogo(tema, nick);
        jogo.jogar();
        scanner.close();
    }
} 

