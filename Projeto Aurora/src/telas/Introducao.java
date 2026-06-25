package telas;

import javax.swing.*;

import dados.EfeitoDigitacao;

import java.awt.*;

import principal.JanelaPrincipal;

public class Introducao extends JPanel {

	private JanelaPrincipal janela;
	private JTextArea texto;

    public Introducao(JanelaPrincipal janela) {
    	
    	this.janela = janela;
    	
    	setOpaque(true);
    	setBackground(Color.BLACK);
        setLayout(null);

        texto = new JTextArea();
        texto.setFont(new Font("Arial", Font.BOLD, 25));
        texto.setBounds(200, 200, 900, 400);
        texto.setOpaque(false);
        texto.setForeground(Color.WHITE);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setBorder(null);
        add(texto);

        JButton continuar = new JButton("CONTINUAR");
        continuar.setBounds(500, 610, 325, 80);
        continuar.setFont(new Font("Impact", Font.BOLD, 35));
        continuar.setForeground(Color.WHITE);
        continuar.setBackground(new Color(40, 40, 40));
        continuar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        continuar.setVisible(true);
        add(continuar);
        continuar.addActionListener(e -> {
        	janela.trocarTela("cena1");
        });
    }
        public void IniciarCena() {
            texto.setText("");
            		EfeitoDigitacao.digitar(
            		texto,
            		"""
                    Todos os dias, inúmeras vítimas de violência doméstica buscam ajuda.

                    Aurora é uma dessas vítimas.

                    Ela vem enfrentando o ciclo da violência doméstica:
                    Controle excessivo, ameaças, abusos e manipulação.

                    Hoje não foi diferente.

                    Após uma série de agressões, ela decide romper o silêncio.
                    """,
                    50);
            }
}