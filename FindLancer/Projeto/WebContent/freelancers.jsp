<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
<%@page import="br.com.findlancer.model.Freelancer"%>
<%@page import="java.util.ArrayList"%>  
<%@page import="java.util.List;"%> 
<script  src="js/ajaxCategorias.js"></script>  


<% 

	List<Freelancer> lista = (List<Freelancer>)session.getAttribute("freelancers");
	int contador = lista.size();
	String palavra = (String)session.getAttribute("palavra");
%>

           <div id="conteudo" class="conteudoresultado">
               <div id="bgResultados">
               	   <% 
               	   		if(!palavra.equals("")){
               	   %>
                   <h1><%= contador %> resultados para '<%= palavra %>'</h1>
    			   <%}else{%>
    				   <h1>Todos os freelancers</h1>
    			   <% 	   
    			   	} 
    			   %>
    			   <hr>
    			   <form action="freelacontroller.do">
	                      <div class="form-group">
	                         <label>Categoria de trabalho</label><br/>
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="">Selecione uma categoria</option>
	                         </select>
	                      </div>
	                      <input type="hidden" value="pesqfreelacat" name="acao">
	                      <input type="hidden" value="<%= palavra %>" name="p">
    			   		  <input type="submit" id="btFiltro" value="Filtrar">
    			   </form>
    			<%
    				for(Freelancer freelancer : lista){
					String inicialNome = freelancer.getNome().substring(0, 1);
					inicialNome= inicialNome.toUpperCase();
    			%>               
                   <div id="anuncio">
                       
                       <div id="divImagem">
                              <div class="fotoVaga" ><p><%= inicialNome%></p></div>  
                       </div>
                       <div id="conteudoAnuncio">
                         <a href="freelacontroller.do?acao=viewperfil&id=<%= freelancer.getId() %>" class="linkAnuncio" id="linkTitulo"><%= freelancer.getNome() %></a> 
                         <p><%= freelancer.getDescricao() %></p>  
                       </div>       
                   </div>   
             <%
    				}
             %>
               </div>
          </div>          
<%@ include file="rodape.jsp" %>
          