/*
 * Classe PreIntroPanel
 * Abra uma JFrame
 * Pergunta o nome do usuario
 * Fecha a JFrame
 * Inicia classe IntroPanel
 */

package br.com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PreIntroPanel{
		
	private JFrame frame;
	
	private Dimension introDim; //Metodo que pega dimensoes de um componente
	
	public static IntroPanel introPanel; 
	
	public static PreIntroPanel preIntroPanel;
	
	public File file;
	
	public static String nome;
	
	//getter
	public String getNome(){
		return nome;
	}
	
	private void saveOpen(){
		frame.setVisible(false);
		introPanel  = new IntroPanel();
	}
	
	public PreIntroPanel() {
		//Cria JFrame e a localiza no centro da tela
		introDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("G2TA");
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setSize(570, 600);
		frame.setLocation(introDim.width / 2 - frame.getWidth() / 2,
						  introDim.height / 2 - frame.getHeight() / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 570, 100);
		frame.getContentPane().add(panel);
		
		JLabel jLabel1 = new JLabel("ESCREVA SEU NOME");  
	    jLabel1.setFont(new Font("Tohama", Font.PLAIN, 30));  
	    jLabel1.setBounds(0, 0, 150, 90);  
	    panel.add(jLabel1);
	    
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 150, 570, 100);
		frame.getContentPane().add(panel_1);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tohama", Font.PLAIN, 30));
		textField.setColumns(20);
		panel_1.add(textField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(210, 300, 150, 150);
		frame.getContentPane().add(panel_4);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setPreferredSize(new Dimension(150, 50));
		btnEnter.setBackground(Color.CYAN);
		btnEnter.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(e.getActionCommand().equals("Enter")){
							nome = textField.getText();
							saveOpen();
						}
							
					}
				}
		);
		panel_4.add(btnEnter);
	}
}
