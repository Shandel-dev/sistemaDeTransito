package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CidadeRegister extends JFrame{
	
	JTextField inputCod;
	JTextField inputName;
	JTextField inputAcidentes;
	
	JButton btnPost;
	JButton btnClear;
	public JButton btnBack;
	
	public CidadeRegister(int width, int height) {
		configurarJanela(width, height);
		containerMain();
	}
	
	private void configurarJanela(int w, int h) {
		setTitle("Cadastrar Cidade");
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	private void containerMain() {		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//ASIDE
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(asidePanel(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 2;
		gbc.weighty = 1;
		add(containerSections(), gbc);
	}
	
	private JPanel asidePanel() {
		JPanel aside = new JPanel();
		aside.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		JLabel bigLetter = new JLabel("S");
		bigLetter.setFont(new Font("Monospaced", 1, 100));
		
		aside.add(bigLetter);
		return aside;
	}
	
	private JPanel containerSections() {
		JPanel ctnSection = new JPanel();
				
		ctnSection.setLayout(new GridLayout(2, 1, 10, 10));
		//ctnSection.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		ctnSection.setBorder(new EmptyBorder(0, 60, 0, 60));
		
		ctnSection.add(sectionInputs());
		ctnSection.add(footer());
		
		return ctnSection;
	}
	
	private JPanel sectionInputs() {
		JPanel forms = new JPanel();
		
		forms.setLayout(new BoxLayout(forms, BoxLayout.Y_AXIS));
		
		String[] lblContent = {"Código: ", "Nome da cidade: ", "Quantidade de acidentes: "};
		
		JPanel span1 = new JPanel();
		span1.setLayout(new GridLayout(1, 2, 0, 10));
		JLabel lblCod = new JLabel("Código: ");
		inputCod = new JTextField();
		span1.add(lblCod);
		span1.add(inputCod);
		
		JPanel span2 = new JPanel();
		span2.setLayout(new GridLayout(1, 2, 0, 10));
		JLabel lblName = new JLabel("Nome da cidade: ");
		inputName = new JTextField();
		span2.add(lblName);
		span2.add(inputName);	
		
		JPanel span3 = new JPanel();
		span3.setLayout(new GridLayout(1, 2, 0, 10));
		JLabel lblAcidentes = new JLabel("Acidentes registrados: ");
		inputAcidentes = new JTextField();
		span3.add(lblAcidentes);
		span3.add(inputAcidentes);
		
		forms.add(span1);
		forms.add(span2);
		forms.add(span3);
		return forms;
	}
	
	private JPanel footer() {
		JPanel footer = new JPanel();
		footer.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnPost = new JButton("Registrar");
		btnClear = new JButton("Limpar campos");
		btnBack = new JButton("<- Voltar");
		
		footer.add(btnPost);
		footer.add(btnClear);
		footer.add(btnBack);
		
		return footer;
	}
}
