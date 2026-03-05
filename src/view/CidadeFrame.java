package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cidade;

public class CidadeFrame extends JFrame{
	
	private static final String TITLE_WINDOW = "Sistema de Trânsito";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	public JButton btnCadastrar;
	public JButton btnAplicar;
	public JButton btnLimpar;
	public JTextField campoMin;
	public JTextField campoMax;
	
	
	public CidadeFrame(Cidade[] cidades) {
		configurarJanela();
		containerMain(cidades);
		setVisible(true);
	}
	
	private void configurarJanela() {
        setTitle(TITLE_WINDOW);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
    }
	
	private void containerMain(Cidade[] cidades) {
		GridBagConstraints gbc = new GridBagConstraints();

        // HEADER
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(criarHeader(), gbc);

        // SIDEBAR
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(criarSidebar(), gbc);

        // ÁREA PRINCIPAL
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(criarAreaCards(cidades), gbc);
    }
	
	private JPanel criarHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.setBorder(new EmptyBorder(10,10,10,10));

        JLabel titulo = new JLabel("Sistema de Monitoramento de Cidades");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        header.add(titulo);

        return header;
    }
	
	private JPanel criarSidebar() {

		JPanel sidebar = new JPanel(new GridLayout(0,1,0,10));
	    sidebar.setBorder(new EmptyBorder(10,10,100,10));
	    
	    btnCadastrar = new JButton("Cadastrar cidades");

	    JSeparator divisor = new JSeparator();

	    JLabel lblFiltros = new JLabel("Filtros");

	    sidebar.add(btnCadastrar);
	    sidebar.add(divisor);
	    sidebar.add(lblFiltros);
	    sidebar.add(criarPainelIntervalo());
	    sidebar.add(criarPainelBotoesFiltro());

	    return sidebar;
    }
	
	private JPanel criarPainelIntervalo() {

	    JPanel painel = new JPanel(new GridLayout(2,2,5,5));
	    painel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // borda visível

	    
	    painel.add(new JLabel("MIN"));
	    painel.add(new JLabel("MAX"));

	    campoMin = new JTextField();
	    campoMax = new JTextField();

	    painel.add(campoMin);
	    painel.add(campoMax);

	    return painel;
	}
	
	private JPanel criarPainelBotoesFiltro() {

	    JPanel painel = new JPanel(new GridLayout(1,2,5,0));

	    btnAplicar = new JButton("Aplicar");
	    btnLimpar = new JButton("Limpar");
	    
	    
	    
	    painel.add(btnAplicar);
	    painel.add(btnLimpar);

	    return painel;
	}
		
	private JScrollPane criarAreaCards(Cidade[] cidades) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(new EmptyBorder(10, 10, 10, 10));

        for (Cidade cidade : cidades) {
            container.add(criarCardCidade(cidade));
            container.add(Box.createVerticalStrut(10));
        }

        return new JScrollPane(container);
    }
	
	private JPanel criarCardCidade(Cidade cidade) {

        JPanel card = new JPanel();
        card.setLayout(new GridLayout(3,1));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.setBackground(Color.WHITE);

        JLabel codigo = new JLabel("Código: " + cidade.getCodigo());
        JLabel nome = new JLabel("Cidade: " + cidade.getNome());
        JLabel acidentes = new JLabel("Acidentes: " + cidade.getQtdAcidentes());

        codigo.setBorder(new EmptyBorder(5,10,5,10));
        nome.setBorder(new EmptyBorder(5,10,5,10));
        acidentes.setBorder(new EmptyBorder(5,10,5,10));

        card.add(codigo);
        card.add(nome);
        card.add(acidentes);

        return card;
    }
	
}
