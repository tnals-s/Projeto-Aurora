package telas;

import javax.swing.*;
import java.awt.*;

import dados.EstadoDoJogo;
import principal.JanelaPrincipal;

public class FimDeJogo extends JPanel {

	private Image fundoFimDeJogo;
    private JLabel pontuacao;
    private JTextArea desempenho;

    public FimDeJogo(JanelaPrincipal janela) {

    	fundoFimDeJogo = new ImageIcon(getClass().getResource("/imagens/FundoFimDeJogo.jpeg")).getImage();

        setLayout(null);

        pontuacao = new JLabel();
        pontuacao.setBounds(650, 320, 400, 40);
        pontuacao.setFont(new Font("Arial", Font.BOLD, 30));
        pontuacao.setForeground(Color.WHITE);
        add(pontuacao);

        desempenho = new JTextArea();
        desempenho.setBounds(350, 500, 800, 150);
        desempenho.setFont(new Font("Arial", Font.PLAIN, 24));
        desempenho.setOpaque(false);
        desempenho.setForeground(Color.WHITE);
        desempenho.setEditable(false);
        desempenho.setLineWrap(true);
        add(desempenho);

        JButton reiniciar = new JButton("JOGAR NOVAMENTE");
        	reiniciar.setBounds(335, 705, 200, 60);
	        reiniciar.setFont(new Font("Arial", Font.BOLD, 17));
	        reiniciar.setForeground(Color.WHITE);
	        reiniciar.setBackground(new Color(40, 40, 40));
	        reiniciar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
            reiniciar.addActionListener(e -> {
            EstadoDoJogo.pontuacao = 0;
            janela.atualizarPontuacao();
            janela.trocarTela("menu");
        });
        add(reiniciar);

        JButton sair = new JButton("SAIR");
        sair.setBounds(760, 705, 200, 60);
        sair.setFont(new Font("Arial", Font.BOLD, 17));
        sair.setForeground(Color.WHITE);
        sair.setBackground(new Color(40, 40, 40));
        sair.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        sair.addActionListener(e -> System.exit(0));
        add(sair);
    }

    public void atualizarResultado() {

        int pontos = EstadoDoJogo.pontuacao;

        pontuacao.setText("" + pontos);

        if (pontos >= 40) {
            desempenho.setText("Suas decisões foram adequadas");           
        } 
        else if (pontos >= 20) {
            desempenho.setText("Ainda há aspectos a serem melhorados");
        } 
        else {
            desempenho.setText("Horrível");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundoFimDeJogo, 0, 0, getWidth(), getHeight(), this);
    }
}