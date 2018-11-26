package br.com.findlancer.model;

public class Vaga {
	
	private int idVaga;
	private String descricao;
	private String formacao;
	private int quantidade;
	private String email;
	private String experiencia;
	private String salario;
	private int fkEmpresa;
	private int fkSubcategoria;
	private String titulo;
	private Subcategoria subcategoria;
	private Empresa empresa;
	
	
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public String getDescricao() { 
		
		descricao=quebradeLinha(descricao);
		
		return descricao;
	}
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}
	public String getFormacao() {
	
		formacao=quebradeLinha(formacao);
		
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	 
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getEmail() {
	 
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExperiencia() {

		experiencia=quebradeLinha(experiencia);
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public int getFkEmpresa() {
		return fkEmpresa;
	}
	public void setFkEmpresa(int fkEmpresa) {
		this.fkEmpresa = fkEmpresa;
	}
	public int getFkSubcategoria() {
		return fkSubcategoria;
	}
	public void setFkSubcategoria(int fkSubcategoria) {
		this.fkSubcategoria = fkSubcategoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private String quebradeLinha(String txt){
		
		txt=txt.replaceAll("\n", "<br>");
		
		return txt;
	} 
	
	public static String textoFormulario(String txt){
		
		txt=txt.replaceAll("<br>", "\n");
		
		return txt;
} 
	
}
