package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.JanelaPrincipal;

public class Cena1 extends JPanel {

    private Image fundoCenas;
    private JTextArea dialogo2;
    private JanelaPrincipal janela;

    public Cena1(JanelaPrincipal janela) {

        this.janela = janela;

        fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoCenas.jpeg")).getImage();

        setLayout(null);

        JLabel dialogo1 = new JLabel("Polícia Militar, emergência...");
        dialogo1.setForeground(Color.WHITE);
        dialogo1.setFont(new Font("Arial", Font.BOLD, 25));
        dialogo1.setBounds(530, 100, 600, 400);
        add(dialogo1);

        dialogo2 = new JTextArea();
        dialogo2.setFont(new Font("Arial", Font.BOLD, 25));
        dialogo2.setBounds(410, 450, 600, 250);
        dialogo2.setOpaque(false);
        dialogo2.setForeground(Color.WHITE);
        dialogo2.setLineWrap(true);
        dialogo2.setWrapStyleWord(true);
        dialogo2.setEditable(false);
        dialogo2.setFocusable(false);
        dialogo2.setBorder(null);
        add(dialogo2);

        JButton op1 = new JButton();
        op1.setText("""
		    <html>
		    <center>
		    Mantenha a calma.<br>
		    O que ele tem feito?
		    </center>
		    </html>
		    """);
        op1.setBounds(330, 700, 200, 60);
        configurarBotao(op1);

        op1.addActionListener(e -> {
            EstadoDoJogo.pontuacao += 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena1 = 1;
            janela.trocarTela("cena2");
        });
        add(op1);

        JButton op2 = new JButton();
        op2.setText("""
        		    <html>
        		    <center>    
        		    Entendi, mas a senhora já<br>    
        		    tentou conversar com ele?    
        		    </center>    
        		    </html>
        		    """);
        op2.setBounds(585, 700, 230, 60);
        configurarBotao(op2);

        op2.addActionListener(e -> {
            EstadoDoJogo.pontuacao -= 5;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena1 = 2;
            janela.trocarTela("cena2");
        });

        add(op2);

        JButton op3 = new JButton("É trote. Desligar.");
        op3.setBounds(870, 700, 200, 60);
        configurarBotao(op3);

        op3.addActionListener(e -> {
            EstadoDoJogo.pontuacao -= 10;
            janela.atualizarPontuacao();
            EstadoDoJogo.escolhaCena1 = 3;
            janela.trocarTela("cena2");
        });

        add(op3);
    }
    public void IniciarCena() {

        dialogo2.setText("");

        EfeitoDigitacao.digitar(
                dialogo2,
                """
                Oi...eu preciso de ajuda.
                Faz muito tempo que venho sofrendo com o comportamento agressivo e manipulador do meu marido.
                Eu aproveitei que ele saiu para ligar...não sei quanto tempo tenho.
                Eu moro no bairro Vila Mariana.
                """,
                50
        );
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




