package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	//Método para realizar a conexao com o banco
	public static Connection conectar(){
		//Variavel que recebe parametros para rconexao
		Connection conexaoDB = null;
		
		//Try tentando conectar o banco 
		try {
			//Class for name passando o driver do mysql
			Class.forName("com.mysql.jdbc.Driver");
			
			//String com o caminho do banco com a case de dados
			String url = "jdbc:mysql://localhost/findlancer";
			conexaoDB = DriverManager.getConnection(url,"root","");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (ClassNotFoundException e) {
			 JOptionPane.showMessageDialog(null, "Driver não encontrado");
		}
		return conexaoDB;

	}

}