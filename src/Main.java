import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame("IP Finder");
        frame.setSize(300, 200);  // Aumentando o tamanho para caber todos os componentes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Criando o JLabel
        JLabel label = new JLabel("Digite o IP");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criando o JTextField
        JTextField texto = new JTextField();
        texto.setMaximumSize(new Dimension(200, 22));
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criando o JButton
        JButton botao = new JButton("Ver IP");
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criando um JLabel para mostrar o resultado
        JLabel resultado = new JLabel("Resultado:");
        resultado.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando os componentes ao JFrame com espaçamento
        frame.add(Box.createVerticalStrut(20));
        frame.add(label);
        frame.add(Box.createVerticalStrut(10));
        frame.add(texto);
        frame.add(Box.createVerticalStrut(15));
        frame.add(botao);
        frame.add(Box.createVerticalStrut(15));
        frame.add(resultado);

        // Tornando o JFrame visível
        frame.setVisible(true);

        // Adicionando ActionListener ao botão
        botao.addActionListener(e -> {
            String url = texto.getText();  // Pegando o texto do campo de texto

            try {
                InetAddress endereco = InetAddress.getByName(url);  // Obter o endereço IP
                resultado.setText("IP: " + endereco.getHostAddress());  // Mostrar o IP obtido
            } catch (UnknownHostException ex) {
                resultado.setText("Erro: IP não encontrado");  // Exibir erro caso não encontre o IP
            }
        });
    }
}
