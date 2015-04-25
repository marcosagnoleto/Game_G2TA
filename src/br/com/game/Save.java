/*
 * Classe Save
 * Contem a logica de salvamento em txt
 */

package br.com.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	
	private String nome;
	
	private int pontuacao;
		
	private String nivelJogador;
	
	
	public Save(String nome, int pontuacao, int nivelJogador){
		this.nome = nome;
		this.pontuacao = pontuacao;
		if(nivelJogador == 12)	this.nivelJogador = "Facil";
		if(nivelJogador == 10)	this.nivelJogador = "Medio";
		if(nivelJogador == 7)	this.nivelJogador = "Dificil";
		if(nivelJogador == 3)	this.nivelJogador = "Insano";						
	}
	
	public void alteraRanking() throws IOException {
	    String arquivo = "Dados/Ranking.txt";
	    String arquivoTmp = "Dados/Ranking-tmp.txt";

	    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
	    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

	    writer.write(nivelJogador + "-" + nome + "-" + pontuacao);
	    
	    String linha;
	    while ((linha = reader.readLine()) != null) {
	    	writer.newLine();
	        writer.write(linha);
	    }

	    writer.close();        
	    reader.close();

	    File file = new File("Dados/Ranking.txt");  
	    file.delete();
	    
	    File file1 = new File("Dados/Ranking-tmp.txt");  
	    file1.renameTo(new File("Dados/Ranking.txt"));
	    
	}

}
