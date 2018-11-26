package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.findlancer.model.Empresa;

public class EmpresaDAO {
		
	Connection conexaoDBUsuario = Conexao.conectar();
	public void cadastrarEmpresa(Empresa empresa){
		//String com o comando para insert no banco
		String sql = "insert into empresas (nome,ramoAtividade,qtdfuncionarios,fk_endereco,telefone,pessoaContato, "
				+ " descricao,email,senha) values (?,?,?,?,?,?,?,?,?) ";
		//Tentar executar a insercao
		try {
			
			//Preaparando o statement
			PreparedStatement statement = conexaoDBUsuario.prepareStatement(sql);
			statement.setString(1, empresa.getNome());
			statement.setString(2, empresa.getRamoAtividade());
			statement.setInt(3, empresa.getQtdfuncionarios());
			statement.setInt(4, empresa.getFkEndereco());
			statement.setString(5, empresa.getTelefone());
			statement.setString(6, empresa.getPessoaContato());
			statement.setString(7, empresa.getDescricao());
			statement.setString(8, empresa.getEmail());
			statement.setString(9, empresa.getSenha());
			
			statement.execute();
			statement.close();
			
			System.out.println("Empresa cadastrada com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao tentar cadastrar empresa");
			System.out.println(e.getMessage());
		}
		
	}	
		
		//Metodo para buscar empresa por id
		public Empresa buscaPorId(int id){
			//String para guardar a query
			String sql = "select e.nome,e.ramoAtividade,e.qtdfuncionarios,e.fk_endereco,e.telefone,e.pessoaContato,"
					+ "e.descricao,e.email from empresas as e where idEmpresa= ? ";
			
			//Declarando objeto da classe empresa
			Empresa empresa = null;
			
			//Tentar executar a query
			try {
				//preparar o statement
				PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
				stmt.setInt(1, id);
				
				//Executar e armzenar o resultado da query
				ResultSet resultado = stmt.executeQuery();
				
				while(resultado.next()){
					empresa = new Empresa();
					empresa.setNome(resultado.getString(1));
					empresa.setRamoAtividade(resultado.getString(2));
					empresa.setQtdfuncionarios(resultado.getInt(3));
					empresa.setFkEndereco(resultado.getInt(4));
					empresa.setTelefone(resultado.getString(5));
					empresa.setPessoaContato(resultado.getString(6));
					empresa.setDescricao(resultado.getString(7));
					empresa.setEmail(resultado.getString(8));
				}
				
				//Chamar metodo para buscar endereco
				EnderecoDAO enderecoDao = new EnderecoDAO();
				empresa.setEndereco(enderecoDao.buscarPorId(empresa.getFkEndereco()));
				empresa.setId(id); 
				
				System.out.println("Sucesso ao buscar empresa");
			} catch (SQLException e) {
				System.out.println("Erro ao buscar empresa");
				 
			}
			
			return empresa;
	}
		//Metodo para alterar a empresa
		public void alterarEmpresa(Empresa empresa){
			String sql ="update empresas set nome= ? , telefone = ? , email = ?, pessoaContato = ?, "
					+ " descricao = ? ,qtdfuncionarios = ?,ramoAtividade = ? where idEmpresa = ? ";
			//Tentar executar a alteracao na tabela
			try {
				
				//Prepara o statement para executar
				PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
				
				//Atribuir os parametros
				stmt.setString(1, empresa.getNome());
				stmt.setString(2, empresa.getTelefone());
				stmt.setString(3, empresa.getEmail());
				stmt.setString(4, empresa.getPessoaContato());
				stmt.setString(5, empresa.getDescricao());
				stmt.setInt(6, empresa.getQtdfuncionarios());
				stmt.setString(7, empresa.getRamoAtividade());
				stmt.setInt(8,empresa.getId());
				
				stmt.execute();
				stmt.close();
				
				System.out.println("Empresa alterada com sucesso");
			} catch (SQLException e) {
				System.out.println("Empresa alterada com erro");
				System.out.println(e.getMessage());
			}
		}
		
		public int contVagasPorEmpresa(int id){
			//String para armazenar o comando da query
			String sql = "select count(fk_empresa) from vagas where fk_empresa = ?";
			
			//Variavel para receber o resultado do contador
			int cont=0;
			
			
			//Tentar executar a query
			try {
				//Preparar o statement
				PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
				stmt.setInt(1, id);
				
				//Executar e armazenar o resultado da query
				ResultSet resultado = stmt.executeQuery();
				
				//Capturar o resultado da query
				while(resultado.next()){
					cont=resultado.getInt(1);
				}
				
				System.out.println("Contagem de vagas por empresa ok");
			} catch (SQLException e) {
				System.out.println("Contagem de vagas por empresa erro -->"+e.getMessage());
				
			}
			
			return cont;
		}
		
		public Boolean validarSenha(int id,String senha){
			String sql = "select senha from empresas where idEmpresa=?";
			boolean validarSenha = false;
			//tentar executar a query
			try {
				
				String senhaDB = "";
				
				//Preparar o statement
				PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
				//Atribuir os parametros
				stmt.setInt(1, id);
				//Executar a query e armazenar seu resultado
				ResultSet resultado = stmt.executeQuery();
				while(resultado.next()){
					 senhaDB = resultado.getString(1);
				}
				//Verificar se a senha digitada é igual a senha do banco
				if(senhaDB.equals(senha)){
					validarSenha=true;
				}
				stmt.close();
				
				System.out.println("Busca de senha com suscesso");
			} catch (SQLException e) {
				System.out.println("Busca de senha com erro");
				
			}
			
			return validarSenha;
		}
		
		public void alterarSenha(String senha,int id){
			String sql ="update empresas set senha = ? where idEmpresa = ?";
			//Tentar executar a alteracao de senha
			try {
				//Preparar o statement 
				PreparedStatement statement = conexaoDBUsuario.prepareStatement(sql);
				statement.setString(1, senha);
				statement.setInt(2, id);
				statement.execute();
				statement.close();
				
				System.out.println("Senha alterada com sucesso(empresa)");
			} catch (SQLException e) {
				 System.out.println("Senha alterada com erro");
			}
		}
	}


