<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
<%@page import="br.com.findlancer.model.Vaga"%>
<%@page import="java.util.ArrayList"%>  
<%@page import="java.util.List;"%> 
<script  src="js/ajaxCategorias.js"></script>  


<% 

	List<Vaga> resultados = (List<Vaga>)session.getAttribute("vagas");
	int contador = resultados.size();
	String palavra = (String)session.getAttribute("palavraChave"); 
%>

           <div id="conteudo" class="conteudoresultado">
               <div id="bgResultados">
               	   <% 
               	   		if(!palavra.equals("")){
               	   %>
                   <h1><%= contador %> resultados para '<%= palavra %>'</h1>
    			   <%}else{%>
    				   <h1>Todas as vagas</h1>
    			   <% 	   
    			   	} 
    			   %>
    			   <hr>
    			   <form action="vagacontroller.do">
	                      <div class="form-group">
	                         <label>Categoria de trabalho</label><br/>
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="">Selecione uma categoria</option>
	                         </select>
	                      </div>
	                      <input type="hidden" value="buscaporcat" name="acao">
	                      <input type="hidden" value="<%= palavra %>" name="p">
    			   		  <input type="submit" id="btFiltro" value="Filtrar">
    			   </form>
    			<%
    				for(Vaga vaga : resultados){
					String inicialTitulo = vaga.getTitulo().substring(0, 1);
					inicialTitulo = inicialTitulo.toUpperCase();
    			%>               
                   <div id="anuncio">
                       
                       <div id="divImagem">
                              <div class="fotoVaga" ><p><%= inicialTitulo %></p></div>  
                       </div>
                       <div id="conteudoAnuncio">
                         <a href="vagacontroller.do?acao=perfilvaga&id=<%= vaga.getIdVaga() %>" class="linkAnuncio" id="linkTitulo"><%= vaga.getTitulo() %></a> 
                         <p><%= vaga.getDescricao() %></p>  
                       </div>       
                   </div>   
             <%
    				}
             %>
               </div>
          </div>          
<%@ include file="rodape.jsp" %>
          