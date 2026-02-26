package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CidadeServices {

	public static final String FILE_NAME = "ArquivoEstatistica.txt";
	
	public Cidade fSalvarCidade(Cidade cidade) throws IOException {
		BufferedWriter gravar = new BufferedWriter(new FileWriter(FILE_NAME));
		
		gravar.write(Integer.toString(cidade.getCodigo()));
		gravar.newLine();
		
		gravar.write(cidade.getNome());
		gravar.newLine();
		
		gravar.write(Integer.toString(cidade.getQtdAcidentes()));
		gravar.newLine();
		
		gravar.close();
		
		return cidade;
	}
	
	public void fLerCidades(Cidade[] cidade) throws IOException {
		BufferedReader ler = new BufferedReader(new FileReader(FILE_NAME));
		
		for(int i = 0; i < cidade.length; i++) {
			cidade[i] = new Cidade();
			
			cidade[i].setCodigo(Integer.parseInt(ler.readLine()));
			cidade[i].setNome(ler.readLine());
			cidade[i].setQtdAcidentes(Integer.parseInt(ler.readLine()));
		}
		
		ler.close();
		
	}
	
	public Cidade[] pQtdAcidentes(Cidade[] cidade) {
		ArrayList<Cidade> cidadesFiltradas = new ArrayList<Cidade>();
		
		for(int i = 0; i < cidade.length; i++) {
			if(cidade[i].getQtdAcidentes() > 100 && cidade[i].getQtdAcidentes() < 500) cidadesFiltradas.add(cidade[i]);
		}
		
		//converte arraylist para um array de cidades filtradas
		return (Cidade[]) cidadesFiltradas.toArray();
	}
	
}
