package telas;

import javax.swing.*;
import java.awt.*;

import principal.JanelaPrincipal;

public class Instrucoes extends JPanel{
		
	private Image fundoInstrucoes;
	private JanelaPrincipal janela;
	
	public Instrucoes(JanelaPrincipal janela) {

	    this.janela = janela;
			
		fundoInstrucoes = new ImageIcon(getClass().getResource("/imagens/FundoInstrucoes.jpeg")).getImage();
			
		setLayout(null);
			
		JTextArea texto = new JTextArea();
	       texto.setText("""
	               Você é um atendente da central de monitoramento da Polícia Militar.
	               Durante uma ligação, uma mulher vítima de violência doméstica tentará pedir ajuda.

	               Suas escolhas podem:
	               • Ganhar pistas;
	               • Economizar ou perder tempo;
	               • Ganhar ou perder pontos;
	               • Salvar a vítima.

	               Escolha com atenção.
	               O tempo é limitado.
	               """);

	       texto.setEditable(false);
	       texto.setOpaque(false);
	       texto.setForeground(Color.WHITE);
	       texto.setLineWrap(true);
	       texto.setWrapStyleWord(true);
	       texto.setBorder(null);
	       texto.setFont(new Font("Arial", Font.BOLD, 25));
	       texto.setBounds(325, 225, 600, 400);
	       add(texto);
	        
	       JButton voltar = new JButton("VOLTAR");
	       voltar.setBounds(1000, 625, 200, 70);
	       voltar.setFont(new Font("Impact", Font.BOLD, 35));
	       voltar.setForeground(Color.WHITE);
	       voltar.setBackground(new Color(0, 40, 120));
	       voltar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	       add(voltar);
	        
	       voltar.addActionListener(e -> {
	    	   janela.trocarTela("menu");
			});
		}
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(fundoInstrucoes, 0, 0, getWidth(), getHeight(), this);

		}

	}


