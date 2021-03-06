package br.com.findlancer.model;

public abstract class Usuarios  {
	
	protected String nome;
	protected String telefone;
	protected String email;
	protected String senha;
	protected String descricao; 
	protected int id;
	protected Endereco endereco;
	protected int fkEndereco;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getFkEndereco() {
		return fkEndereco;
	}
	public void setFkEndereco(int fkEndereco) {
		this.fkEndereco = fkEndereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDescricao() {
		
		descricao=quebradeLinha(descricao);
		
		return descricao;
	}
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	protected String quebradeLinha(String txt){
		
		txt=txt.replaceAll("\n", "<br>");
		
		return txt;
	} 
	
	public static String textoFormulario(String txt){
			
			txt=txt.replaceAll("<br>", "\n");
			
			return txt;
	} 
	
}

	
