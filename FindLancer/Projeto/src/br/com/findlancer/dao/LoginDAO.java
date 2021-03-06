package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
public class LoginDAO {
	
	Connection conexaoDB = Conexao.conectar();
	public static int nivel=0;
	
    public int logar(String email,String senha){
    	int idUsuario = 0;
    	String sqlFreela ="select idFreelancer as id from freelancers where email = ? and senha = ?";

    	//M�todo para verificar o freelancer
    	 idUsuario=logarSelect(sqlFreela, email, senha);

    	 if(idUsuario==0){
    		String sqlEmpresa="SELECT empresas.idEmpresa FROM empresas WHERE empresas.email =? and empresas.senha = ? ";
    		idUsuario=logarSelect(sqlEmpresa, email, senha);
    		nivel=2;
    	 }else{
    		nivel=1;
    	}
		return idUsuario;
    }
    
    private int logarSelect(String sql,String email,String senha){
    	int idUsuario=0;
    	try {
			PreparedStatement statement = conexaoDB.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, senha);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()){
				idUsuario=resultado.getInt(1);
			}
			 statement.close();
			
		} catch (SQLException e) {
			
		}
    	return idUsuario;
    }
    
    public String retornaNomePeloId(int nivel,int id){
    	String sql=null;
    	
    	if(nivel==1){
    		sql="select nome from freelancers where idFreelancer=?";
    	}else if(nivel==2){    		
    		sql="select nome from empresas where idEmpresa=?";
    	}
    	
    	String nomeUsuario=null;
    	 
    	try {
			PreparedStatement statement = conexaoDB.prepareStatement(sql);
			statement.setInt(1, id );
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()){
				nomeUsuario = resultado.getString(1);
			}
			
			statement.close();
			
			System.out.println("Consulta realizada");
		} catch (SQLException e) {
			
			System.out.println("Consulta n�o realizada");
				
		}
    	
    	
    	return nomeUsuario;
    }
	
    public boolean autenticarEmail(String email){
    	 int idUsuario = 0;
    	 boolean emailExistente = false;
    	 
    	 try {
    		 //Query para verificar primeiro na tabela de freelancers
    		 String sql= "select idFreelancer from freelancers where email = ?";
        	 
        	 idUsuario=verificarEmail(sql, email);
        	 if(idUsuario==0){
        		 sql= "select idEmpresa from empresas where email = ?";
        		 idUsuario=verificarEmail(sql, email);
        		 if(idUsuario!=0){
        			emailExistente=true;
        		 }
        	 }else{
        		 emailExistente=true;
        	 }
        	 
        	 System.out.println("Email verificado");
    	 } catch (Exception e) {
    		 System.out.println("Erro ao verificar email");
			 
		}
    	
    	return emailExistente;
    }
    
    public int verificarEmail(String sql,String email){
    	//Variavel que retorna resultado da consulta
    	int idUsuario=0;
    	
    	//Try para tentar conectar e consultar
    	try {
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setString(1, email);
			
			//Armazena resultado no resultSet
			ResultSet resultado = stmt.executeQuery();
			
			//Verifica se o resultado query foi true
			if(resultado.next()){
				idUsuario=resultado.getInt(1);
			}
			
			System.out.println("Consulta email realizada");
		} catch (SQLException e) {
			System.out.println("Consulta email erro");
			 
		}
    	
    	return idUsuario;
    }
}	
