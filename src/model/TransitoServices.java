package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class TransitoServices {

	public static final String FILE_NAME = "ArquivoEstatistica.txt";
	
	//CRIAR
	public void saveCities(Cidade[] cidades) throws IOException {
		BufferedWriter gravar = new BufferedWriter(new FileWriter(FILE_NAME));
		
		for(Cidade city : cidades) {
			gravar.write(Integer.toString(city.getCodigo()));
			gravar.newLine();
			
			gravar.write(city.getNome());
			gravar.newLine();
			
			gravar.write(Integer.toString(city.getQtdAcidentes()));
			gravar.newLine();			
		}
		
		
		gravar.close();
		
	}
	
	//LER
	public void readCities(Cidade[] cidade) throws IOException {
		BufferedReader ler = new BufferedReader(new FileReader(FILE_NAME));
		
		for(int i = 0; i < cidade.length; i++) {
			
			cidade[i].setCodigo(Integer.parseInt(ler.readLine()));
			cidade[i].setNome(ler.readLine());
			cidade[i].setQtdAcidentes(Integer.parseInt(ler.readLine()));
		}
		
		ler.close();
		
	}
	
	
	public Cidade[] queryByInterval(Cidade[] cidade, int init, int end) {
		ArrayList<Cidade> cidadesFiltradas = new ArrayList<Cidade>();
		
		for(int i = 0; i < cidade.length; i++) {
			if(cidade[i].getQtdAcidentes() > init && cidade[i].getQtdAcidentes() < end) cidadesFiltradas.add(cidade[i]);
		}
		
		//converte arraylist para um array de cidades filtradas
		return (Cidade[]) cidadesFiltradas.toArray();
	}
	
	public Cidade[] queryBySort(Cidade[] cidade, boolean isDecreasing) {
		
		Cidade[] cidadesSort = Arrays.copyOf(cidade, cidade.length);
		quickSort(cidadesSort, 0, cidadesSort.length-1);
		
		if(isDecreasing) inverterArray(cidadesSort);
		
		return cidadesSort;
	}
	
	public static Cidade[] queryBybiggerThanAvg(Cidade[] cidades) {
		int total = 0;
		ArrayList<Cidade> filteredCities = new ArrayList<Cidade>();
		
		for(Cidade city : cidades) {
			total += city.getQtdAcidentes();
		}
		
		double average = (double) total / cidades.length;
		
		for(Cidade city : cidades) if(city.getQtdAcidentes() > average) filteredCities.add(city);
		
		return (Cidade[]) filteredCities.toArray();
		
	}
	
	//ordenação crescente
	private void quickSort(Cidade[] array, int inicio, int fim) {
	    if (inicio < fim) {
	        int indicePivo = particionar(array, inicio, fim);
	        quickSort(array, inicio, indicePivo - 1);
	        quickSort(array, indicePivo + 1, fim);
	    }
	}
	
	private int particionar(Cidade[] array, int inicio, int fim) {

	    Cidade pivo = array[fim];
	    int i = inicio - 1;

	    for (int j = inicio; j < fim; j++) {
	        if (array[j].getQtdAcidentes() < pivo.getQtdAcidentes()) {
	            i++;
	            trocar(array, i, j);
	        }
	    }

	    trocar(array, i + 1, fim);
	    return i + 1;
	}
	
	private void trocar(Cidade[] array, int i, int j) {
	    Cidade temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	private void inverterArray(Cidade[] array) {
	    int inicio = 0;
	    int fim = array.length - 1;

	    while (inicio < fim) {
	        trocar(array, inicio, fim);
	        inicio++;
	        fim--;
	    }
	}
	
	
	
	
}
