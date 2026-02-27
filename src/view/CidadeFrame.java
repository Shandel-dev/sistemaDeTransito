package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CidadeFrame extends JFrame{
	
	private static final String TITLE_WINDOW = "Sistema de Trânsito";
	
	private static JLabel lblButton;
	private static JButton btnTeste;
	
	public CidadeFrame() {
		super(TITLE_WINDOW);
		
		setLayout(new FlowLayout());
		
		lblButton = new JLabel("Exemplo de etiqueta");
		add(lblButton);
		
		btnTeste = new JButton("Botão");
		add(btnTeste);
	}
	
}
