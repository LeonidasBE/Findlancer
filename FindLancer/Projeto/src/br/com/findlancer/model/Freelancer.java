package br.com.findlancer.model;

public class Freelancer extends Usuarios {
	private String nascimento; 
	private int fksubcategoria;
	private String formacao;
	private String experiencia;
	private int idade;  
	private Subcategoria subcategoria;
	
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
	 
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	 
	public int getFksubcategoria() {
		return fksubcategoria;
	}
	public void setFksubcategoria(int fksubcategoria) {
		this.fksubcategoria = fksubcategoria;
	}

	public String getNascimento() {
	
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		
		this.nascimento = nascimento;
	}
	 

	public String getFormacao() {
		
		formacao=quebradeLinha(formacao);
		
		return formacao;
	}
	public void setFormacao(String formacao) {
		
		this.formacao = formacao;
	}
	public String getExperiencia() {
	
		experiencia = quebradeLinha(experiencia);	
		
		
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}	
	
	//Método para converter a data no formato que vai para o banco
	public String dataParaBanco(String nascimento){
		 
		 String mes = nascimento.substring(0, 2);
		 String dia = nascimento.substring(3, 5);
		 String ano = nascimento.substring(6);
		 nascimento=ano+"-"+mes+"-"+dia;
	 
		return nascimento;
	}
	
	public String dataParaFormulario(String nascimento){
		String ano = nascimento.substring(0,4);
		String mes = nascimento.substring(5,7);
		String dia = nascimento.substring(8);
		nascimento=mes+"/"+dia+"/"+ano;
		
		return nascimento;
	}
	
	
}


	