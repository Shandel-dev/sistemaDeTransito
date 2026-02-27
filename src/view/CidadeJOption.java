package view;

import javax.swing.JOptionPane;

import model.Cidade;

public class CidadeJOption {

	private static String TITLE_WINDOW = "SISTEMA DE TRÂNSITO | FATEC-ZL";

	public static int menuEstatistica() {
		String[] options = {"Cadastro Estatística", "Consulta por qtd. de acidentes", "Consulta por estatísticas de acidentes", "Acidentes acima da média das 10 cidades", "Ver dados"};
		int opc = 0;
		opc = JOptionPane.showOptionDialog(null, "MENU ESTATÍSTICA", TITLE_WINDOW, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

		return opc;
	}
	
	public static Cidade[] obterDados(int qtdCidades) {
		Cidade[] cidades = new Cidade[qtdCidades];

		for (int i = 0; i < cidades.length; i++) {
			cidades[i] = new Cidade();

			boolean isValid = false;

			do {
				try {
					cidades[i].setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null,
							(i + 1) + ". Insira o código: ", TITLE_WINDOW, JOptionPane.QUESTION_MESSAGE)));
					cidades[i].setNome(JOptionPane.showInputDialog(null, (i + 1) + ". Informe o nome: ", TITLE_WINDOW,
							JOptionPane.QUESTION_MESSAGE));
					cidades[i].setQtdAcidentes(Integer.parseInt(JOptionPane.showInputDialog(null,
							(i + 1) + ". Informe a quantidade de acidentes ocorridos: ", TITLE_WINDOW,
							JOptionPane.QUESTION_MESSAGE)));

					isValid = true;
				} catch (NumberFormatException e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Entrada da dados inválida!", TITLE_WINDOW, JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage(), TITLE_WINDOW, JOptionPane.ERROR_MESSAGE);
				}
			} while (!isValid);

		}

		return cidades;
	}
	
	public static void exibirDados(Cidade[] cidades) {
		String[] cityReports = new String[cidades.length];
		
		for(int i = 0; i < cidades.length; i++) {
			cityReports[i] = String.format("Código: %d%nNome: %s%nQtd. de Acidentes: %d", cidades[i].getCodigo(), cidades[i].getNome(), cidades[i].getQtdAcidentes());
		}
		
		for(String report : cityReports) JOptionPane.showMessageDialog(null, report);;
	}
	
	public static void errorMsg(String msgError) {
		JOptionPane.showMessageDialog(null, msgError, TITLE_WINDOW, JOptionPane.ERROR_MESSAGE);
	}
}
