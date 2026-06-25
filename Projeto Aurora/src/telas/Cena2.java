package telas;

import javax.swing.*;
import java.awt.*;
import dados.*;
import principal.JanelaPrincipal;
import jogos.CompleteAFrase;

public class Cena2 extends JPanel {

	private Image fundoCenas;
	private JLabel dialogo1;
	private JTextArea dialogo2;
	private JanelaPrincipal janela;

    public Cena2(JanelaPrincipal janela) {
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
		dialogo2.setBounds(410, 485, 600, 230);
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
    			Compreendo. O que ele está fazendo é crime de violência patrimonial e psicológica<br>
    			A senhora consegue ir para um lugar seguro até a chegada da viatura?
    			</center>
    			</html>
    			""");
        op1.setBounds(50, 700, 380, 90);
        configurarBotao(op1);
        add(op1);
        op1.addActionListener(e -> {
        	EstadoDoJogo.pontuacao += 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena2 = 1;
            SwingUtilities.invokeLater(() -> {
            	new CompleteAFrase(janela).setVisible(true);
            });
        });
        
        JButton op2 = new JButton();
    	op2.setText("""
    			<html>
    			<center>
    			Entendo, senhora<br>
    			Mas por que não buscou ajuda antes?
    			</center>
    			</html>
    			""");
        op2.setBounds(460, 700, 380, 90);
        configurarBotao(op2);
        add(op2);
        op2.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena2 = 2;
            SwingUtilities.invokeLater(() -> {
                new CompleteAFrase(janela).setVisible(true);
            });
        });
        
        JButton op3 = new JButton();
        op3.setText("""
    			<html>
    			<center>
    			Para registrar isso preciso que a senhora<br>
    			se encaminhe à delegacia mais próxima
    			</center>
    			</html>
    			""");
        op3.setBounds(870, 700, 380, 90);
        configurarBotao(op3);
        add(op3);
        op3.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena2 = 3;
            SwingUtilities.invokeLater(() -> {
                new CompleteAFrase(janela).setVisible(true);
            });
        });
        
    }
	public void atualizarTexto() {
		
		dialogo1.setText("");
		dialogo2.setText("");
		
		if(EstadoDoJogo.escolhaCena1 == 1) {
			dialogo1.setText("""
					<html>
					Mantenha a calma. O que ele tem feito?
					</html>
					""");

		        EfeitoDigitacao.digitar(
		                dialogo2,
		                """
		                Ele controla tudo
		                Meu dinheiro fica com ele, não posso sair sem autorização
		                O nome dele é Marcos Vinícus Oliveira
		                """,
		                50
		        );
		}
		else if(EstadoDoJogo.escolhaCena1 == 2) {
			dialogo1.setText("""
					<html>
					Entendi...
					Mas a senhora já tentou conversar com ele?
					</html>
					""");
			
		        EfeitoDigitacao.digitar(
		                dialogo2,
		                """
		                Eu já tentei conversar
		                Ele chora, diz que vai mudar, mas no dia seguinte começa tudo de novo
		                Preciso de ajuda
		                O nome dele é Marcos Vinícius Oliveira
		                """,
		                50
		        );
		    }
		else if(EstadoDoJogo.escolhaCena1 == 3) {
			dialogo1.setText("""
					<html>
					...................
					</html>
					""");
		        EfeitoDigitacao.digitar(
		                dialogo2,
		                """
		                Oi...acho que a ligação caiu
		                Estou sofrendo diversos tipos de abuso por parte do meu marido
		                Preciso de ajuda
		                O nome dele é Marcos Vinícius Oliveira
		                """,
		                50
		        );
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
