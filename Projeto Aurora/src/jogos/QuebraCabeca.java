package jogos;

import javax.swing.*; //Importa componentes swing
import java.awt.*; //Criar GUIs e renderizar
import java.awt.event.*; //Interatividade do usuário
import java.awt.image.BufferedImage; //Manipular imagens na memória
import java.util.*; //Classes utilitárias do Java
import javax.imageio.ImageIO; //Permite carregar imagens

public class QuebraCabeca extends JFrame {
	
	ImageIcon[] pecas = new ImageIcon[9]; //Vetor para guardar as imagens das peças

	//Guarda a posição das peças no tabuleiro
	//-1 é o espaço vazio
	int[] atual = {
			2,3,5,
			1,-1,6,
			4,7,0
	};
	
	//Ordem correta
	int[] correto = {
			0,1,2,
			3,4,5,
			6,7-1
	};
	
	//Posição do espaço vazio
	int vazio = 4;
    
    //Construtor
    public QuebraCabeca() {

        setTitle("Missão 5: Quebra-Cabeça 3x3");
        setSize(620,640);
        setLayout(new GridLayout(3,3)); //Cria uma grade com 3 linhas e 3 colunas

        carregarImagem(); //Chama o método que corta a imagem

        desenhar(); //Mostra as peças na tela

        setLocationRelativeTo(null); //Centraliza a janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Encerra o programa por completo
        setVisible(true); //Torna a janela visível
    }

    private void carregarImagem() { //Carrega a imagem e divide em peças

        try {

            BufferedImage img = ImageIO.read(getClass().getResource("/imagens/Cont.jpeg")); //Carrega a imagem

            int largura = img.getWidth()/3; //Divide a largura da imagem por 3
            int altura = img.getHeight()/3; //Divide a altura da imagem por 3   

            int indice = 0; //Contador das peças

            for(int l=0;l<3;l++){ //Percorre linhas

                for(int c=0;c<3;c++){ //Percorre colunas

                    if(indice==8){ //Se for a última peça não cria imagem
                        pecas[indice]=null; //Espaço vazio
                    }
                    else{

                        BufferedImage parte = img.getSubimage(c*largura, l*altura, largura, altura); //Corta um pedaço da imagem original
                        Image imgRedimensionada = parte.getScaledInstance(200, 200, Image.SCALE_SMOOTH); //Redimensiona a peça
                        pecas[indice] = new ImageIcon(imgRedimensionada); //Transforma em imagem que o swing consegue mostrar
                    }

                    indice++;
                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void desenhar(){

        getContentPane().removeAll(); //Apaga o tabuleiro antigo

        for(int i=0;i<9;i++){ //Percorre as 9 casas

            JLabel casa = new JLabel(); //Cria uma nova casa

            if(atual[i]!=-1) //Se não for vazio
                casa.setIcon(pecas[atual[i]]); //Coloca a imagem

            int posicao = i;

            casa.addMouseListener(new MouseAdapter() { //Evento de clique

                @Override
                public void mouseClicked(MouseEvent e) {

                    mover(posicao); //Quando clicar chama o método mover

                }

            });

            add(casa);

        }

        revalidate();
        repaint();

    }

    private void mover(int posicao){ //Recebe a posição clicada

        if(!adjacente(posicao,vazio)) //Se a peça não estiver perto do vazio não faz nada
            return;

        int temp=atual[posicao]; //Guarda peça clicada
        atual[posicao]=atual[vazio]; //Coloca vazio no lugar da peça
        atual[vazio]=temp; //Coloca peça no lugar do vazio

        vazio=posicao; //Atualiza posição do vazio

        desenhar(); //Redesenha

        if(venceu()){ //Verifica se terminou

            JOptionPane.showMessageDialog(this, "Parabéns! você conseguiu!");

        }

    }

    boolean adjacente(int a,int b){ //Verifica se a peça está ao lado do vazio

        int linhaA = a/3; //Transforma posição em linha e coluna
        int colunaA = a%3;

        int linhaB = b/3;
        int colunaB = b%3;

        return Math.abs(linhaA - linhaB)+Math.abs(colunaA - colunaB) == 1; //Calcula distância, se for 1 é vizinho

    }

    private boolean venceu(){ //Confere se está correto

        for(int i=0;i<9;i++){

            if(atual[i] != correto[i])
                return false; //Se alguma peça estiver errada não ganhou

        }

        return true;

    }

    public static void main(String[] args) {

        new QuebraCabeca(); //Cria a janela e inicia o jogo

    }

}