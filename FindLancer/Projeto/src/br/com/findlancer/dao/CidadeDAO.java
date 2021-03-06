package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.findlancer.model.Cidade;

public class CidadeDAO {

	Connection conexaoDB = Conexao.conectar();
	
	public ArrayList<Cidade> popularCidades(int fkestado){
		//String para a query
		String sql="select idCidade,nomeCidade from cidades where fk_estado=?";
		ArrayList<Cidade> listaCidades = null;
		
		//Try para tentar executar a query
		try {
			//Preparar a query
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setInt(1, fkestado);

			
			//executar a query e armazenar em um ResultSet
			ResultSet resultado = stmt.executeQuery();
			
			//Definir tipo da listaCidades
			listaCidades= new ArrayList<Cidade>();
			
			//while para armazenar os resultado da query
			while(resultado.next()){
				//Instanciar objeto da classe cidades
				Cidade cidade1 = new Cidade();
				
				//dando set nos atributos do objeto com os resultados da query
				cidade1.setIdCidade(resultado.getInt(1));
				cidade1.setNomeCidade(resultado.getString(2));
				
				//Armazenando objeto da classe cidade na lista de cidades
				listaCidades.add(cidade1);
			}
			
			System.out.println("Sucesso ao tentar selecionar cidades");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar selecionar cidades");
		}
		
		return listaCidades;
	}
	
	public Cidade buscaPorId(int id){
		
		//String com o comando para query
		String sql ="Select c.nomeCidade,c.fk_estado from cidades as c where idCidade=?";
		
		//Objeto cidade para receber os valores da query
		Cidade cidade = null;
		
		//Try para tentar executar a query 
		try {
			//Preparando o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			//Enviando os parametros da query
			stmt.setInt(1, id);
			
			//Executando a query e armazenando o seu retorno
			ResultSet resultado = stmt.executeQuery();
			
			//While para armzenar os dados resultados pelo resultset
			while(resultado.next()){
				
				//Instanciando o objeto da classe cidade
				cidade = new Cidade();
				cidade.setNomeCidade(resultado.getString(1));
				cidade.setFk_estado(resultado.getInt(2));
			}
			
			//Realizar busca por id de estado
			EstadoDAO estadoDao = new EstadoDAO();
			cidade.setEstado(estadoDao.buscaPorId(cidade.getFk_estado()));
			
			
			System.out.println("Busca de cidade por id realizada");
		} catch (Exception e) {
			System.out.println("Busca de cidade por id erro");

		}
		
		//Retornando o objeto
		return cidade;
	}
}
