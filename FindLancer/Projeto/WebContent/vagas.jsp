<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
<%@page import="br.com.findlancer.model.Vaga"%>
<%@page import="java.util.ArrayList"%>  
<%@page import="java.util.List;"%>  


<% 
	List<Vaga> vagas = (List<Vaga>)session.getAttribute("lista");
	int idLogado = (Integer)session.getAttribute("id");
	int nivel = (Integer)session.getAttribute("nivelUsu");
%>


           <div id="conteudo" class="conteudovagas">
               <div id="bgVagas">
                <% 

                  if((idLogado == vagas.get(0).getEmpresa().getId()) && (nivel==2) ){
                %>
                	<h1>Suas vagas</h1>
				<% 
                  }else{
				%>
                   <h1>Vagas de <%= vagas.get(0).getEmpresa().getNome() %></h1>
				
<%		
                  }
for(Vaga vaga : vagas){
%>
                   <div id="anuncio">
                       <div id="conteudoAnuncio">
                           <a class="linkAnuncio" href="vagacontroller.do?acao=perfilvaga&id=<%= vaga.getIdVaga() %>" id="linkTitulo"><%= vaga.getTitulo() %></a>
                              
                        	<div class="codvaga">cod.<%= vaga.getIdVaga() %></div>
                            
                       	 	<div id="textoDesc-minhasVagas">   
                            	<h3>Descrição</h3>
                           		 <p><%= vaga.getDescricao() %></p>
                      		  </div> 
                        
                        	<h3 id="salvaga">Salário: R$<%= vaga.getSalario() %></h3>

                       		<div id="qtdVagas">
                            	<h3>Nº de vagas: <%= vaga.getQuantidade() %></h3>
                      		</div> 
                       </div>   
                       
                   </div> 
<%
}
%>                     
               </div>
              
          </div>        
    
<%@ include file="rodape.jsp" %>