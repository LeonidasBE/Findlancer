package br.com.findlancer.model;

public class Cidade {
	private int idCidade;
	private int fk_estado;
	private String nomeCidade;
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public int getFk_estado() {
		return fk_estado;
	}
	public void setFk_estado(int fk_estado) {
		this.fk_estado = fk_estado;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	 
}
