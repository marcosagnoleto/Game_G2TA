/*
 * Classe CompletaArray
 * Contem a logica para tirar os nomes do txt e poe na arrayList
 */

package br.com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CompletaArray {
	
	public CompletaArray(){
		
	}
	
	public ArrayList<String> retornaListaNomes() throws IOException {
		
		ArrayList<String> Ranking = new ArrayList<String>();
		
		BufferedReader reader = new BufferedReader(new FileReader("Dados/Ranking.txt"));
		BufferedReader br = new BufferedReader(new FileReader("Dados/Ranking.txt"));
		
		String[] linhaVetor = null;
		
		int nivelLido=0;
		
		Game game = Game.game;
		
		while ((reader.readLine()) != null) {
		   			
			linhaVetor = br.readLine().split("-");
			
			String jogadorLido = linhaVetor[1];
			
			
			if(linhaVetor[0].equals("Facil")) nivelLido = 12;
			if(linhaVetor[0].equals("Medio")) nivelLido = 10;
			if(linhaVetor[0].equals("Dificil")) nivelLido = 7;
			if(linhaVetor[0].equals("Insano")) nivelLido = 3;
							
			if(game.nivelJogador == nivelLido){
				Ranking.add(jogadorLido);
			}
			
		}
		
		reader.close();
		br.close();
		
		return Ranking;
	}
	
	public ArrayList<Integer> retornaListaPontos() throws IOException {
		
		ArrayList<Integer> Ranking = new ArrayList<Integer>();
		
		BufferedReader reader = new BufferedReader(new FileReader("Dados/Ranking.txt"));
		BufferedReader br = new BufferedReader(new FileReader("Dados/Ranking.txt"));
		
		String[] linhaVetor = null;
		
		int nivelLido=0;
		
		Game game = Game.game;
		
		while ((reader.readLine()) != null) {
		   			
			linhaVetor = br.readLine().split("-");
			
			String jogadorLido = linhaVetor[2];
			
			
			if(linhaVetor[0].equals("Facil")) nivelLido = 12;
			if(linhaVetor[0].equals("Medio")) nivelLido = 10;
			if(linhaVetor[0].equals("Dificil")) nivelLido = 7;
			if(linhaVetor[0].equals("Insano")) nivelLido = 3;
							
			if(game.nivelJogador == nivelLido){
				Ranking.add(Integer.parseInt(jogadorLido));
			}
			
		}
		
		reader.close();
		br.close();
		
		return Ranking;
	}

}
