package br.com.findlancer.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.findlancer.dao.EmpresaDAO;
import br.com.findlancer.model.Empresa;
import br.com.findlancer.util.Acao;
import br.com.findlancer.util.UtilController; 
 
@WebServlet("/empresacontroller.do")
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Objeto da classe EmpresaDAO para realizar os metodos dao de empresa
	private EmpresaDAO empresaDao = new EmpresaDAO();
	
    public EmpresaController() {
        super();
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acaoGet = request.getParameter("acao");
		
		//Condicional para ver se o usuario quer visualizar seu perfil
		if(acaoGet.equals(Acao.MEU_PERFIL.getConstante())){
			
			//Capturando a sessao atual
			HttpSession sessao = request.getSession(); 
			
			//Capturando id do usuario logado
			int idUsuario = (Integer)sessao.getAttribute("id");
			
			//Executando metodo para buscar e enviar a empresa
			carregarPerfilEmpresa(request, response, idUsuario, "empresa.jsp", idUsuario);
				
		//Condicional para ver se o usuario quer visualizar o perfil de outro usuario
		}else if(acaoGet.equals(Acao.VER_PERFIL.getConstante())){
			
			//Capturando id do usuario logado
			int idUsuario = Integer.parseInt(request.getParameter("id"));
			
			//Executando metodo para buscar e enviar a empresa
			carregarPerfilEmpresa(request, response, idUsuario, "empresa.jsp", idUsuario);
			
		
		}else if(acaoGet.equals(Acao.EDITAR_PERFIL.getConstante())){
			
			HttpSession sessao = request.getSession();
			int idUsuario = (int)sessao.getAttribute("id");
			
			//Chamando o m�todo que realiza a o carregamento dos dados
			carregarPerfilEmpresa(request, response,idUsuario,"edempresa.jsp",idUsuario);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acaoPost = request.getParameter("acao");  

		//Condicional para verificar se � cadastrar empresa
		if(acaoPost.equals(Acao.CAD_EMPRESA.getConstante())){
			
			//Chamando o método para cadastrar empresa
			cadastrarEmpresa(request, response);
			
		}else if (acaoPost.equals(Acao.ALT_EMPRESA.getConstante())){
			
			//Chamando o método para alterar a empresa
			alterarEmpresa(request, response);
				 
		}else if (acaoPost.equals(Acao.ALT_SENHA.getConstante())){
			
			//Chamando o método para alterar a senha
			alterarSenha(request, response);
		}
		
	}
	
	//Metodo para cadastrar empresa
	private void cadastrarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Instanciando novo objeto empresa e atribuindo seu valor com o retorno do m�todo capturarParametros
		Empresa empresa = new Empresa();
		empresa = capturarParametros(request, response);
		
		//Capturando foreign key do cadastro de endereco da empresa
		int fkEndereco = EnderecoController.cadastrarEndereco(request, response);

		//Atribuindo o valor de fkendereco ao objeto
		empresa.setFkEndereco(fkEndereco);
		
		
		empresaDao.cadastrarEmpresa(empresa);
		
		//Chamando o metodo de controle de login para validar o login recem cadastrado
	    LoginController.controlarLogin(request, response, empresa.getEmail(), empresa.getSenha());
	}
	
	//Carregar perfil da empresa
	private void carregarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response,int idUsuario,String pagina,int idValidacao) throws ServletException, IOException{
		
		//Capturar a sessao atual
		HttpSession sessao = request.getSession();
				 		
		//Instanciando objeto da classe empresa
		Empresa empresa = new Empresa();
				
		//Execucao do m�todo buscar por id  e o armzenando seu retorno
		empresa=empresaDao.buscaPorId(idUsuario);
		
		int contador = empresaDao.contVagasPorEmpresa(idUsuario);
								
		//Enviando a lista para a pagina
		sessao.setAttribute("perfilEmpresa", empresa);
		
		//Enviando o contador de vagas
		sessao.setAttribute("contVagas", contador);
				
		//Envia o id para verificar se o perfil � do usu�rio ou de outro perfil
		sessao.setAttribute("idValida", idValidacao);
				
		UtilController.redirecionar(request, response, pagina);
	}	
	
	//Metodo para capturar parametros de formulario
	private Empresa capturarParametros(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("UTF-8");
		
		//Capturar os parametros do formulario
		String nome = request.getParameter("nomeEmpresa");
		String telefone = request.getParameter("telefoneEmpresa");
		String email = request.getParameter("emailEmpresa");
		String contato = request.getParameter("pessoaContato");
		String descricao = request.getParameter("descricaoEmpresa");
		String senha = request.getParameter("senhaEmpresa");
		String ramo = request.getParameter("descricaoRamo");
		int qtdFunc = Integer.parseInt(request.getParameter("nFunc"));
		

		//Instanciando novo objeto classe Empresa
		Empresa empresa = new Empresa();
		empresa.setSenha(senha);
		empresa.setEmail(email);
		empresa.setNome(nome);
		empresa.setTelefone(telefone);
		empresa.setPessoaContato(contato);
		empresa.setDescricao(descricao); 
		empresa.setRamoAtividade(ramo);
		empresa.setQtdfuncionarios(qtdFunc);
		JOptionPane.showMessageDialog(null, empresa.getNome());
		return empresa;
		
	}
	
	//M�todo para alterar a empresa
	private void alterarEmpresa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Executando a alteracao de endereco
		EnderecoController.alterarEndereco(request, response);
		
		//Instancia nova de empresa
		Empresa empresa= new Empresa();
		empresa = capturarParametros(request, response);
		
		int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
		
		//Atribuindo o id da empresa
		empresa.setId(idEmpresa);
				
		//Executar o m�todo de alterar a empresa
		empresaDao.alterarEmpresa(empresa);
		
		carregarPerfilEmpresa(request, response, idEmpresa, "empresa.jsp", idEmpresa);
		
	}
	
	private void alterarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Capturar a session atual
		HttpSession sessao = request.getSession();
		
		//Capturar o id do usuario logado
		int idEmpresa = (Integer)sessao.getAttribute("id");
		
		
		//Capturando a senha digitada
		String senhaNova = request.getParameter("senhaNova");
		
		//Capturando a senha informada
		String senhaDigitada = request.getParameter("senhaatual");
		
		//Executar a validacao e armazenar seu resultado
		boolean validaSenha = empresaDao.validarSenha(idEmpresa, senhaDigitada);
		
		if(validaSenha){
			empresaDao.alterarSenha(senhaNova, idEmpresa);
			response.sendRedirect("index.jsp");

		}else {
			response.sendRedirect("alterarSenha.jsp");
		}

	}
}
