package br.com.findlancer.controller;

import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.findlancer.dao.LoginDAO;
import br.com.findlancer.util.Acao;
import br.com.findlancer.util.UtilController;
 
@WebServlet("/logincontroller.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginController() {
        super();
       
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao=request.getParameter("acao");
		
		if(acao.equals(Acao.LOGOUT.getConstante())){
			
			LoginDAO.nivel=0;
			HttpSession sessao = request.getSession();
			sessao.invalidate();
		
			UtilController.redirecionar(request, response, "index.jsp");
		
		}else{
			
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("autenticaremail")){
			String  email = request.getParameter("email");
			
			LoginDAO login = new LoginDAO();
			boolean emailExistente=login.autenticarEmail(email);
			
			Gson conversor = new Gson();
			String autenticao = conversor.toJson(emailExistente);
			 
			
			//Retornando boolean para o ajax
			PrintWriter out = response.getWriter();
			out.println(autenticao);
			
		}
		if(acao.equals(Acao.LOGAR.getConstante())){
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			controlarLogin(request, response, email, senha);
		
		}	
	}
	
	public static void controlarLogin(HttpServletRequest request, HttpServletResponse response,String email,String senha) throws ServletException, IOException{
		
		int idUsuario=0;
		LoginDAO login = new LoginDAO();
		idUsuario=login.logar(email, senha);

		if (idUsuario!=0){
			
			 String nome=login.retornaNomePeloId(LoginDAO.nivel, idUsuario);
			
			 HttpSession sessao = request.getSession(); 
			 
			 sessao.setAttribute("id", idUsuario );
			 sessao.setAttribute("nomeUsu", nome);
			 sessao.setAttribute("nivelUsu", LoginDAO.nivel);
			 
			 UtilController.redirecionar(request, response, "index.jsp");
			 
		}else{
			
			UtilController.redirecionar(request, response, "erroLogin.jsp");	
			
		}
	}
	
	}


