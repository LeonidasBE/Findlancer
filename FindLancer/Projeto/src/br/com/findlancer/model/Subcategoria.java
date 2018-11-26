package br.com.findlancer.model;

public class Subcategoria {
	private int idSub;
	private String descricao;
	private int fkCategoria;
	private Categoria categoria;
	
	public int getFkCategoria() {
		return fkCategoria;
	}
	public void setFkCategoria(int fkCategoria) {
		this.fkCategoria = fkCategoria;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getIdSub() {
		return idSub;
	}
	public void setIdSub(int idSub) {
		this.idSub = idSub;
	}
	 
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
