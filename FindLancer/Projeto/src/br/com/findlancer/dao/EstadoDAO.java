package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.findlancer.model.Estado;

public class EstadoDAO {
	
	Connection conexaoDB= Conexao.conectar();
	
	public ArrayList<Estado> popularEstados(){
		//String com a query para selecionar todos os estados
		String sql="select idEstado,sgEstado from estados";
		
		//Arraylist para armazenar os estados
		ArrayList<Estado> listaEstados = null;
		
		//Try para tentar executar a query
		try {
			//Preparar a query
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			
			//ResultSet para armazenar resultado da query
			ResultSet resultado = stmt.executeQuery();
			
			//Instanciando a nova lista 
			listaEstados= new ArrayList<>();
			
			//While para capturar todos os resultados da query
			while(resultado.next()){
				//Nova instancia de objeto da classe estados
				Estado estado1 = new Estado();
				
				//Atribuindo valores da query no objeto da classe Estados
				estado1.setIdEstado(resultado.getInt(1));
				estado1.setSiglaEstado(resultado.getString(2));
				
				//Armazenando objeto na lista de Estados
				listaEstados.add(estado1);
			}
			
			System.out.println("Sucesso ao tentar selecionar todos os estados");
		} catch (Exception e) {
			System.out.println("Erro ao tentar selecionar todos os estados");
		}
		
		//Retornadno a lista
		return listaEstados;
	}
	
	//Metodo para realizar busca por id de estado
	public Estado buscaPorId(int id){
		//String com o comando para a query
		String sql = "Select e.nomeEstado,e.sgEstado from estados as e where idEstado = ?";
		
		//Declarando novo objeto estado
		Estado estado = null;
		
		//Try para tentar executar a query
		try {
			//Preparando o stmt
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			
			//Enviando os parametros da query
			stmt.setInt(1, id);
			
			//Executando a query e armazeando o seu resultset
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				//Atribuindo tipo ao objeto estado
				estado = new Estado();
			
				//Armazenando resultados da query
				estado.setNomeEstado(resultado.getString(1));
				estado.setSiglaEstado(resultado.getString(2));
			}
			
			System.out.println("Busca de estado completa (perfil)");
		} catch (SQLException e) {
			System.out.println("Busca de estado erro (perfil)");
					
		}
		
		//Retornando o objeto
		return estado;
	}
	
}
