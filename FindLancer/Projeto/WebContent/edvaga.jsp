<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="br.com.findlancer.model.Vaga"%>
<%@ include file="topo.jsp" %>
<script  src="js/ajaxCategorias.js"></script>  
 <% 
 	//Armazenando a vaga da sessao
 	Vaga vaga = (Vaga)session.getAttribute("Vaga");

 	/*Verificar se o usuário que acessa a pagina de edicao de vaga
 	é realmente o proprietário da vaga*/
 	int idLogado = (Integer)session.getAttribute("id");
 	if(idLogado!=vaga.getFkEmpresa()){
 		response.sendRedirect("index.jsp");
 	}
 	
 	String descricao = Vaga.textoFormulario(vaga.getDescricao());
 	String experiencia = Vaga.textoFormulario(vaga.getExperiencia());
 	String formacao = Vaga.textoFormulario(vaga.getFormacao());
 %> 
          
           <div id="conteudo" class="conteudocadvaga">
                <div class="divback">
                    
                    <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>
                    
                      <form id="form-cad" class="form-inline" role="form" action="vagacontroller.do?acao=alterarvaga" method="post">
                    
                          <h1 id="titulo-cad">Anuncie sua vaga</h1>
                          
                          <div class="form-group"> 
                          	<label>Título da vaga:</label><br/>
                          	<input maxlength="100" type="text" name="titulo" value="<%= vaga.getTitulo() %>" id="titVaga" class="form-control">
                          </div>
                          
                          <div class="form-group"> 
                          	<label>Quantidade de vagas:</label><br/>
                          	<input  type="number" name="qtd" value="<%= vaga.getQuantidade() %>" id="qtdVaga" class="form-control">
                          </div>  
                          
                        <div class="form-group"> 
                          	<label>O que você precisa</label><br/>
                          	<textarea maxlength="250"  class="form-control" name="descricao" placeholder="Exemplo:Programador Front-End..."><%= descricao %>
                          	</textarea>
                        </div>
                        
                        <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input maxlength="250" type="text" name="email"  value="<%= vaga.getEmail() %>" class="form-control">
                         </div>
                        
	                      <div class="form-group">
	                         <label>Categoria de trabalho</label><br/>
	                         
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="<%=vaga.getSubcategoria().getFkCategoria()%>"><%= vaga.getSubcategoria().getCategoria().getDescricao() %></option>
	                         </select>
	                         
	                      </div>
	                     
	                      <div class="form-group">   
	                          <label>Subcategoria de trabalho</label>
	                          <br/>
	                          <select  class="form-control" name="nsubcategoria" id="subcat">
	                			<option value="<%= vaga.getFkSubcategoria()%>" ><%= vaga.getSubcategoria().getDescricao() %></option>
	                         </select>
	                      </div>
	                      
	                      
                          <div class="form-group"> 
                          	<label>Salário:</label><br/>
                          	<input type="text" name="salario"  value="<%= vaga.getSalario() %>" id="salario" class="form-control">
                        </div>
	                      <br/>	
	                    
	                    <div class="form-group">
	                        <label>Formação</label><br/>
	                        <textarea maxlength="250"  maxlength="250" class="form-control" name="formacao"  placeholder="Exemplo: Cursando Superior, Ensino Médio etc."><%= formacao %>
	                        </textarea>
	                    </div>
	                    <br/>
	                    
	                    <div class="form-group">
	                        <label>Experiência requerida</label><br/>
	                        <textarea   maxlength="250"  class="form-control" name="experiencia" placeholder="Exemplo: Experiência com programação Java..."><%= experiencia %>
	                        </textarea>
	                   	</div>  
	                   	 <br/>   
	                   	
	                   	<input  type="hidden" value="<%= vaga.getIdVaga()%>" name="id">
	                   	
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
                </div>
                </div>
<%@ include file="rodape.jsp" %>