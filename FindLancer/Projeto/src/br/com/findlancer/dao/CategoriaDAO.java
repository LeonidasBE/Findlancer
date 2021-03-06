package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import br.com.findlancer.model.Categoria; 

public class CategoriaDAO {

	Connection conexaoDB= Conexao.conectar();
	
	public ArrayList<Categoria> popularCategorias(){
		ArrayList<Categoria> listaCategorias = null;
		try {
			//List categorias 
			listaCategorias = new ArrayList<Categoria>();

			
			//Comando realizando o select dos campos de categorias
			String sql ="SELECT idCategoria,descricao FROM categorias";
			
			//Preparando o statament 
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			//Result rs recebendo resultados da query
			ResultSet resultado =stmt.executeQuery();
			
			//While para capturar todos os valores resultados da query e armazenar no List<Categorias>
			while(resultado.next()){
				//Instanciando objeto da classe categorias
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(resultado.getInt(1));
				categoria.setDescricao(resultado.getString(2));
				
				//Armazenando objeto categoria dentro da lista
				listaCategorias.add(categoria);
			}
			
			System.out.println("Query categorias ok.");
			
		} catch (SQLException e) {
			System.out.println("Query categorias erro.");

		}
		
		return listaCategorias;
	}
	
	//Metodo para busca por id
		public Categoria buscaPorId(int id){
			//String com o comando sql
			String sql = "select descricao from categorias where idCategoria =?";
			
			
			//Declarando objeto da classe Subcategoria
			Categoria categoria = null;
			
			//Tentar exeutar a query
			try {
				//Preparando o statement
				PreparedStatement stmt = conexaoDB.prepareStatement(sql);
				
				//Enviando parametro para query
				stmt.setInt(1, id);
				
				//Execuatndo a query e armazenando seu resultado
				ResultSet resultado = stmt.executeQuery();
				
				while(resultado.next()){
				
					categoria = new Categoria();
					categoria.setDescricao(resultado.getString(1));
				}
				//Executar o m�todo de categoria dao
				
				
				System.out.println("Busca de subcategoira ok");
			} catch (SQLException e) {
				System.out.println("Busca de subcategoira erro");
				
			}
			
			return categoria;
		}
	}




