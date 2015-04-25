/*
 * Classe FinalPanel
 * Classe Game
 * Abre uma JFrame
 * Renderizado pela classe RenderFinalPanel
 */

package br.com.game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FinalPanel {
	
	private JFrame frame;
	
	private Dimension finalDim;
	
	public FinalPanel(){
		
		finalDim = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("G2TA");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(570, 600);
        frame.setLocation(finalDim.width / 2 - frame.getWidth() / 2,
                          finalDim.height / 2 - frame.getHeight() / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RenderFinalPanel());
        frame.getContentPane().validate();
        frame.getContentPane().repaint();    
		
	}
}
