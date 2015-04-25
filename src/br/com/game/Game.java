/*
 * Classe Game
 * Abre uma JFrame
 * Contem ActionListener e KeyListener
 * Contem a logica de funcionamento do jogo
 * Renderizado pela classe Render
 */


package br.com.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements ActionListener, KeyListener {
			
	public boolean inimigo[][] = new boolean[7][7];
	
	public boolean tiro[][] = new boolean[7][7];
	
	public boolean acerto[][] = new boolean[7][7];
	
	public boolean jogador[] = new boolean[7];
	
	public boolean batida[] = new boolean[7];
	
    public static Game game;
    
    public static PreIntroPanel preIntroPanel;

    public Render render;
     
    public Timer timer = new Timer(200,this);
           
    public static final int LEFT = 2, RIGHT = 3, PARADO=4, DONTMOVE=5, SCALE = 80;
           
    public int direction = PARADO, time, nivelJogador, pontuacao;
    
    public Random random;
   
    public boolean over = false, pausa = false, atira, sair;
   
    public static JFrame jf;
   
    public Dimension dim;
    
    public Game(int nivelJogadorSelecionado) {
    	nivelJogador = nivelJogadorSelecionado;
    	dim = Toolkit.getDefaultToolkit().getScreenSize();
        jf = new JFrame("G2TA");
        jf.setVisible(true);
        jf.setSize(570, 600);
        jf.setResizable(false);
        jf.setLocation(dim.width / 2 - jf.getWidth() / 2,
                       dim.height / 2 - jf.getHeight() / 2);
        jf.add(render = new Render());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.addKeyListener(this);
        startGame();
    }
    
    public void startGame () {
    	for(int i=0; i<jogador.length; i++){
    		jogador[i] = false;
    	}
    	pontuacao=0;
    	over = false;
        pausa = false;
        atira = false;
        time = 0;
        direction = PARADO;
        jogador[3] = true;
        random = new Random();
        timer.start();
        
    }

	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		 
        if(i == KeyEvent.VK_LEFT){
                direction = LEFT;
        }

        if( i == KeyEvent.VK_RIGHT){
                direction = RIGHT;
        }
        
        if(i == KeyEvent.VK_SPACE){
    		atira = true;
        }

        if(i == KeyEvent.VK_P){
        	if (over){
        		startGame();
        	}
        	else{
        		pausa = !pausa;
        	}
        } 
        
        if(i == KeyEvent.VK_ENTER){
        	if(over){
        		sair = true;
        	}
        }
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		render.repaint();
        
		if(direction != PARADO && !over && !pausa){
			time++;
			
			limpaAcerto();
			
			limpaBatida();
			
			movimentaJogador();

			verificaColisao();

			verificaExplosaoAsteroid();
						
			movimentaInimigo();

			verificaColisao();

			verificaExplosaoAsteroid();
						
			movimentaTiro();
			
			verificaColisao();

			verificaExplosaoAsteroid();
			
        }

	}
	
	public void movimentaJogador(){
		
		if (direction == LEFT)
		{
			for(int i=0; i<jogador.length; i++){
				if(jogador[i]){
					if(i!=0){
						jogador[i-1] = true;
						jogador[i] = false;
						pontuacao++;
					}
					if(i==0){
						direction = DONTMOVE;
					}
				}
			}
		}

		if (direction == RIGHT)
		{
			for(int i=jogador.length-1; i>=0; i--){
				if(jogador[i]){
					if(i!=6){
						jogador[i+1] = true;
						jogador[i] = false;
						pontuacao++;
					}
					if(i==6){
						direction = DONTMOVE;
					}
				}
			}
		}

	}
	
	public void movimentaInimigo(){

		if(time%nivelJogador==0){
			if(nivelJogador==12){
				inimigo[random.nextInt(7)][0] = true;
			}
			if(nivelJogador==10){
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
			}
			if(nivelJogador==7){
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
			}
			if(nivelJogador==3){
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
				inimigo[random.nextInt(7)][0] = true;
			}			
		
		}

		for(int i=6; i>=0; i--){
			for(int j=6; j>=0; j--){
				if(inimigo[i][j] && j!=6){
					inimigo[i][j+1] = true;		
					inimigo[i][j] = false;
				}
				if(j==6){
					inimigo[i][j] = false;
				}
			}
		}	

	}
	
	public void movimentaTiro(){
		
		if(atira){
			for(int i=0; i<jogador.length; i++){
				if(jogador[i]){
					tiro[i][5] = true;
				}
			}
			
			atira = false;
		}

		for(int i=0; i<tiro.length; i++){
			for(int j=0; j<tiro[i].length; j++){
				if(tiro[i][j] && j!=0){
					tiro[i][j-1] = true;
					tiro[i][j] = false;
				}
				if(j==0){
					tiro[i][j]=false;
				}
			}
		}



	}
	
	public void verificaColisao(){
		
		for(int i=0; i<jogador.length; i++){
			if(jogador[i] && inimigo[i][5]){
				over = true;
			}
		}
	}

	public void verificaExplosaoAsteroid(){

		for(int i=0; i<inimigo.length; i++){
			for(int j=0; j<inimigo[i].length; j++){
				if(inimigo[i][j] && tiro[i][j]){
					inimigo[i][j] = false;
					tiro[i][j] = false;
					acerto[i][j] = true;
				}
			}
		}
	}

	public void limpaBatida(){

		for(int i=0; i<batida.length; i++){
			batida[i] = false;
		}

	}

	public void limpaAcerto(){

		for(int i=0; i<acerto.length; i++){
			for(int j=0; j<acerto[i].length; j++){
				acerto[i][j] = false;
			}
		}

	}

}
