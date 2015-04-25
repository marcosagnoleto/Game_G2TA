/*
 * Classe IntroPanel
 * Abre uma JFrame
 * Pergunta o nivel que o usuario quer jogar
 * Fecha a JFrame
 * Inicia classe Game
 */


package br.com.game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class IntroPanel extends JInternalFrame {
	
	//Serializa classe
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	private Dimension introDim;
	
	
	public void playGameFacil(){
		frame.setVisible(false);
		Game.game = new Game(12);
	}
	public void playGameMedio(){
		frame.setVisible(false);
		Game.game = new Game(10);
	}
	public void playGameDificil(){
		frame.setVisible(false);
		Game.game = new Game(7);
	}
	public void playGameInsano(){
		frame.setVisible(false);
		Game.game = new Game(3);
	}
	


	public IntroPanel() {
		introDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("G2TA");
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setSize(570, 600);
		frame.setLocation(introDim.width / 2 - frame.getWidth() / 2,
						  introDim.height / 2 - frame.getHeight() / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(0, 0, 570, 50);
		frame.getContentPane().add(panel_3);
		
		JLabel jLabel1 = new JLabel("SELECIONE O SEU NÍVEL");  
	    jLabel1.setFont(new Font("Tohama", Font.PLAIN, 40));  
	    jLabel1.setBounds(0, 0, 150, 50);  
	    panel_3.add(jLabel1);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(210, 134, 150, 50);
		frame.getContentPane().add(panel);
		
		JButton btnFacil = new JButton("Facil");
		btnFacil.setPreferredSize(new Dimension(150, 40));
		btnFacil.setBackground(Color.CYAN);
		btnFacil.setForeground(Color.BLACK);
		btnFacil.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(e.getActionCommand().equals("Facil"))
							playGameFacil();
					}
				}
		);
		panel.add(btnFacil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(210, 195, 150, 50);
		frame.getContentPane().add(panel_1);
		
		JButton btnMdio = new JButton("Medio");
		btnMdio.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(e.getActionCommand().equals("Medio"))
							playGameMedio();
					}
				}
		);
		btnMdio.setPreferredSize(new Dimension(150, 40));
		btnMdio.setBackground(Color.CYAN);
		btnMdio.setForeground(Color.BLACK);
		panel_1.add(btnMdio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(210, 256, 150, 50);
		frame.getContentPane().add(panel_2);
		
		JButton btnDifcil = new JButton("Dificil");
		btnDifcil.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(e.getActionCommand().equals("Dificil"))
							playGameDificil();
					}
				}
		);
		btnDifcil.setPreferredSize(new Dimension(150, 40));
		btnDifcil.setBackground(Color.CYAN);
		btnDifcil.setForeground(Color.BLACK);
		panel_2.add(btnDifcil);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(210, 317, 150, 50);
		frame.getContentPane().add(panel_4);
		
		JButton btnInsano = new JButton("Insano");
		btnInsano.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(e.getActionCommand().equals("Insano"))
							playGameInsano();
					}
				}
		);
		btnInsano.setPreferredSize(new Dimension(150, 40));
		btnInsano.setBackground(Color.CYAN);
		btnInsano.setForeground(Color.BLACK);
		panel_4.add(btnInsano);
		
		
		
		
	}
}
