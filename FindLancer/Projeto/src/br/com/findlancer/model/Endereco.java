package br.com.findlancer.model;

public class Endereco {
	private int idEndereco;
	private int numero; 
	private int cep;
	private String bairro;
	private String nomeRua;
	private int fk_cidade;
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCep() {
		
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	public int getFk_cidade() {
		return fk_cidade;
	}
	public void setFk_cidade(int fk_cidade) {
		this.fk_cidade = fk_cidade;
	}
	public void converterCep(String cep){
		
		cep=cep.replace(".", "");
		cep=cep.replace("-", "");
		
		setCep(Integer.parseInt(cep));
		
	}
}
