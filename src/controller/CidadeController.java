package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Cidade;
import model.TransitoServices;
import view.CidadeFrame;
import view.CidadeJOption;
import view.CidadeRegister;

public class CidadeController {

	private static int QTD_CIDADES = 5;
	
	private Cidade[] cidades = new Cidade[QTD_CIDADES];
	private TransitoServices services = new TransitoServices();
	private boolean isDecreasing = false;

	public CidadeController(){
		
		for(int i = 0; i < cidades.length; i++) cidades[i] = new Cidade();
		
		try {
			services.readCities(cidades);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CidadeJOption.errorMsg("ERRO AO FAZER A LEITURA DE DADOS NO ARQUIVO!");
		} catch (NumberFormatException e) {
			// TODO: handle exception
			CidadeJOption.errorMsg(e.getMessage());
		}
		
		inicializeFrame();
		//inicializeJOptionPane();
	}

	public void inicializeFrame() {
		//inicializa e aplica eventos
		CidadeFrame window = new CidadeFrame(cidades);
		CidadeRegister form = new CidadeRegister(window.WIDTH, window.HEIGHT);
		
		form.btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form.setVisible(false);
				window.setVisible(true);
			}
		});
		
		window.btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.setVisible(false);
				form.setVisible(true);
			}
		});
		
		window.btnAplicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int minimo = Integer.parseInt(window.campoMin.getText());
					int maximo = Integer.parseInt(window.campoMax.getText());
					JOptionPane.showMessageDialog(null, String.format("Mínimo: %d%nMáximo: %d", minimo, maximo));
					
				}catch (NumberFormatException n) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		window.btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.campoMin.setText("");
				window.campoMax.setText("");
			}
		});
		
		
	}

	public void inicializeJOptionPane() {

		int opc;
		do {
			opc = CidadeJOption.menuEstatistica();

			switch (opc) {
			case 0:
				cidades = CidadeJOption.obterDados(QTD_CIDADES);

				try {
					services.saveCities(cidades);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CidadeJOption.errorMsg(e.getMessage());
				}
				break;
			case 2:
				Cidade[] cidadesCopia = services.queryBySort(cidades, isDecreasing);
				isDecreasing = !isDecreasing;
				CidadeJOption.showCitiesBySort(cidadesCopia);
				break;
			case 3:
				Cidade[] cidadesMaiorQueMedia = services.queryByBiggerThanAvg(cidades);
				CidadeJOption.showCitiesBySort(cidadesMaiorQueMedia);
				break;
			case 4:
				CidadeJOption.exibirDados(cidades);
			default:
				break;
			}
		} while (!(opc < 0));
	}

}
