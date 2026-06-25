package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.JanelaPrincipal;

public class Cena4 extends JPanel {

	private Image fundoCenas;
	private JLabel dialogo1;
	private JTextArea dialogo2;
	private JanelaPrincipal janela;

    public Cena4(JanelaPrincipal janela) {
    	this.janela = janela;
    	
    	fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoCenas.jpeg")).getImage();

		setLayout(null);
		
		dialogo1 = new JLabel();
        dialogo1.setForeground(Color.WHITE);
        dialogo1.setFont(new Font("Arial", Font.BOLD, 25));
        dialogo1.setBounds(400, 100, 600, 400);
        add(dialogo1);
        
        dialogo2 = new JTextArea();
		dialogo2.setForeground(Color.WHITE);
		dialogo2.setFont(new Font("Arial", Font.BOLD, 25));
		dialogo2.setBounds(400, 485, 600, 230);
		dialogo2.setLineWrap(true);
		dialogo2.setWrapStyleWord(true);
		dialogo2.setEditable(false);
		dialogo2.setFocusable(false);
	    dialogo2.setOpaque(false);
	    add(dialogo2);
	    
	    JButton op1 = new JButton();
    	op1.setText("""
    			<html>
    			<center>
    			Aguardar nova ligação
    			</center>
    			</html>
    			""");
        op1.setBounds(330, 700, 200, 60);
        configurarBotao(op1);
        add(op1);
        op1.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena4 = 1;
            janela.trocarTela("investigacao");
        });
        
        JButton op2 = new JButton();
    	op2.setText("""
    			<html>
    			<center>
    			Retornar ligação
    			</center>
    			</html>
    			""");
        op2.setBounds(585, 700, 230, 60);
        configurarBotao(op2);
        add(op2);
        op2.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena4 = 2;
            janela.trocarTela("investigacao");
        });
        
        JButton op3 = new JButton();
        op3.setText("""
    			<html>
    			<center>
    			Acionar imediatamente a equipe de prontidão
    			</center>
    			</html>
    			""");
        op3.setBounds(870, 700, 200, 60);
        configurarBotao(op3);
        add(op3);
        op3.addActionListener(e -> {
        	EstadoDoJogo.pontuacao += 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena4 = 3;
            janela.trocarTela("investigacao");
        });
    }
    public void atualizarTexto() {
		
		dialogo1.setText("");
		dialogo2.setText("");
		
		if(EstadoDoJogo.escolhaCena3 == 1) {
			dialogo1.setText("""
					<html>
					Faz o seguinte estarei enviando uma viatura ao local<br>
					Qual o número da residência?
					</html>
					""");
		        EfeitoDigitacao.digitar(
		                dialogo2,
		                """
		                Eu ouvi o portão abrindo
		                Ele chegou
		                O número da casa é vinte e...
		                """,
		                50);
		}
		else if(EstadoDoJogo.escolhaCena3 == 2) {
			dialogo1.setText("""
					<html>
					Preciso que me passe o número da casa e os seus dados para registro
					</html>
					""");
			EfeitoDigitacao.digitar(
	                dialogo2,
	                """
	                Não tenho muito tempo
					Ele chegou
					O número da casa é vinte e...
	                """,
	                50);
		}
		else if(EstadoDoJogo.escolhaCena3 == 3) {
			dialogo1.setText("""
					<html>
					Qual o número da casa?<br>
					Você vai realmente registrar o caso?
					</html>
					""");
			EfeitoDigitacao.digitar(
	                dialogo2,
	                """
	                Preciso registrar, esse ciclo de violência tem que acabar
					Mas não tenho muito tempo, ele acabou de chegar
					O número é vinte e...
	                """,
	                50);
		}
		
	    repaint();
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
}    	 
    	 

