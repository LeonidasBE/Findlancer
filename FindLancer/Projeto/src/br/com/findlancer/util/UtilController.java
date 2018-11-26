package br.com.findlancer.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import com.google.gson.Gson; 
import br.com.findlancer.dao.CategoriaDAO;
import br.com.findlancer.dao.CidadeDAO;
import br.com.findlancer.dao.EstadoDAO;
import br.com.findlancer.dao.SubcategoriaDAO;
import br.com.findlancer.model.Categoria;
import br.com.findlancer.model.Cidade;
import br.com.findlancer.model.Estado;
import br.com.findlancer.model.Subcategoria;

 
@WebServlet("/utilcontroller.do")
public class UtilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UtilController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcao = request.getParameter("o");
		
		if(opcao.equals(Acao.FCAT.getConstante())){
			//Realiza a busca de categorias
			buscadeCategorias(request, response);
		}else if(opcao.equals(Acao.FSUB.getConstante())){
			//Realiza a busca de subcategorias
			buscadeSubcategorias(request, response); 
		}else if(opcao.equals(Acao.FEST.getConstante())){
			//Realiza a busca de estados
			buscadeEstados(request, response); 
		}else if(opcao.equals(Acao.FCID.getConstante())){
			//Realiza a busca de cidades
			buscadeCidades(request, response);
			System.out.println("ENTROU CIDADES");
		}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void buscadeCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException {
			//Lista para
			ArrayList<Categoria> lista = new ArrayList<Categoria>();
				
			//Instancia objeto do tipo CategoriaDAO para realizar o select
			CategoriaDAO categoriadao = new CategoriaDAO();
				
			//Executa metodo popularCategoria e armazena numa list<Categorias>
			lista=categoriadao.popularCategorias();
				
			Gson gson1 = new Gson();
			String listaCat = gson1.toJson(lista);
				
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(listaCat);
				 
	}

	private void buscadeSubcategorias(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//Recebe a fk da categoria atual
		int fk = Integer.parseInt(request.getParameter("valor"));
		
		//Nova lista para armazenar subcategorias
		ArrayList<Subcategoria> lista = new ArrayList<Subcategoria>();
		
		//Instanciando objeto SubcategoriasDAO para retornar a lista com o metodo popularSubcategorias
		SubcategoriaDAO subcategoriasDAO = new SubcategoriaDAO();
		
		//Executando o metodo e armazenando na nova lista
		lista = subcategoriasDAO.popularSubcategorias(fk);
		
		//Instanciando objeto da classe gson.google
		Gson conversor = new Gson();
		
		//convertendo de arraylist para JSON
		String json = conversor.toJson(lista);
		
		//Retornando lista para o ajax
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json);
	}
	
	private void buscadeCidades(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int fk = Integer.parseInt(request.getParameter("fk"));
		
		//Lista para armazenar objetos ca classe estados
		ArrayList<Cidade> listadeCidades = new ArrayList<Cidade>();
		
		//Instancia objeto do tipo EstadosDAO para realizar o select
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		//Executa metodo popularCategoria e armazena numa list<Estados>
		listadeCidades=cidadeDAO.popularCidades(fk);
		
		//Instaciar objeto gson para converter a listaEstados para json
		Gson gson = new Gson();
		String listaCidades= gson.toJson(listadeCidades); 
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(listaCidades);
	}

	private void buscadeEstados(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Lista para armazenar objetos ca classe estados
		ArrayList<Estado> lista = new ArrayList<Estado>();
		
		//Instancia objeto do tipo EstadosDAO para realizar o select
		EstadoDAO estadoDAO = new EstadoDAO();
		
		//Executa metodo popularCategoria e armazena numa list<Estados>
		lista=estadoDAO.popularEstados();
		
		//Instaciar objeto gson para converter a listaEstados para json
		Gson gson = new Gson();
		String listaEstados = gson.toJson(lista);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(listaEstados);
		
	}
	
	public static void redirecionar(HttpServletRequest request, HttpServletResponse response,String pagina) throws ServletException, IOException {
		
		response.sendRedirect(pagina);
	}
}
