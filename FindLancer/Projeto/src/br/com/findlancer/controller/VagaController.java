package br.com.findlancer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.findlancer.dao.VagaDAO;
import br.com.findlancer.model.Vaga;
import br.com.findlancer.util.Acao;
import br.com.findlancer.util.UtilController;

@WebServlet("/vagacontroller.do")
public class VagaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Instanciar objeto da classe VagaDAO
	private VagaDAO vagaDao = new VagaDAO();

	public VagaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		if (acao.equals(Acao.MINHAS_VAGAS.getConstante() ) ) {
			
			HttpSession sessao = request.getSession();
			
			int idEmpresa = (Integer)sessao.getAttribute("id");
			
			carregarVagas(request, response,idEmpresa);
			
		} else if (acao.equals(Acao.PERFIL_VAGAS.getConstante() ) ) {
			
			carregarVaga(request, response,"perfilVagas.jsp");
		
		}else if(acao.equals(Acao.ALT_VAGA.getConstante())){
			
			carregarVaga(request, response,"edvaga.jsp");
			
		}else if(acao.equals(Acao.DEL_VAGA.getConstante())){
			
			deletarVaga(request, response);
			
		}else if(acao.equals(Acao.PESQ_VAGA.getConstante())){
			 
			pesquisarVaga(request, response);
			
		}else if(acao.equals(Acao.VAGAFCAT.getConstante())){
			
			pesquisarPorCategoria(request, response);
			
		}else if(acao.equals(Acao.VER_VAGAS.getConstante())){
			
			int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
			
			carregarVagas(request, response, idEmpresa);
			
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String acao = request.getParameter("acao");

		// Condicional
		if (acao.equals(Acao.CAD_VAGA.getConstante())) {
			
			cadastrarVaga(request, response);
			
		}else if(acao.equals(Acao.ALT_VAGA.getConstante())){
			
			alterarVaga(request, response, "index.jsp");
			
		} 
	}

	private Vaga capturarParametros(HttpServletRequest request, HttpServletResponse response) {

		// Capturar os parametros do formulario
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String email = request.getParameter("email");
		int fksubcategoria = Integer.parseInt(request.getParameter("nsubcategoria"));
		String formacao = request.getParameter("formacao");
		String experiencia = request.getParameter("experiencia");
		String salario = request.getParameter("salario");
		int qtd = Integer.parseInt(request.getParameter("qtd"));
		 

		Vaga vaga = new Vaga();
		vaga.setDescricao(descricao);
		vaga.setEmail(email); 
		vaga.setFkSubcategoria(fksubcategoria);
		vaga.setFormacao(formacao);
		vaga.setExperiencia(experiencia);
		vaga.setTitulo(titulo);
		vaga.setSalario(salario);
		vaga.setQuantidade(qtd);

		return vaga;
	}

	private void cadastrarVaga(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		int fkempresa = Integer.parseInt(request.getParameter("idEmpresa"));

		// Nova instancia de vaga
		Vaga vaga = new Vaga();

		// Chamando m�todo para capturar parametros e atribuir o objeto
		vaga = capturarParametros(request, response);

		// Atribuindo a fk da empresa
		vaga.setFkEmpresa(fkempresa);
		
		//Executando metodo de cadastro
		vagaDao.cadastrarVaga(vaga);

		UtilController.redirecionar(request, response, "index.jsp");
	}

	public void carregarVagas(HttpServletRequest request, HttpServletResponse response,int idEmpresa)
			throws ServletException, IOException {
		
		//Capturando a sessao atual
		HttpSession sessao = request.getSession();

		// Criar nova lista de vagas
		List<Vaga> vagas = new ArrayList<Vaga>();
		
		//Executando metodo de busca de vagas e armazenando o retorno
		vagas = vagaDao.buscarVagasPorEmpresa(idEmpresa);
		
		//Enviando o list com as vagas da empresa para a sessao
		sessao.setAttribute("lista", vagas);

		// Redirecionando para a pagina com a lista de vagas
		UtilController.redirecionar(request, response, "vagas.jsp");

	}

	private void carregarVaga(HttpServletRequest request, HttpServletResponse response,String pagina)
			throws ServletException, IOException {
		
		//Capturando sess�o atual
		HttpSession sessao = request.getSession();

		// Capturando id
		int id = Integer.parseInt(request.getParameter("id"));

		//Realizando a busca da vaga por id
		Vaga vaga = vagaDao.buscarVagaPorId(id);
		
		// Criar nova lista de vagas
		List<Vaga> listaDeVagas = new ArrayList<Vaga>();
		listaDeVagas = vagaDao.buscarVagasPorCategoria(vaga.getSubcategoria().getFkCategoria()); 
		

		//Enviando a lista de vagas para a sessao
		sessao.setAttribute("listaDeVagas", listaDeVagas);
		
		//Enviando o objeto vaga para a sessao
		sessao.setAttribute("Vaga", vaga);

		// Redirecionando para a pagina de perfil da vaga
		UtilController.redirecionar(request, response,pagina);
		 
	}

	private void alterarVaga(HttpServletRequest request, HttpServletResponse response,String pagina) throws ServletException, IOException{
		
		Vaga vaga = capturarParametros(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		vaga.setIdVaga(id);
		
		HttpSession sessao = request.getSession();
		
		int idEmpresa = (Integer)sessao.getAttribute("id");
		
		vagaDao.alterarVaga(vaga);
		
		carregarVagas(request, response,idEmpresa);
		
	}
	
	private void deletarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession sessao = request.getSession();
		
		int idEmpresa = (Integer)sessao.getAttribute("id");
		
		vagaDao.excluirVaga(id);
		
		carregarVagas(request, response,idEmpresa);
	}
	
	//Pesquisar vaga por palavra chave
	private void pesquisarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Capturando sessao atual
		HttpSession sessao = request.getSession();
		 
		//Capturando a palavra digitada na barra de pesquisa
		String palavra = request.getParameter("query");
		
		sessao.setAttribute("palavraChave", palavra);
		
		//Realizando a pesquisa por palavra chave e armazenando em uma nova lista
		List<Vaga> vagas = vagaDao.pesquisarVaga(palavra);
		
		//Criando uma lista na sessao e armazenando a lista de vagas acima
		sessao.setAttribute("vagas", vagas);
		
		//Redirecionando para a pagina de resultados
		UtilController.redirecionar(request, response, "resultados.jsp");
		
	}

	private void pesquisarPorCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		
		String palavra = request.getParameter("p");
	 
		int fkCategoria = Integer.parseInt(request.getParameter("ncategoria"));
		
		List<Vaga> vagas = vagaDao.filtrarVaga(fkCategoria, palavra); 
		
		sessao.setAttribute("vagas", vagas);
		
		sessao.setAttribute("palavraChave", palavra);
		
		//Redirecionando para a pagina de resultados
		UtilController.redirecionar(request, response, "resultados.jsp");
		
		
	}
	
}


