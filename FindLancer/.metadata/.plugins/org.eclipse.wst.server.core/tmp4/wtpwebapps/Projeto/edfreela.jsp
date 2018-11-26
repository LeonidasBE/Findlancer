<%@page import="br.com.findlancer.model.Usuarios"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="br.com.findlancer.model.Freelancer"%>  
<%@ include file="topo.jsp" %>
<script  src="js/ajaxCategorias.js"></script> 
<script  src="js/ajax.js"></script> 
   

    
    	 <% 
                  	 /*Instanciando novo objeto freelancer e armazenando 
                  	 o perfil enviado peloe controller*/	 
                 	 Freelancer freelancer = (Freelancer)session.getAttribute("perfilFreelancer");
                  
                     //Variaveis para receber os dados
                  	 String nome = freelancer.getNome();
                     String formacao = freelancer.getFormacao();
                     String experiencia = freelancer.getExperiencia();
                     String descricao = freelancer.getDescricao();
                     String cidade = freelancer.getEndereco().getCidade().getNomeCidade();
                     String estado = freelancer.getEndereco().getCidade().getEstado().getSiglaEstado();
                     int fkestado = freelancer.getEndereco().getCidade().getFk_estado();
                   	 int fkcidade = freelancer.getEndereco().getFk_cidade();
                     int fksubcategoria = freelancer.getFksubcategoria();
                     int fkendereco = freelancer.getFkEndereco();
                   	 String rua = freelancer.getEndereco().getNomeRua();
                     String bairro = freelancer.getEndereco().getBairro();
                     int numero = freelancer.getEndereco().getNumero();
                     int cep = freelancer.getEndereco().getCep();
                     int idade = freelancer.getIdade();
                     String email = freelancer.getEmail(); 
                     String telefone = freelancer.getTelefone();
                     String subcategoria = freelancer.getSubcategoria().getDescricao();
                     String categoria = freelancer.getSubcategoria().getCategoria().getDescricao();
                     String nascimento = freelancer.dataParaFormulario(freelancer.getNascimento());
                     experiencia = Usuarios.textoFormulario(experiencia);
                     formacao = Usuarios.textoFormulario(formacao);
                     descricao = Usuarios.textoFormulario(descricao);
                     int id  = (Integer)session.getAttribute("id");
                     
                    %>
    
           <div id="conteudo" class="conteudocadfreela">
             <div class="divback">
                 
                
                 <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>
                 
                 <form id="form-cad" class="form-inline" role="form" action="freelacontroller.do?acao=alterarFreela" method="post">
                 <h1 id="titulo-cad">Edite seu perfil</h1>
                        <div class="form-group"> 
                          	<label>Nome</label><br/>
                          	<input maxlength="100" value="<%=nome %>" type="text" name="nomeFreela" id="campoNome" class="form-control">
                        </div>
                        
                        <div class="form-group">
                        	<label>Telefone:</label><br/>
                         	<input type="text" value="<%= telefone%>" name="telefoneFreela" id="fone"  class="form-control">
                         </div>
                         <br/>
                         
                         <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input  maxlength="100" type="text" value="<%= email %>" name="emailFreela" class="form-control">
                         </div>
                         
                          
                         <div class="form-group"> 
                            <label>Data de nascimento:</label><br/>
                            <input type="text" value="<%= nascimento %>"  id="datepicker" name="nascimento"   class="form-control"  readonly>
                         </div>
                        
                         
                         <div class="form-group"> 
                         	<label id="hbairro">Bairro:</label><br/>
                         	<input maxlength="100" type="text" value="<%= bairro %>" name="nbairro"  class="form-control" id="bairro">
                         </div>
                         
                         <div class="form-group">                        
	                         <label id="hendereco">CEP:</label><br/>
	                         <input type="text" name="ncep" value="<%= cep %>" class="form-control" id="cep"> 
	                     </div>   
	                     
	                        
	                     <div class="form-group">
	                          <label id="hendereco">Rua:</label><br/>
	                          <input maxlength="100" type="text" value="<%= rua %>" name="nrua"  class="form-control" id="rua">     
	                     </div>  
	                       
	                     <div class="form-group">
	                          <label id="hendereco">Número:</label><br/>
	                          <input type="number" name="nnumero" value="<%= numero %>"  class="form-control" id="numerorua">     
	                     </div>   
	                      
	                      <div class="form-group">     
	                         <label>Estado</label><br/>
	                         <select  class="form-control" name="nestado" id="estado">
	                    		<option value="<%= fkestado %>"><%= estado %></option>
	                         </select>
	                      </div>
	                      
	                        <div class="form-group">     
	                         <label>Cidade</label><br/>
	                         <select  class="form-control" name="ncidade" id="cidades">
	                    		<option value="<%= fkcidade %>"><%= cidade %></option>
							</select>
	                      </div>
	                      
	                      <div class="form-group">     
	                         <label>Categorias de trabalho</label><br/>
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="<%= categoria %>"><%= categoria %></option>
	                         </select>
	                      </div>
	                     
	                       
	                      <div class="form-group">   
	                          <label>Subcategoria de trabalho</label><br/>
	                          <select  class="form-control" name="nsubcategoria" id="subcat">
	                			<option value="<%= fksubcategoria %>" ><%=subcategoria %></option>
	                         </select>
	                      </div>    
	                      <br/>	
	                      
						<div class="form-group">
	                        <label>Descreva seu trabalho.</label><br/>
	                        <textarea maxlength="250"  class="form-control"  name="descricaoFreela" placeholder="Exemplo: Programador - PHP,JAVA e etc."><%= descricao %>
	                        </textarea>
	                    </div>
	                    <br/>
	                    
	                    <div class="form-group">
	                        <label>Formação</label><br/>
	                        <textarea  maxlength="250" class="form-control" value="" name="formacaoFreela" placeholder="Exemplo: Cursando Superior, Ensino Médio etc."><%= formacao %>
	                        </textarea>
	                    </div>
	                    <br/>
	                         
	                    <div class="form-group">     
	                        <label>Exp. profissional</label><br/>
	                        <textarea maxlength="250"  class="form-control"  name="experienciaFreela" placeholder="Exemplo: Vendedor de carros, Programador Java etc."><%= experiencia %>
	                        </textarea>
	                   	</div>  
	                   	 <br/>   
	                   	 
	                   	 <input type="hidden" name="idFreelancer" value="<%= id %>">
	                   	 <input type="hidden" name="idEndereco" value="<%= fkendereco %>" >
	                   	 
	                   	 
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
             </div>     
          </div>

<%@ include file="rodape.jsp" %>
