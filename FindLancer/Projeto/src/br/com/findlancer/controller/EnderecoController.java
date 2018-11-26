package br.com.findlancer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.findlancer.dao.EnderecoDAO;
import br.com.findlancer.model.Endereco;

/**
 * Servlet implementation class EnderecoController
 */
@WebServlet("/enderecocontoller.do")
public class EnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Objeto da classe EnderecoDAO para executar metodos DAO
	private static EnderecoDAO enderecoDAO = new EnderecoDAO();
	
    public EnderecoController() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}
	
	public static int cadastrarEndereco(HttpServletRequest request, HttpServletResponse response){
		//Instanciando novo objeto da classe Endereco
		Endereco endereco = new Endereco();
		endereco=capturarParametros(request, response);
		
		//Executando metodo e retornando seu resultado
		return	enderecoDAO.cadastrarEndereco(endereco);
	}

	public static Endereco capturarParametros(HttpServletRequest request, HttpServletResponse response){
		
		//parameters para tabela de enderecos
		int fkcidade=Integer.parseInt(request.getParameter("ncidade"));
		int numeroEnd=Integer.parseInt(request.getParameter("nnumero")); 
		String bairro=request.getParameter("nbairro"); 
		String cep=request.getParameter("ncep"); 
		String rua =request.getParameter("nrua"); 
			    
		//Instanciando objeto da classe enderecos e atribuindo os valores
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.converterCep(cep);
		endereco.setFk_cidade(fkcidade);
		endereco.setNumero(numeroEnd);
		endereco.setNomeRua(rua);
		
		return endereco;
	}
	
	public static void alterarEndereco(HttpServletRequest request, HttpServletResponse response){
		
		//Instanciando novo objeto endereco e capturando os parametros
		Endereco endereco = new Endereco();
		endereco=capturarParametros(request, response);
		
		//Capturar parametro de id
		int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
		
		//Atribuindo id ao objeto endereco
		endereco.setIdEndereco(idEndereco);
		
		//Executando metodo de alterar endereco
		enderecoDAO.alterarEndereco(endereco);
	}
}
