package model;

public class Cidade {
	private int codigo;
	private String nome;
	private int qtdAcidentes;
	
	public Cidade() {
		this(0, "", 0);
	}
	
	public Cidade(int codigo, String nome, int qtdAcidentes) {
		this.codigo = codigo;
		this.nome = nome;
		this.qtdAcidentes = qtdAcidentes;
	}

	public int getCodigo() {		
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo < 0) throw new IllegalArgumentException("Código não pode ser negativo!");
		
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdAcidentes() {
		return qtdAcidentes;
	}

	public void setQtdAcidentes(int qtdAcidentes) {
		if(qtdAcidentes < 0) throw new IllegalArgumentException("A quantidade de acidentes não pode ser negativo!");
		this.qtdAcidentes = qtdAcidentes;
	}
	
	
	
	
}
