package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.findlancer.model.Freelancer; 
  

public class FreelancerDAO {
    
	Connection conexaoDBUsuario = Conexao.conectar();
	
	public void Cadastrar(Freelancer freelancer){
			try {
				String sql = "insert into freelancers(nome,descricaoTrabalho,email,experiencia, "
						+ "formacao,nascimento,senha,fk_subcategoria,telefone,fk_endereco) "
						+ "values(?,?,?,?,?,?,?,?,?,?)";
				
				
				PreparedStatement statement = conexaoDBUsuario.prepareStatement(sql);
				statement.setString(1, freelancer.getNome());
				statement.setString(2, freelancer.getDescricao());
				statement.setString(3, freelancer.getEmail());
				statement.setString(4, freelancer.getExperiencia());
				statement.setString(5, freelancer.getFormacao()); 
				statement.setString(6, freelancer.dataParaBanco(freelancer.getNascimento()));
				statement.setString(7, freelancer.getSenha());
				statement.setInt(8, freelancer.getFksubcategoria()); 
				statement.setString(9, freelancer.getTelefone());
				statement.setInt(10, freelancer.getFkEndereco());
				
				statement.execute();
				statement.close();
				
				System.out.println("Cadastrado com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao tentar cadastrar usuario");
				System.out.println("AQUIII"+e.getMessage());
		}
	}
	
	public Freelancer buscaPorId(int id){
		
		//Objeto freelancer que ser� retornado 
		Freelancer freelancer = null;
		
		//String com o comando para a query
		String sql = "select f.nome,f.telefone,f.email,f.descricaoTrabalho,f.formacao, "
				+ "f.experiencia, f.fk_endereco,f.fk_subcategoria, "
				+ "TIMESTAMPDIFF(YEAR, f.nascimento, NOW()),f.senha,f.nascimento from freelancers as f where idFreelancer = ?";
				
		try {
			
			//Preparar o statement
			PreparedStatement statement = conexaoDBUsuario.prepareStatement(sql);
			
			//Atribuindo o parametro id para o parametro da query
			statement.setInt(1, id);
			
			//Executando a query e armazenando resultado
			ResultSet resultado = statement.executeQuery();
			
			//While para capturar os dados do resultset
			while(resultado.next()){
				freelancer = new Freelancer();
				
				freelancer.setNome(resultado.getString(1));
				freelancer.setTelefone(resultado.getString(2));
				freelancer.setEmail(resultado.getString(3));
				freelancer.setDescricao(resultado.getString(4));
				freelancer.setFormacao(resultado.getString(5));
				freelancer.setExperiencia(resultado.getString(6)); 
				freelancer.setFkEndereco(resultado.getInt(7));
				freelancer.setFksubcategoria(resultado.getInt(8));
				freelancer.setIdade(resultado.getInt(9));
				freelancer.setSenha(resultado.getString(10));
				freelancer.setNascimento(resultado.getString(11));
			}
				
				statement.close();
				
				//Instanciando novo ojbeto de enderecoDao
				EnderecoDAO enderecoDao = new EnderecoDAO();
				freelancer.setEndereco(enderecoDao.buscarPorId(freelancer.getFkEndereco()));
			
				//Instanciando novo ojbeto de subcategoriaDao e executando a busca
				SubcategoriaDAO subcategoriaDAO = new SubcategoriaDAO();
				freelancer.setSubcategoria(subcategoriaDAO.buscaPorId(freelancer.getFksubcategoria()));
				

				
			System.out.println("Busca de perfil freelancer ok");
		} catch (SQLException e) {
			System.out.println("Busca de perfil freelancer erro");
		}
		
		return freelancer;
	}
	
