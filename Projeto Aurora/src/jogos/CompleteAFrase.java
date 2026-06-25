package jogos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import principal.JanelaPrincipal;

public class CompleteAFrase extends JFrame implements ActionListener {

    // Arrays com as partes das frases e as respostas corretas
    private String[] inicioFrase = {
        "A principal lei brasileira para prevenir e punir violência doméstica e familiar contra a mulher é... ",
        "Outra opção de atendimento em casos de violência contra a mulher, ligue no número... ",
        "Homens também têm responsabilidade no combate à violência contra a... "
    };
    
    private String[] fimFrase = {
        ".",
        " - Central de Atendimento à Mulher.",
        "."
    };
    
    private String[] respostasCorretas = {
        "Lei Maria da Penha",
        "180",
        "mulher"
    };

    private int indiceAtual = 0;
    private int pontuacao = 0;

    // Componentes da Interface
    private JLabel lblInicio;
    private JLabel lblFim;
    private JTextField txtResposta;
    private JLabel lblPlacar;
    private JButton btnVerificar;
    
    private JanelaPrincipal janelaPrincipal;

    public CompleteAFrase(JanelaPrincipal janelaPrincipal) {
    	this.janelaPrincipal = janelaPrincipal;
    	
        setTitle("Missão 1: Complete a Frase!");
        setSize(900, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(50, 50));
        
        Color corFundo = new Color(25, 25, 25);
        Color corComponente = new Color(40, 40, 40);
        Color corBorda = new Color(70, 70, 70);
        
        getContentPane().setBackground(corFundo);

        // Painel Superior: Placar e Instruções
        lblPlacar = new JLabel("Pergunta 1 de " + respostasCorretas.length + " | Pontuação: 0", JLabel.CENTER);
        lblPlacar.setFont(new Font("Arial", Font.BOLD, 16));
        lblPlacar.setForeground(Color.LIGHT_GRAY);
        lblPlacar.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        add(lblPlacar, BorderLayout.NORTH);

        // Painel Central: A Frase com o campo de texto no meio
        JPanel painelFrase = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        painelFrase.setBackground(corFundo);
        
        lblInicio = new JLabel(inicioFrase[indiceAtual]);
        lblInicio.setFont(new Font("Arial", Font.PLAIN, 18));
        lblInicio.setForeground(Color.WHITE);
        
        txtResposta = new JTextField(14); // Campo de texto com largura para ~14 caracteres
        txtResposta.setFont(new Font("Arial", Font.BOLD, 16));
        txtResposta.setBackground(corComponente);
        txtResposta.setForeground(Color.WHITE);
        txtResposta.setCaretColor(Color.WHITE);
        txtResposta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(corBorda, 2),
            BorderFactory.createEmptyBorder(4, 8, 4, 8) // Padding interno para o texto não grudar na borda
        ));
        
        lblFim = new JLabel(fimFrase[indiceAtual]);
        lblFim.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFim.setForeground(Color.WHITE);

        painelFrase.add(lblInicio);
        painelFrase.add(txtResposta);
        painelFrase.add(lblFim);
        add(painelFrase, BorderLayout.CENTER);

        // Painel Inferior: Botão de ação
        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(corFundo);
        painelBotao.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        btnVerificar = new JButton("Verificar Resposta");
        btnVerificar.setFont(new Font("Arial", Font.BOLD, 15));
        btnVerificar.setForeground(Color.WHITE);
        btnVerificar.setBackground(new Color(40, 40, 40)); // Segue o padrão dos botões das suas cenas
        btnVerificar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        btnVerificar.setPreferredSize(new Dimension(200, 45));
        btnVerificar.setFocusPainted(false);
        
        btnVerificar.addActionListener(this);
        painelBotao.add(btnVerificar);
        add(painelBotao, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String respostaUsuario = txtResposta.getText().trim();

        // Validação (ignora maiúsculas/minúsculas para ser mais justo)
        if (respostaUsuario.equalsIgnoreCase(respostasCorretas[indiceAtual])) {
            JOptionPane.showMessageDialog(this, "Correto! ", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            pontuacao++;
        } else {
            JOptionPane.showMessageDialog(this, "Errado! A resposta era: " + respostasCorretas[indiceAtual], "Resultado", JOptionPane.ERROR_MESSAGE);
        }

        // Avança para a próxima pergunta
        indiceAtual++;

        if (indiceAtual < respostasCorretas.length) {
            // Atualiza os componentes com a nova frase
            lblInicio.setText(inicioFrase[indiceAtual]);
            lblFim.setText(fimFrase[indiceAtual]);
            txtResposta.setText(""); // Limpa o campo
            lblPlacar.setText("Pergunta " + (indiceAtual + 1) + " de " + respostasCorretas.length + " | Pontuação: " + pontuacao);
        } else {
            // Fim do jogo
            JOptionPane.showMessageDialog(this, "Fim de jogo! Você acertou " + pontuacao + " de " + respostasCorretas.length + " frases.");
            this.dispose();
            if (janelaPrincipal != null) {
            	SwingUtilities.invokeLater(()-> {
                	janelaPrincipal.trocarTela("cena3");
                });
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CompleteAFrase(null).setVisible(true);
        });
    }
}