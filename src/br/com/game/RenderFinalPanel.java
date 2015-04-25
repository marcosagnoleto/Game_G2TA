/*
 * Classe RenderFinalPanel
 * Renderiza classe FinalPanel
 * Contem logica de exibicao de Ranking
 * Espera fechar JFrame da classe FinalPanel para sair do programa
 */

package br.com.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

@SuppressWarnings("serial") 

public class RenderFinalPanel extends JPanel{
		
	private ArrayList<String> RankingNomes = new ArrayList<String>();
	private ArrayList<Integer> RankingPontos = new ArrayList<Integer>();

	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
	
	   	super.paint(g);

		Image fundo = Toolkit.getDefaultToolkit().getImage("Imagem/fundoFinalPanel.jpg");
		g2.drawImage(fundo, 0, 0, 590, 610, this);
		g2.finalize();
		
		//isso aqui completa as ArrayList com os textos do txt
		CompletaArray completaArray = new CompletaArray();		
		try {
			RankingNomes = completaArray.retornaListaNomes();
			RankingPontos = completaArray.retornaListaPontos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//isso aqui organiza as ArrayList em ordem decescente
		for(int i=0; i<RankingPontos.size(); i++){
			for(int j=i+1; j<RankingPontos.size(); j++){
				if(RankingPontos.get(i)<RankingPontos.get(j)){
					Collections.swap(RankingNomes, i, j);
					Collections.swap(RankingPontos, i, j);
				}
			}
		}
		
		Game game = Game.game;
		String nivel = null;
		if(game.nivelJogador == 12) nivel = "FACIL";
		if(game.nivelJogador == 10) nivel = "MEDIO";
		if(game.nivelJogador == 7) nivel = "DIFICIL";
		if(game.nivelJogador == 3) nivel = "INSANO";
		
		
		g.setFont(new Font("default", Font.BOLD, 30));
		g.drawString("RANKING NIVEL " + nivel, 120, 30);
			
		
		g.setFont(new Font("default", Font.BOLD, 20));
		g.drawString("NOME", 120, 100);
		
		g.setFont(new Font("default", Font.BOLD, 20));
		g.drawString("PONTUACAO", 350, 100);
		
		int j=120;
		for(int i=0; i<RankingNomes.size(); i++){
			g.setFont(new Font("default", Font.BOLD, 20));
			g.drawString(RankingNomes.get(i), 120, j);
			j=j+20;
		}	
		
		int k=120;
		for(int i=0; i<RankingPontos.size(); i++){
			g.setFont(new Font("default", Font.BOLD, 20));
			g.drawString("" + RankingPontos.get(i), 390, k);
			k=k+20;
		}	
		
	}
	
}
