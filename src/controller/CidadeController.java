package controller;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Cidade;
import model.CidadeServices;
import view.CidadeFrame;
import view.CidadeJOption;

public class CidadeController {

	private static int QTD_CIDADES = 3;
	
	private Cidade[] cidades = new Cidade[QTD_CIDADES];
	private CidadeServices services = new CidadeServices();

	public CidadeController(){
		
		for(int i = 0; i < cidades.length; i++) cidades[i] = new Cidade();
		
		try {
			services.fLerCidades(cidades);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CidadeJOption.errorMsg("ERRO AO FAZER A LEITURA DE DADOS NO ARQUIVO!");
		} catch (NumberFormatException e) {
			// TODO: handle exception
			CidadeJOption.errorMsg(e.getMessage());
		}
		
		//inicializeFrame();
		inicializeJOptionPane();
	}

	public void inicializeFrame() {
		CidadeFrame window = new CidadeFrame();

		window.setVisible(true);
		window.setSize(800, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	}

	public void inicializeJOptionPane() {

		int opc;
		do {
			opc = CidadeJOption.menuEstatistica();

			switch (opc) {
			case 0:
				cidades = CidadeJOption.obterDados(QTD_CIDADES);

				try {
					services.fSalvarCidade(cidades);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CidadeJOption.errorMsg(e.getMessage());
				}
				break;

			case 4:
				CidadeJOption.exibirDados(cidades);
				break;
			default:
				break;
			}
		} while (!(opc < 0));
	}

}
