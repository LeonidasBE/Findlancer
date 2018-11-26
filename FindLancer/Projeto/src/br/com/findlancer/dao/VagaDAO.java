package br.com.findlancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.findlancer.model.Categoria;
import br.com.findlancer.model.Empresa;
import br.com.findlancer.model.Subcategoria;
import br.com.findlancer.model.Vaga;

public class VagaDAO {

	//Variavel para conexao
	Connection conexaoDB= Conexao.conectar();
	
	
	//Realiza o insert no banco na tabela de vagas
	public void cadastrarVaga(Vaga vaga){
		//String contendo o comando insert
		String sql = "insert into vagas (descricaoVaga,formacao,email,experiencia,salario,"
				+ "	fk_empresa,fk_subcategoria,titulo,quantidade) values(?,?,?,?,?,?,?,?,?)";
		//Tentar executar
		try {
			//Preparar o statement
			PreparedStatement statement = conexaoDB.prepareStatement(sql);
			statement.setString(1, vaga.getDescricao()); 
			statement.setString(2, vaga.getFormacao()); 
			statement.setString(3, vaga.getEmail());
			statement.setString(4, vaga.getExperiencia());
			statement.setString(5, vaga.getSalario());
			statement.setInt(6, vaga.getFkEmpresa());
			statement.setInt(7,vaga.getFkSubcategoria());
			statement.setString(8, vaga.getTitulo());
			statement.setInt(9, vaga.getQuantidade());
			
			statement.execute();
			statement.close();
		
			System.out.println("Vaga cadastrada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar cadastrar vaga");
		}
	}
	
	//Realiza a buscas de uma vaga por id
	public Vaga buscarVagaPorId(int id){
		//String com o comando para a query
		String sql= "select * from vagas where idVaga = ?";
		
		Vaga vaga = null;
		
		//Tentar executar a query
		try {
			
			vaga = new Vaga();
			
			//Preparando o statement
			PreparedStatement statement = conexaoDB.prepareStatement(sql);

			statement.setInt(1, id);
			
			//Executar a query e armazenar seu resultado
			ResultSet resultado = statement.executeQuery();
			
			//While para capturar os dados da query
			while(resultado.next()){
				vaga.setDescricao(resultado.getString("descricaoVaga"));
				vaga.setFormacao(resultado.getString("formacao"));
				vaga.setEmail(resultado.getString("email"));
				vaga.setExperiencia(resultado.getString("experiencia"));
				vaga.setFkEmpresa(resultado.getInt("fk_empresa"));
				vaga.setFkSubcategoria(resultado.getInt("fk_subcategoria"));
				vaga.setTitulo(resultado.getString("titulo"));
				vaga.setQuantidade(resultado.getInt("quantidade"));
				vaga.setSalario(resultado.getString("salario"));
				vaga.setIdVaga(resultado.getInt("idVaga"));
			}
				
			//Buscar a empresa por fk
			EmpresaDAO empresaDao = new EmpresaDAO();
			Empresa empresa = empresaDao.buscaPorId(vaga.getFkEmpresa());
			vaga.setEmpresa(empresa);
			
			SubcategoriaDAO subcategoriaDao = new SubcategoriaDAO();
			Subcategoria subcategoria = subcategoriaDao.buscaPorId(vaga.getFkSubcategoria());
			vaga.setSubcategoria(subcategoria);
			
			statement.close();
			
			System.out.println("Vaga buscada por id com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar buscar vaga por id ");
		}
		
		return vaga;
	}
	
