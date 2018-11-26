package br.com.findlancer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
import br.com.findlancer.dao.FreelancerDAO;
import br.com.findlancer.model.Freelancer;
import br.com.findlancer.util.Acao;
import br.com.findlancer.util.UtilController; 


@WebServlet("/freelacontroller.do")
public class FreelancerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//Objeto da classe dao para realizar os metodos Dao de freelancer
    private FreelancerDAO freelancerDao = new FreelancerDAO();
     
    public FreelancerController() {
        super();         
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Capturar a acao que ser� executada
		String acaoGet = request.getParameter("acao");
		
		//Condicionar para ver se o usuario deseja visualizar o seu perfils
		if(acaoGet.equals(Acao.MEU_PERFIL.getConstante())){
			
			HttpSession sessao = request.getSession();
			int idUsuario = (int)sessao.getAttribute("id");
			
			//Chamando o m�todo que realiza a o carregamento dos dados
			carregarPerfilFreelancer(request, response,idUsuario,"freelancer.jsp",idUsuario);
				
		//Condicional para ver se o usuario quer visualizar o perfil de outro usuario
		}else if(acaoGet.equals(Acao.VER_PERFIL.getConstante())){
			
			int idUsuario = Integer.parseInt(request.getParameter("id"));
			carregarPerfilFreelancer(request, response, idUsuario, "freelancer.jsp",idUsuario);
		
		}else if(acaoGet.equals(Acao.EDITAR_PERFIL.getConstante())){
			
			HttpSession sessao = request.getSession();
			int idUsuario = (int)sessao.getAttribute("id");
			
			//Chamando o m�todo que realiza a o carregamento dos dados
			carregarPerfilFreelancer(request, response,idUsuario,"edfreela.jsp",idUsuario);
				
		}else if(acaoGet.equals(Acao.PESQ_FREELANCER.getConstante())){
	    	   
	    	   //Chamando o método de pesquisar freelancer
	    	   pesquisarFreelancer(request, response);
	    }else if(acaoGet.equals(Acao.PESQ_FREELACAT.getConstante())){
	    	
	    	//Chamando o metodo de pesquisa por categoria
	    	pesquisarPorCategoria(request, response);
	    }
	
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Capturando a acao que deve ser realizada
		String acaoPost = request.getParameter("acao");  
		
		//Condicional para ver se o usuario deseja cadastrar
		if(acaoPost.equals(Acao.CAD_FREELA.getConstante())){
			  
			//Chamando m�todo de cadastro
			cadastrarFreelancer(request, response);
	 	}	
	   //Condicional para verificar se o usuario deseja alterar o cadastro		    
	   else if(acaoPost.equals(Acao.ALT_FREELA.getConstante())){
		   
		   //Chamando m�todo que altera o freelancer
		   alterarFreelancer(request, response);
       }else if(acaoPost.equals(Acao.ALT_SENHA.getConstante())){
    	   
    	   //Chamando o método de alterar senha
    	   alterarSenha(request, response);
       }
 }
	
	//Metodo para carregar o perfil do freelancer
	private void carregarPerfilFreelancer(HttpServletRequest request, HttpServletResponse response,int idUsuario,String pagina,int idValidacao) throws ServletException, IOException{

		//Cria nova sessao para capturar a sessao atuak
		HttpSession sessao = request.getSession();
		
		//Instanciando objeto da classe Freelancer
		Freelancer freelancer = new Freelancer();
		
		//Execucao do m�todo buscar por id  e o armzenando seu retorno
		freelancer=freelancerDao.buscaPorId(idUsuario);
		
		//Enviando a lista para a pagina
		sessao.setAttribute("perfilFreelancer", freelancer);
		
		//Envia o id para verificar se o perfil � do usu�rio ou de outro perfil
		sessao.setAttribute("idValida", idValidacao);
		
		//Redirecionando para a pagina de meu perfil
		UtilController.redirecionar(request, response, pagina);
	
	}
	
	//M�todo para cadastrar freelancer
	private void cadastrarFreelancer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Instanciando novo objeto Freelancer
		Freelancer freelancer = new Freelancer();
		freelancer=capturarParametros(request, response);
	    
		//Capturando a fk do endereco cadastrado
		int fkEndereco=EnderecoController.cadastrarEndereco(request, response);
		
		//Atribuindo a fk do endereco cadastrado ao objeto freelancer antes de cadastra-lo
		freelancer.setFkEndereco(fkEndereco);
		
		//Executando metodo de cadastro
	    freelancerDao.Cadastrar(freelancer); 
	    
	    //Chamando o metodo de controle de login para validar o login recem cadastrado
	    LoginController.controlarLogin(request, response, freelancer.getEmail(), freelancer.getSenha());
	    
	}
	
	//Metodo para aletrar dados do freelancer
	private void alterarFreelancer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Chamando o metodo de alterar endereco
		EnderecoController.alterarEndereco(request, response);
		
		//Instanciando novo objeto freelancer
		Freelancer freelancer = new Freelancer();
		freelancer = capturarParametros(request, response);
		
		//Capturando parameter com id do freelancer
		int idFreelancer = Integer.parseInt(request.getParameter("idFreelancer"));
		
		//Atribuindo o id do freelancer
		freelancer.setId(idFreelancer);
		 
		//Executando metodo de alteracao
		freelancerDao.alterarFreelancer(freelancer);
		
		carregarPerfilFreelancer(request, response, idFreelancer, "freelancer.jsp", idFreelancer);
		
	}
	
	//Metodo para capturar parametros de formulario
	private Freelancer capturarParametros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parameters para tabela de freelancer
		String nascimento=request.getParameter("nascimento");
		int subcategoria=Integer.parseInt(request.getParameter("nsubcategoria"));
		String formacao=request.getParameter("formacaoFreela"); 
		String experiencia=request.getParameter("experienciaFreela");
		String nome=request.getParameter("nomeFreela");
		String telefone=request.getParameter("telefoneFreela");
		String email=request.getParameter("emailFreela");
		String senha=request.getParameter("senhaFreela");
		String descricao=request.getParameter("descricaoFreela");
		
		//Instanciando objeto da classe usuario e atribuindo os valores 
	    Freelancer freelancer = new Freelancer();
	    freelancer.setNome(nome);
	    freelancer.setSenha(senha); 
	    freelancer.setDescricao(descricao);
	    freelancer.setEmail(email);
	    freelancer.setExperiencia(experiencia);
	    freelancer.setFormacao(formacao);
	    freelancer.setNascimento(nascimento);
	    freelancer.setFksubcategoria(subcategoria);
	    freelancer.setTelefone(telefone); 
	    
	    return freelancer;
	}
	
	private void alterarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		//Capturando o id logado
		int idFreelancer = (Integer)sessao.getAttribute("id");
		
		//Capturando a senha digitada
		String senhaNova = request.getParameter("senhaNova");
		
		//Capturando a senha informada
		String senhaDigitada = request.getParameter("senhaatual");
		
		//Verificar se a senhas correspondem
		boolean validarSenha=freelancerDao.validarSenha(idFreelancer, senhaDigitada);
		
		if(validarSenha){
			freelancerDao.alterarSenha(senhaNova, idFreelancer);
			UtilController.redirecionar(request, response, "index.jsp");
		}else{
			UtilController.redirecionar(request, response, "alterarSenha.jsp");
		}
		
	}
	
	private void pesquisarFreelancer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Capturando a palavra digitada no formulario de pesquisa
		String palavra = request.getParameter("query");
		
		//Executando o método de pesquisa e armazenando seu retorno
		List<Freelancer> lista = freelancerDao.pesquisarFreelancer(palavra);
		
		//Capturando a session
		HttpSession sessao = request.getSession();
		
		//Enviando a lista para a session
		sessao.setAttribute("freelancers", lista);
		
		//Enviando a palavra para a session
		sessao.setAttribute("palavra", palavra);
		
		response.sendRedirect("freelancers.jsp");
		
		
	}
	
	private void pesquisarPorCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Capturando a palavra digitada no formulario de pesquisa
		String palavra = request.getParameter("p");
		
		//Armazenando a fk da categoria
		int idCategoria = Integer.parseInt(request.getParameter("ncategoria"));
		
		//Executando o método de pesquisa e armazenando seu retorno
		List<Freelancer> lista = freelancerDao.pesquisarPorCat(idCategoria, palavra);
		
		//Capturando a session
		HttpSession sessao = request.getSession();
		
		//Enviando a lista para a session
		sessao.setAttribute("freelancers", lista);
		
		//Enviando a palavra para a session
		sessao.setAttribute("palavra", palavra);
		
		response.sendRedirect("freelancers.jsp");
		
	}
	
}
