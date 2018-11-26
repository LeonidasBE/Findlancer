<%@ include file="topo.jsp" %>
<script  src="js/ajaxCategorias.js"></script> 
<% 
	//Capturando id da empresa logada
	int id  = (Integer)session.getAttribute("id");

%>

           <div id="conteudo" class="conteudocadvaga">
                <div class="divback">
                    
                    <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>
                    
                      <form id="form-cad" class="form-inline" role="form" action="vagacontroller.do?acao=cadastrarvaga" method="post">
                    
                          <h1 id="titulo-cad">Anuncie sua vaga</h1>
                          
                          <div class="form-group"> 
                          	<label>Título da vaga:</label><br/>
                          	<input maxlength="100" type="text" name="titulo" id="titVaga" class="form-control">
                          </div>
                          
                          <div class="form-group"> 
                          	<label>Quantidade de vagas:</label><br/>
                          	<input type="number" name="qtd" id="qtdVaga" class="form-control">
                          </div>  
                          
                        <div class="form-group"> 
                          	<label>O que você precisa</label><br/>
                          	<textarea maxlength="250" class="form-control" name="descricao" placeholder="Exemplo:Programador Front-End - para desenvolver web para minha empresa."></textarea>
                        </div>
                        
                        <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input type="text" name="email"  class="form-control">
                         </div>
                        
	                      <div class="form-group">
	                         <label>Categoria de trabalho</label><br/>
	                         
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="">Selecione uma categoria</option>
	                         </select>
	                         
	                      </div>
	                     
	                      <div class="form-group">   
	                          <label>Subcategoria de trabalho</label>
	                          <br/>
	                          <select  class="form-control" name="nsubcategoria" id="subcat">
	                          
	                			<option value="" >Selecione uma subcategoria</option>
	                			
	                         </select>
	                      </div>
	                      
	                      
                          <div class="form-group"> 
                          	<label>Salário:</label><br/>
                          	<input type="text" name="salario" id="salario" class="form-control">
                        </div>
	                      <br/>	
	                    
	                    <div class="form-group">
	                        <label>Formação</label><br/>
	                        <textarea  maxlength="250"  class="form-control" name="formacao" placeholder="Exemplo: Cursando Superior, Ensino Médio etc."></textarea>
	                    </div>
	                    <br/>
	                    
	                    <div class="form-group">
	                        <label>Experiência requerida</label><br/>
	                        <textarea maxlength="250"  class="form-control" name="experiencia" placeholder="Exemplo: Vendedor de carros, Programador Java etc."></textarea>
	                   	</div>  
	                   	 <br/>   
	                   	
	                   	<input  type="hidden" value="<%= id %>" name="idEmpresa">
	                   	
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
                </div>
                </div>
    
<%@ include file="rodape.jsp" %>