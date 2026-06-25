package telas;

import javax.swing.*;
import java.awt.*;

import dados.EstadoDoJogo;
import principal.JanelaPrincipal;

public class Cena5 extends JPanel {

	private Image fundoCenas;

    public Cena5(JanelaPrincipal janela) {
    	
    	fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoRelatorio.jpeg")).getImage();

		setLayout(null);
		
		JLabel nome1 = new JLabel();
		nome1.setText("Marcos Vinícius Oliveira");
		nome1.setBounds(310, 415, 300, 30);
		configurarTexto(nome1);
		add(nome1);
		JLabel endereco1 = new JLabel();
		endereco1.setText("Rua Santo Antônio, 26");
		endereco1.setBounds(320, 480, 300, 30);
		configurarTexto(endereco1);
		add(endereco1);
		JLabel bairro1 = new JLabel();
		bairro1.setText("Bairro Jardim Mariana");
		bairro1.setBounds(320, 540, 300, 30);
		configurarTexto(bairro1);
		add(bairro1);
				
		JLabel nome2 = new JLabel();
		nome2.setText("Marcos Vinícius Ferreira");
		nome2.setBounds(630, 415, 300, 30);
		configurarTexto(nome2);
		add(nome2);
		JLabel endereco2 = new JLabel();
		endereco2.setText("Rua São Vicente, 25");
		endereco2.setBounds(640, 480, 300, 30);
		configurarTexto(endereco2);
		add(endereco2);
		JLabel bairro2 = new JLabel();
		bairro2.setText("Bairro Vila Mariana");
		bairro2.setBounds(640, 540, 300, 30);
		configurarTexto(bairro2);
		add(bairro2);
		
		JLabel nome3 = new JLabel();
		nome3.setText("Marcos Vinícius Ferreira");
		nome3.setBounds(950, 415, 300, 30);
		configurarTexto(nome3);
		add(nome3);
		JLabel endereco3 = new JLabel();
		endereco3.setText("Rua São Vicente, 25");
		endereco3.setBounds(960, 480, 300, 30);
		configurarTexto(endereco3);
		add(endereco3);
		JLabel bairro3 = new JLabel();
		bairro3.setText("Bairro Vila Mariana");
		bairro3.setBounds(960, 540, 300, 30);
		configurarTexto(bairro3);
		add(bairro3);
				
	    JButton op1 = new JButton();
    	op1.setText("""
    			<html>
    			<center>
    			Registro 1
    			</center>
    			</html>
    			""");
        op1.setBounds(230, 720, 200, 60);
        configurarBotao(op1);
        add(op1);
        op1.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena5 = 1;
            janela.trocarTela("fimdejogo");
        });
        
        JButton op2 = new JButton();
    	op2.setText("""
    			<html>
    			<center>
    			Registro 2
    			</center>
    			</html>
    			""");
        op2.setBounds(545, 720, 200, 60);
        configurarBotao(op2);
        add(op2);
        op2.addActionListener(e -> {
        	EstadoDoJogo.pontuacao += 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena5 = 2;
            janela.trocarTela("fimdejogo");
        });
        
        JButton op3 = new JButton();
        op3.setText("""
    			<html>
    			<center>
    			Registro 3
    			</center>
    			</html>
    			""");
        op3.setBounds(870, 720, 200, 60);
        configurarBotao(op3);
        add(op3);
        op3.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena5 = 3;
            janela.trocarTela("fimdejogo");
        });
    }
    	 @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(fundoCenas, 0, 0, getWidth(), getHeight(), this);
    	 }
    	 private void configurarBotao(JButton botao) {
    		 botao.setFont(new Font("Arial", Font.BOLD, 17));
    	     botao.setForeground(Color.WHITE);
    	     botao.setBackground(new Color(40, 40, 40));
    	     botao.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
    	 }
    	 private void configurarTexto(JLabel texto) {
    		 texto.setOpaque(false);
    		 texto.setForeground(Color.WHITE);
    		 texto.setBorder(null);
    		 texto.setFont(new Font("Arial", Font.BOLD, 12));
    	 }
}


