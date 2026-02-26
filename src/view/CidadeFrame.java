package view;

import javax.swing.JFrame;

public class CidadeFrame extends JFrame{
	
	private static final String TITLE_WINDOW = "Sistema de Trânsito";
	
	public CidadeFrame() {
		setTitle(TITLE_WINDOW);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
}
