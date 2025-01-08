import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IP Finder");
        frame.setSize(300, 200);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Criando o JLabel
        JLabel label = new JLabel("Digite o IP");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField texto = new JTextField();
        texto.setMaximumSize(new Dimension(200, 22));
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botao = new JButton("Ver IP");
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel resultado = new JLabel("Resultado:");
        resultado.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(Box.createVerticalStrut(20));
        frame.add(label);
        frame.add(Box.createVerticalStrut(10));
        frame.add(texto);
        frame.add(Box.createVerticalStrut(15));
        frame.add(botao);
        frame.add(Box.createVerticalStrut(15));
        frame.add(resultado);

        
        frame.setVisible(true);

        
        botao.addActionListener(e -> {
            String url = texto.getText();

            try {
                InetAddress endereco = InetAddress.getByName(url);
                resultado.setText("IP: " + endereco.getHostAddress());
            } catch (UnknownHostException ex) {
                resultado.setText("Erro: IP não encontrado"); 
            }
        });
    }
}
