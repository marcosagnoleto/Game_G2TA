/*
 * Classe Render
 * Renderiza classe Game
 * Fecha a JFrame da Game
 * Inicia classe Save
 * Utiliza metodo (alteraRanking) da classe Save
 * Inicia classe FinalPanel
 */

package br.com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JPanel;


@SuppressWarnings("serial") //Suprime o warning de que a classe eh serializable e portanto deveria definir um SerialVersionUID

public class Render extends JPanel {
	
	public FinalPanel finalPanel;
	
	public void paint (Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
				
		Game game = Game.game;
		
		Image fundo = Toolkit.getDefaultToolkit().getImage("Imagem/fundo.jpg");
		g2.drawImage(fundo, 0, 0, 590, 610, this);
		g2.finalize();
		
		if(!game.over){
			
			String string1 = "Sua Pontuaçao é:  ";
			g.setColor(Color.white);
			g.setFont(new Font("default", Font.BOLD, 20));
			g.drawString(PreIntroPanel.nome +" "+ string1 + game.pontuacao, 10, 20);
		

			Image nave= Toolkit.getDefaultToolkit().getImage("Imagem/nave.png");
            for(int i=0; i<game.jogador.length; i++){
            	if(game.jogador[i]){
            		g2.drawImage(nave, i * Game.SCALE, 5 * Game.SCALE, Game.SCALE, Game.SCALE,this);
            	}
            }
            g2.finalize();
            
            Image asteroid = Toolkit.getDefaultToolkit().getImage("Imagem/asteroid.png");
            for(int i=0; i<game.inimigo.length; i++){
            	for(int j=0; j<game.inimigo.length; j++){
            		if(game.inimigo[i][j]){
            			g2.drawImage(asteroid, i * Game.SCALE, j * Game.SCALE, Game.SCALE, Game.SCALE,this);
            		}
	            }
            }
            g2.finalize();
            
            Image bala = Toolkit.getDefaultToolkit().getImage("Imagem/bala.png");
            for(int i=0; i<game.tiro.length; i++){
            	for(int j=0; j<game.tiro.length; j++){
            		if(game.tiro[i][j]){
            			g2.drawImage(bala, i * Game.SCALE + 20, j * Game.SCALE, Game.SCALE/2, Game.SCALE/2,this);
            		}
            	}
            }
            g2.finalize();

            Image destruir = Toolkit.getDefaultToolkit().getImage("Imagem/destruir.png");
            for(int i=0; i<game.acerto.length; i++){
            	for(int j=0; j<game.acerto.length; j++){
            		if(game.acerto[i][j]){
            			g2.drawImage(destruir, i * Game.SCALE, j * Game.SCALE, Game.SCALE, Game.SCALE,this);
            		}
            	}
            }
            g2.finalize();
		}
		
		if(game.over){
			Image explosao = Toolkit.getDefaultToolkit().getImage("Imagem/explosao.gif");
			for(int i=0; i<game.jogador.length; i++){
				if(game.jogador[i]){
					g2.drawImage(explosao, i * Game.SCALE, 5 * Game.SCALE, Game.SCALE, Game.SCALE,this);
				}
			}
			g2.finalize();
			
			String string = "YOU LOSE";
			String string1 = "(Precione Enter)";
			g.setColor(Color.white);
			g.setFont(new Font("default", Font.BOLD, 40));
			g.drawString(string, (int) ((getWidth() / 2) - string.length() * 12), (int) game.dim.getHeight()/3);
			
			g.setColor(Color.white);
			g.setFont(new Font("default", Font.BOLD, 10));
			g.drawString(string1, (int) ((getWidth() / 2) - string1.length() * 2), (((int) game.dim.getHeight()/3) + 10));
			
			if(game.sair){
				Save save = new Save(PreIntroPanel.nome, game.pontuacao, game.nivelJogador);
				try {
					save.alteraRanking();
				} catch (IOException e) {
					e.printStackTrace();
				}			
				Game.jf.setVisible(false);
				finalPanel = new FinalPanel();
			}
		}
	}
}
