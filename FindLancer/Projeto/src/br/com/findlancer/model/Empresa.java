package br.com.findlancer.model;

public class Empresa extends Usuarios{

	private String ramoAtividade;
	private int qtdfuncionarios;  
	private String pessoaContato;
	
	
	public String getRamoAtividade() {
		ramoAtividade = quebradeLinha(ramoAtividade);
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public int getQtdfuncionarios() {
		return qtdfuncionarios;
	}
	public void setQtdfuncionarios(int qtdfuncionarios) {
		this.qtdfuncionarios = qtdfuncionarios;
	}
	 
	
	public String getPessoaContato() {
		return pessoaContato;
	}
	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}
	
	
	
	
	
	
	

}
