package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.JanelaPrincipal;

public class Cena3 extends JPanel {

	private Image fundoCenas;
	private JLabel dialogo1;
	private JTextArea dialogo2;
	private JanelaPrincipal janela;

    public Cena3(JanelaPrincipal janela) {
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
    			Faz o seguinte estarei enviando uma viatura ao local<br>
    			Qual o número da residência?
    			</center>
    			</html>
    			""");
        op1.setBounds(50, 690, 380, 100);
        configurarBotao(op1);
        add(op1);
        op1.addActionListener(e -> {
        	EstadoDoJogo.pontuacao += 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena3 = 1;
            janela.trocarTela("cena4");
            JOptionPane.showMessageDialog(null, "A ligação foi interrompida.", "Chamada encerrada", JOptionPane.WARNING_MESSAGE);
        });
        
        JButton op2 = new JButton();
    	op2.setText("""
    			<html>
    			<center>
    			Preciso que me passe o número da casa e os seus dados para registro
    			</center>
    			</html>
    			""");
        op2.setBounds(460, 690, 380, 100);
        configurarBotao(op2);
        add(op2);
        op2.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena3 = 1;
            janela.trocarTela("cena4");
            JOptionPane.showMessageDialog(null, "A ligação foi interrompida.", "Chamada encerrada", JOptionPane.WARNING_MESSAGE);
            });
            
        JButton op3 = new JButton();
        op3.setText("""
    			<html>
    			<center>
    			Qual o número da casa?<br>
    			Você vai realmente registrar o caso?
    			</center>
    			</html>
    			""");
        op3.setBounds(870, 690, 380, 100);
        configurarBotao(op3);
        add(op3);
        op3.addActionListener(e -> {
        	EstadoDoJogo.pontuacao -= 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena3 = 1;
            janela.trocarTela("cena4");
            JOptionPane.showMessageDialog(null, "A ligação foi interrompida.", "Chamada encerrada", JOptionPane.WARNING_MESSAGE);
            });
    }
    	public void atualizarTexto() {
		
    		dialogo1.setText("");
    		dialogo2.setText("");
    		
    		if(EstadoDoJogo.escolhaCena2 == 1) {
    			dialogo1.setText("""
    					<html>
    					Compreendo. O que ele está fazendo é crime de violência patrimonial e psicológica<br>
    					A senhora consegue ir para um lugar seguro até a chegada da viatura?
    					</html>
    					""");
    		        EfeitoDigitacao.digitar(
    		                dialogo2,
    		                """
    		                Vou tentar ir para a casa dos vizinhos
    		                Ele me destruiu tanto por dentro quanto por fora
    		                Nem lembrava mais que tinha o direito de viver
    		                """,
    		                50);
    		}
    		else if(EstadoDoJogo.escolhaCena2 == 2) {
				dialogo1.setText("""
						<html>
						Entendo, senhora<br>
						Mas por que não buscou ajuda antes?
						</html>
						""");
				EfeitoDigitacao.digitar(
						dialogo2,
		                """
						Não pedi ajuda antes por vergonha do que os outros iam pensar
						Eu achava que a culpa era minha
		                """,
		                50);
    		}
		
    		else if(EstadoDoJogo.escolhaCena2 == 3) {
				dialogo1.setText("""
						<html>
						Para registrar isso preciso que a senhora<br>
						se encaminhe à delegacia mais próxima
						</html>
						""");
				EfeitoDigitacao.digitar(
		               dialogo2,
		               		"""
		               		Eu não sei onde fica a delegacia especializada
		               		Não quero ir à uma comum
		               		Tenho medo de ir e não me levarem a sério
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
