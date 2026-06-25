package principal;

import javax.swing.*;
import java.awt.*;

import telas.*;
import dados.*;

public class JanelaPrincipal extends JFrame {

    private CardLayout cardLayout; //Responsável por trocar as telas
    private JPanel paineis; //Guarda todas as telas

    private Introducao introducao;   //	Referências
    private Cena1 cena1;
    private Cena2 cena2;
    private Cena3 cena3;
    private Cena4 cena4;
    private Cena5 cena5;
    private IrParaInvestigacao investigacao;
    private FimDeJogo fimdejogo;

    private JLabel relogio;
    private Timer timer;
    private JLabel pontuacao;

    public JanelaPrincipal() {

        setSize(1300, 800);
        setResizable(false); //Impede de redimensionar
        setLocationRelativeTo(null); //Centraliza a janela
        setUndecorated(true); //Remove a barra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fecha o programa

        JLayeredPane painel = new JLayeredPane(); //Painel com camadas
        painel.setLayout(null);

        cardLayout = new CardLayout(); //Cria trocador de telas
        paineis = new JPanel(cardLayout); //Cria painel
        paineis.setBounds(0, 0, 1300, 800); //Ocupa toda a janela

        paineis.add(new MenuInicial(this), "menu"); //Adicionar as telas
        introducao = new Introducao(this);
        paineis.add(introducao, "introducao");
        paineis.add(new Instrucoes(this), "instrucoes");
        investigacao = new IrParaInvestigacao(this);
        paineis.add(investigacao, "investigacao");
        fimdejogo = new FimDeJogo(this);
        paineis.add(fimdejogo, "fimdejogo");
        cena1 = new Cena1(this);
        paineis.add(cena1, "cena1");
        cena2 = new Cena2(this);
        paineis.add(cena2, "cena2");
        cena3 = new Cena3(this);
        paineis.add(cena3, "cena3");
        cena4 = new Cena4(this);
        paineis.add(cena4, "cena4");
        cena5 = new Cena5(this);
        paineis.add(cena5, "cena5");

        pontuacao = new JLabel();
        pontuacao.setBounds(1000, 20, 250, 40);
        pontuacao.setFont(new Font("Arial", Font.BOLD, 28));
        pontuacao.setForeground(Color.WHITE);

        relogio = new JLabel();
        relogio.setBounds(650, 20, 150, 40);
        relogio.setFont(new Font("Arial", Font.BOLD, 28));
        relogio.setForeground(Color.WHITE);
        
        painel.add(paineis, Integer.valueOf(0)); //Adiciona as telas
        painel.add(pontuacao, Integer.valueOf(1));
        painel.add(relogio, Integer.valueOf(1));
        
        setContentPane(painel); //Painel principal
        setVisible(true); //Mostrar janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void atualizarPontuacao() {
        pontuacao.setText("Pontuação: " + EstadoDoJogo.pontuacao);
    }
    
    public void iniciarCronometro() {
        //if (timer != null) {
            //timer.stop();
        //}
        EstadoDoJogo.tempoRestante = 100; //Tempo inicial
        atualizarRelogio();

        timer = new Timer(1000, e -> { //A cada 1s
            EstadoDoJogo.tempoRestante--;
            atualizarRelogio();

            if (EstadoDoJogo.tempoRestante <= 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "TEMPO ESGOTADO!");
                trocarTela("fimdejogo");
            }
        });

        timer.start();
    }

    private void atualizarRelogio() {

        int minutos = EstadoDoJogo.tempoRestante / 60; //Calcula minutos
        int segundos = EstadoDoJogo.tempoRestante % 60; //Calcula o resto

        relogio.setText(String.format("%02d:%02d", minutos, segundos)); //Formatar
    }
    public void trocarTela(String nomeTela) {
    	
    	if (nomeTela.equals("fimdejogo")|| nomeTela.equals("menu")|| nomeTela.equals("instrucoes")) {
    	    pontuacao.setVisible(false);
    	    relogio.setVisible(false);
    	} 
    	else {
    	    pontuacao.setVisible(true);
    	    relogio.setVisible(true);
    	}

        switch (nomeTela) {
        	case "introducao":
        		introducao.IniciarCena();
        		break;
        	case "cena1":
	            cena1.IniciarCena();
	            break;
        	case "investigacao":
	            investigacao.IniciarCena();
	            break;
            case "cena2":
                cena2.atualizarTexto();
                break;
            case "cena3":
                cena3.atualizarTexto();
                break;
            case "cena4":
                cena4.atualizarTexto();
                break;
            case "fimdejogo":
                fimdejogo.atualizarResultado();
                break;
        }

        cardLayout.show(paineis, nomeTela); //Mudar tela
    }
}