	//M�todo que retorna uma lista de vagas da empresa
	public List<Vaga> buscarVagasPorEmpresa(int id){
		
		String sql ="select * from vagas where fk_empresa = ?";
		
		//Lista de vagas
		List<Vaga> vagas = null;
		
		//Tentar executar a query
		try {
			vagas= new ArrayList<Vaga>();
			
			//Preparar o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			
			//Atribuir parametros para o stmt
			stmt.setInt(1, id);
			
			//Executar a query e armazenar seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			//Buscar a empresa por fk
			EmpresaDAO empresaDao = new EmpresaDAO();
			Empresa empresa = empresaDao.buscaPorId(id);
			
			
			//While para capturar os resultados
			while(resultado.next()){
				//Instanciando novo objeto de vaga
				Vaga vaga = new Vaga();
				vaga.setIdVaga(resultado.getInt("idVaga"));
				vaga.setDescricao(resultado.getString("descricaoVaga"));
				vaga.setFormacao(resultado.getString("formacao"));
				vaga.setEmail(resultado.getString("email"));
				vaga.setExperiencia(resultado.getString("experiencia")); 
				vaga.setFkSubcategoria(resultado.getInt("fk_subcategoria"));
				vaga.setTitulo(resultado.getString("titulo"));
				vaga.setSalario(resultado.getString("salario"));
				vaga.setQuantidade(resultado.getInt("quantidade"));
			
				//Armazenando a empresa buscada ao objeto vaga
				vaga.setEmpresa(empresa);
				
				//Adicionando a vaga lista
				vagas.add(vaga);
			}
			
			
			
			stmt.close();
			
			System.out.println("Lista de vagas buscadas com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao buscar lista de vagas");
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		
		return vagas;
	}
	
	//M�todo para alterar vaga
	public void alterarVaga(Vaga vaga){
		//String com o comando para update
		String sql =  " update vagas set titulo = ?, quantidade = ? , descricaoVaga = ?,email=?,fk_subcategoria=?, "
				+ " salario = ?, formacao = ?, experiencia = ? where idVaga = ? ";
		
		//Tentar executar o update no banco
		try {
			
			//Preparando o statement
			PreparedStatement statement = conexaoDB.prepareStatement(sql);
			statement.setString(1, vaga.getTitulo());
			statement.setInt(2, vaga.getQuantidade());
			statement.setString(3, vaga.getDescricao());
			statement.setString(4,vaga.getEmail());
			statement.setInt(5, vaga.getFkSubcategoria());
			statement.setString(6, vaga.getSalario());
			statement.setString(7,vaga.getFormacao());
			statement.setString(8, vaga.getExperiencia());
			statement.setInt(9,vaga.getIdVaga()); 
			
			statement.executeUpdate();
			statement.close();
			
			System.out.println("Vaga alterada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar alterar");
			
		}
	}
	
	//Metodo para excluir uma vaga
	public void excluirVaga(int id){
		String sql = "delete from vagas where idVaga = ?";
		
		//Tentar executar a delecao
		try {
			//Preparando o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
			
			
			System.out.println("Vaga deletada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar vaga"+e.getMessage());
		}
	}
	
	//Realiza busca de vagas de acordo com a categoria
	public List<Vaga> buscarVagasPorCategoria(int fkCategoria){
		//String que armazena a query 
		String sql= "select v.idVaga,v.titulo, c.descricao,s.descricao from vagas as v " 
				+" inner join subcategorias as s on v.fk_subcategoria = s.idSubcategoria " 
				+" inner join categorias as c on s.fk_categoria = c.idCategoria " 
				+" where  s.fk_categoria = ?";
		List <Vaga> lista = null;
		
		//Tentar executar a query
		try {
			//Preparar o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setInt(1, fkCategoria);
			
			//Nova lista de vagas
			lista = new ArrayList<Vaga>();
			
			//Executar a query e armazenar seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			//Armazenar resultado da query na vaga
			while(resultado.next()){
				 
				//Novo objeto da classe vaga
				Vaga vaga = new Vaga();
				
				//Atribuindo resultados ao objeto
				vaga.setIdVaga(resultado.getInt(1));
				vaga.setTitulo(resultado.getString(2));
				vaga.setSubcategoria(new Subcategoria());
				vaga.getSubcategoria().setCategoria(new Categoria());
				vaga.getSubcategoria().getCategoria().setDescricao(resultado.getString(3));
				vaga.getSubcategoria().setDescricao(resultado.getString(4));
				
				//Adicionando a vaga � lista de vagas
				lista.add(vaga);
			}
			
			stmt.close();
			
			System.out.println("Lista de vagas adicionais buscadas ok");
		} catch (SQLException e) {
			System.out.println("Lista de vagas adicionais buscadas erro -->"+e.getMessage());
			
		}
		
		return lista;
	}

	public List<Vaga> pesquisarVaga(String palavra){
		//String para armazenar o comando da query
		String sql = "select idVaga, descricaoVaga,titulo from vagas where descricaoVaga like ? or titulo like ? ";

		//Criando nova list
		List<Vaga> lista =  null;
		
		//Preparar o statement
		try {
			//Preparar o statement
			PreparedStatement stmt = conexaoDB.prepareStatement(sql);
			stmt.setString(1, "%"+palavra+"%"); 
			stmt.setString(2, "%"+palavra+"%"); 
			
			//Executar a query e armazenar seu resultado
			ResultSet resultado = stmt.executeQuery();
			
			//Instanciando a nova lista
			lista = new ArrayList<Vaga>();
			
			//while para receber os resultados do result set
			while(resultado.next()){
				//Instanciando uma nova vaga
				Vaga vaga = new Vaga();
				vaga.setIdVaga(resultado.getInt(1));
				vaga.setDescricao(resultado.getString(2));
				vaga.setTitulo(resultado.getString(3));
				
				//Salvando a vaga na list
				lista.add(vaga);
			}
			
			stmt.close();
			
			System.out.println("Pesquisa de vaga ok");
		} catch (SQLException e) {
			System.out.println("Pesquisa de vaga erro"+e.getMessage());
			
		}
		
		return lista;
	}
	
	public List<Vaga> filtrarVaga(int fkCategoria,String palavra){
		String sql = "select v.idVaga,v.titulo,v.descricaoVaga from vagas as v inner join subcategorias as s "+
					"on v.fk_subcategoria = s.idSubcategoria where s.fk_categoria = ? and (v.titulo like ? or v.descricaoVaga like ? )";
		List<Vaga> lista = null;
		
		//Tentar executar a query
		try {
			//Preparar o statement
			PreparedStatement statement = conexaoDB.prepareStatement(sql);
			statement.setInt(1, fkCategoria);
			statement.setString(2, "%"+palavra+"%");
			statement.setString(3, "%"+palavra+"%");
			
			//Executar a query e armarzenar o seu resultado
			ResultSet resultado = statement.executeQuery();
			
			lista = new ArrayList<Vaga>();
			
			//while para criar o objeto om os resultado daquery
			while(resultado.next()){
				//Nova instancia de vaga
				Vaga vaga = new Vaga();
				//Atribuir os resultados ao novo objeto
				vaga.setIdVaga(resultado.getInt(1));
				vaga.setTitulo(resultado.getString(2));
				vaga.setDescricao(resultado.getString(3));
				
				//Armazenar a vaga na lista
				lista.add(vaga);
			}
			
			statement.close();
			
			System.out.println("Lista de vagas buscadas com sucesso(por categorias)");
		} catch (SQLException e) {
			System.out.println("Lista de vagas buscadas com erro(por categorias)-->"+e.getMessage());
			 
		}
	
		return lista;
	}
	
}
