package dados;

import javax.swing.*;
import java.awt.*;

public class EfeitoDigitacao {
	
	public static void digitar(JTextArea area, String digitar, int velocidade) {
		
		area.setText(""); //Apaga tudo antes de começar
		final String texto = digitar.stripLeading(); //Remove espaços e quebras de linha
		
		final int[] indice = {0};
		
		Timer timer = new Timer(velocidade, e ->{ //Executa repetiamente
			if(indice [0] < texto.length()) { //Verifica se ainda existem letras para mostrar
				area.setText(texto.substring(0, indice[0] + 1)); //Nova String / copia sem alterar
				indice[0]++;
			}
			else {
				((Timer)e.getSource()).stop(); //Fim do texto parar
			}
		});
		timer.start();
			
	}

}
