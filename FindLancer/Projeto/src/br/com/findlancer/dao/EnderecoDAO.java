package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import br.com.findlancer.model.Endereco;

public class EnderecoDAO {

	Connection conexaoDB = Conexao.conectar();
	
	public int cadastrarEndereco(Endereco endereco){
		
		int Fk = 0;
		
		//Comando para o insert no banco
		String sql="INSERT INTO enderecos (numero, cep, bairro, fk_cidade, nome_Rua) VALUES ( ?, ?, ?, ?, ?);";
		try {
			//Preparando a query
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			
			//Atribuir os parametros da query
			stmt.setInt(1, endereco.getNumero());
			stmt.setInt(2, endereco.getCep());
			stmt.setString(3, endereco.getBairro());
			stmt.setInt(4, endereco.getFk_cidade());
			stmt.setString(5, endereco.getNomeRua());
			
			//executar o insert 
			stmt.execute();
			
			System.out.println("Endereco cadastrado");
			Fk=retornarFk();
		} catch (SQLException e) {
			System.out.println("Endereco nao cadastrado");
			 
		}
		return Fk;
	}
	
	
	public int retornarFk(){
		int FkEnd=0;
		//Comando query 
		String sql="select idEndereco from enderecos ORDER by  idEndereco desc limit 1";
		
		//try para tentar executar a query
		try {
			//preparar a query
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			//Executando e armazenando da query
			ResultSet resultado= stmt.executeQuery();
			
			//While para receber resultado da query
			while(resultado.next()){
				FkEnd=resultado.getInt(1);
			}
		} catch (SQLException e) {
			 
		}
		
		
		return FkEnd;
	}
	
	//M�todo que realiza busca por id de endereco
	public Endereco buscarPorId(int id){
		//String com o comando sql para a query
		String sql = "select e.numero,e.cep,e.bairro,e.fk_cidade,e.nome_Rua from enderecos as e where idEndereco = ?";
		Endereco endereco = null;
		//Try para tentar executar a query
		try {
			//Preparando o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setInt(1, id);
			//Executando a query e armazenando seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()){
				//Instancia nova de endereco
				endereco = new Endereco();
				
				//Armazenar resultados da query no objeto endereco
				endereco.setNumero(resultado.getInt(1));
				endereco.setCep(resultado.getInt(2));
				endereco.setBairro(resultado.getString(3));
				endereco.setFk_cidade(resultado.getInt(4));
				endereco.setNomeRua(resultado.getString(5));
				
				CidadeDAO cidadeDao = new CidadeDAO();
				endereco.setCidade( cidadeDao.buscaPorId(endereco.getFk_cidade()) );
			}	
			
			stmt.close();
				
			System.out.println("Busca de endereco realizada");
		} catch (SQLException e) {
			System.out.println("Busca de endereco erro");
			
		}
		
		return endereco;
	}
	
	//Metodo para alterar o endereco 
	public void alterarEndereco(Endereco endereco){
		String sql = "UPDATE enderecos SET bairro = ? , nome_Rua = ?,numero = ? ,cep = ?, fk_cidade = ? WHERE  idEndereco = ?";
		
		//Tentar executar o uptadte no banco
		try {
			//Preparar o statement
			PreparedStatement stmt =  conexaoDB.prepareStatement(sql);
			//Atribuir os parametros
			stmt.setString(1, endereco.getBairro());
			stmt.setString(2, endereco.getNomeRua());
			stmt.setInt(3, endereco.getNumero());
			stmt.setInt(4,endereco.getCep());
			stmt.setInt(5, endereco.getFk_cidade());
			stmt.setInt(6, endereco.getIdEndereco());
			System.out.println("IDenderco -->"+endereco.getIdEndereco());
			
			//Executar o update no banco
			stmt.execute();
			stmt.close();
			
			System.out.println("Endereco alterado com sucesso");
			
		} catch (Exception e) {
			System.out.println("Erro ao alterar endereco"); 
			 
		}
	}
	
}
