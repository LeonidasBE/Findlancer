package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import br.com.findlancer.model.Subcategoria;

public class SubcategoriaDAO {
	
	//Variavel de conexao
	Connection conexaoDB= Conexao.conectar();
	
	public ArrayList<Subcategoria> popularSubcategorias(int fkCat){
		ArrayList<Subcategoria> listaSub = null;
		 
			//Select para capturar valores da tabela
			String sql ="select idSubcategoria,descricao from subcategorias where fk_categoria=?";
			
			//try para realizar a conexao e executar a query
			try {
				 //Preparando o statement
				PreparedStatement stmt = Conexao.conectar().prepareStatement(sql);
				//Passando os parametros para query
				stmt.setInt(1, fkCat);
				
				//Executando query e armazenado seu resultado 
				ResultSet resultado = stmt.executeQuery();
				
				//Atribuindo tipo ao listaSub
				listaSub = new 	ArrayList<Subcategoria>();
				
				//While para captura de valores
				while(resultado.next()){
					//Instanciando objeto da classes Subcategorias
					Subcategoria subcategorias = new Subcategoria();
					
					//Atribuindo valores recebidos pelo resultset
					subcategorias.setIdSub(resultado.getInt(1));
					subcategorias.setDescricao(resultado.getString(2));
					
					//Armazanando objeto no arraylist
					listaSub.add(subcategorias);
				}
			
			System.out.println("Query subcategorias ok.");
			
		} catch (SQLException e) {
			System.out.println("Query subcategorias erro.");

		}
		
		return listaSub;
	}

	//Metodo para busca por id
	public Subcategoria buscaPorId(int id){
		//String com o comando sql
		String sql = "select descricao,fk_categoria from subcategorias where idSubcategoria =?";
		
		
		//Declarando objeto da classe Subcategoria
		Subcategoria subcategoria = null;
		
		//Tentar exeutar a query
		try {
			//Preparando o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			
			//Enviando parametro para query
			stmt.setInt(1, id);
			
			//Execuatndo a query e armazenando seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()){
			
				subcategoria = new Subcategoria();
				subcategoria.setDescricao(resultado.getString(1));
				subcategoria.setFkCategoria(resultado.getInt(2));
			}
			
			//Executar o m�todo de categoria dao
			CategoriaDAO categoriaDao = new CategoriaDAO();
			subcategoria.setCategoria(categoriaDao.buscaPorId(subcategoria.getFkCategoria()));
			
			
			System.out.println("Busca de subcategoira ok");
		} catch (SQLException e) {
			System.out.println("Busca de subcategoira erro");
			
		}
		
		return subcategoria;
	}
}