	public void alterarFreelancer(Freelancer freelancer){
		
		//String com o comando para realizar o update
		String sql = "update freelancers set nome = ?, telefone = ?, email=?, fk_subcategoria = ?, nascimento = ?, "
				+ " descricaoTrabalho = ?, formacao = ?, experiencia= ? where idFreelancer = ?  ";

		//Tentar executar o update
		try {
			//Preparando o statement
			PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
			//Atribuir os parametros
			stmt.setString(1, freelancer.getNome());
			stmt.setString(2, freelancer.getTelefone());
			stmt.setString(3, freelancer.getEmail());
			stmt.setInt(4, freelancer.getFksubcategoria());
			stmt.setString(5, freelancer.dataParaBanco(freelancer.getNascimento()));
			stmt.setString(6,freelancer.getDescricao());
			stmt.setString(7, freelancer.getFormacao());
			stmt.setString(8, freelancer.getExperiencia());
			stmt.setInt(9, freelancer.getId()); 
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Freelancer alterado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao alterar freelancer");

		}
	}
	
	public Boolean validarSenha(int id,String senha){
		String sql = "select senha from Freelancers where idFreelancer=?";
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
		String sql ="update freelancers set senha = ? where idFreelancer = ?";
		//Tentar executar a alteracao de senha
		try {
			//Preparar o statement 
			PreparedStatement statement = conexaoDBUsuario.prepareStatement(sql);
			statement.setString(1, senha);
			statement.setInt(2, id);
			statement.execute();
			statement.close();
			
			System.out.println("Senha alterada com sucesso(freelancers)");
		} catch (SQLException e) {
			 System.out.println("Senha alterada com erro");
		}
	}

	public List<Freelancer> pesquisarFreelancer(String palavra){
		//String com o comando da query
		String sql = "select idFreelancer,nome,descricaoTrabalho from freelancers where nome like ? or descricaoTrabalho like ?";
	
		//Nova lista de freelancers
		List<Freelancer> lista = null;
		
		//Tentar executar a query
		try {
			
			//Preparar o statement
			PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
			stmt.setString(1, "%"+palavra+"%");
			stmt.setString(2, "%"+palavra+"%");
			
			System.out.println(palavra);
			
			//Executar a query e armazenar seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			//Instanciando nova lista
			lista = new ArrayList<Freelancer>(); 
			//While para capturar os dados
			while(resultado.next()){
				System.out.println("Entrou no while");
				//Novo objeto freelancer
				Freelancer freelancer = new Freelancer();
				freelancer.setId(resultado.getInt(1)); 
				freelancer.setNome(resultado.getString(2));
				freelancer.setDescricao(resultado.getString(3));
				
				//Adicionando o freelancer a lista
				lista.add(freelancer);
			}
			
			stmt.close();
			
			System.out.println("Lista de freelancers com sucesso");
		} catch (SQLException e) {
			System.out.println("Lista de freelancers com erro"+e.getMessage());

		}
		
		return lista;
	}

	public List<Freelancer> pesquisarPorCat(int fkCategoria,String palavra){
		//String que armazena a query 
				String sql=  "select f.idFreelancer,f.nome,f.descricaoTrabalho from freelancers as f inner join subcategorias as s "+
						"on f.fk_subcategoria = s.idSubcategoria where s.fk_categoria = ? and (f.nome like ? or f.descricaoTrabalho like ? )";
				List <Freelancer> lista = null;
				
				//Tentar executar a query
				try {
					//Preparar o statement
					PreparedStatement stmt = conexaoDBUsuario.prepareStatement(sql);
					stmt.setInt(1, fkCategoria);
					stmt.setString(2, "%"+palavra+"%");
					stmt.setString(3, "%"+palavra+"%");
					
					//Nova lista de vagas
					lista = new ArrayList<Freelancer>();
					
					//Executar a query e armazenar seu resultado
					ResultSet resultado = stmt.executeQuery();
					
					//Armazenar resultado da query na vaga
					while(resultado.next()){
						//Novo objeto freelancer
						Freelancer freelancer = new Freelancer();
						freelancer.setId(resultado.getInt(1));
						freelancer.setDescricao(resultado.getString(3));
						freelancer.setNome(resultado.getString(2));
						
						//Adicionando freelancer a lista
						lista.add(freelancer);
					
					}
					
					stmt.close();
					
					System.out.println("Lista de freelancers por cat sucessso");
				}catch(SQLException e){
					System.out.println("Lista de freelancers por cat erro"+e.getMessage());
					
				}		 
				
				return lista;

	}
}
