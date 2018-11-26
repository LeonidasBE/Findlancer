package br.com.findlancer.filtros;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}	
					, urlPatterns = { "/edempresa.jsp","/cadvaga.jsp","/edvaga.jsp","/resultados.jsp",
					"/myperfilEmpresa.jsp","/myperfilFreela.jsp","/vagas.jsp","/perfilVagas.jsp"		
}
)
public class FiltroLogin implements Filter {

    
    public FiltroLogin() {
        
    }

	 
	public void destroy() {
		 
	}

	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest) request;
				
		//Verificar se o usuário está logado
		HttpSession sessao = request2.getSession();
		
		
		String url = request2.getRequestURI();
		
		if(sessao.getAttribute("id")!=null || url.lastIndexOf("index.jsp")>-1){
			chain.doFilter(request, response);
		}else{
			//Redirecionar para login
			((HttpServletResponse) response).sendRedirect("erroLogin.jsp");
		}
		
	}

	 
	public void init(FilterConfig fConfig) throws ServletException {
		 
	}

}
