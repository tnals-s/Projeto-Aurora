package telas;

import javax.swing.*;
import java.awt.*;

import principal.JanelaPrincipal;
import dados.EstadoDoJogo;

public class MenuInicial extends JPanel{
	
	private JanelaPrincipal janela;
	private Image fundo;
		
		public MenuInicial(JanelaPrincipal janela) {
			this.janela = janela;
		
			fundo = new ImageIcon(getClass().getResource("/imagens/Fundo.jpeg")).getImage();
			
			setLayout(null);
	
	        JButton jogar = new JButton("JOGAR");
			jogar.setBounds(500, 320, 325, 80);
	        jogar.setFont(new Font("Impact", Font.BOLD, 35));
	        jogar.setForeground(Color.WHITE);
	        jogar.setBackground(new Color(120, 0, 0));
	        jogar.setFocusPainted(false);
	        jogar.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			add(jogar);
			jogar.addActionListener(e -> {
				janela.trocarTela("introducao");
				 EstadoDoJogo.pontuacao = 0;
				 janela.atualizarPontuacao();
				 janela.iniciarCronometro();
			});
	
	        JButton instrucoes = new JButton("INSTRUÇÕES");
	        instrucoes.setBounds(500, 410, 325, 80);
	        instrucoes.setFont(new Font("Impact", Font.BOLD, 35));
	        instrucoes.setForeground(Color.WHITE);
	        instrucoes.setBackground(new Color(0, 40, 120));
	        instrucoes.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
	        add(instrucoes);
	        instrucoes.addActionListener(e -> {
	        	janela.trocarTela("instrucoes");
			});
	        
	        JButton sair = new JButton("SAIR");
	        sair.setBounds(500, 500, 325, 80);
	        sair.setFont(new Font("Impact", Font.BOLD, 35));
	        sair.setForeground(Color.WHITE);
	        sair.setBackground(new Color(40, 40, 40));
	        sair.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
	        add(sair);
	        sair.addActionListener(e -> System.exit(0));    
	    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);

	}

}
