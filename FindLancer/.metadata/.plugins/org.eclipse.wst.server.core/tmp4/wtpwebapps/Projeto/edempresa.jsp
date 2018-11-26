<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
<%@page import="br.com.findlancer.model.Empresa"%> 
<%@page import="br.com.findlancer.model.Usuarios"%>  
<script  src="js/ajax.js"></script> 
<% 

	//Capturando o objeto com o perfil na sessão e armazenando
	Empresa empresa = (Empresa)session.getAttribute("perfilEmpresa");
	String nome = empresa.getNome();
	String email = empresa.getEmail();
	String descricao = empresa.getDescricao();
	String telefone = empresa.getTelefone();
	String rua = empresa.getEndereco().getNomeRua();
	String estado = empresa.getEndereco().getCidade().getEstado().getSiglaEstado();
	String bairro = empresa.getEndereco().getBairro();
	int numero = empresa.getEndereco().getNumero();
	int cep = empresa.getEndereco().getCep();
	String cidade = empresa.getEndereco().getCidade().getNomeCidade();
	String ramo = empresa.getRamoAtividade();
	int qtd = empresa.getQtdfuncionarios();
	String pessoa = empresa.getPessoaContato();
	int fkestado = empresa.getEndereco().getCidade().getFk_estado();
	int fkcidade = empresa.getEndereco().getFk_cidade();
	int idLogado = (Integer)session.getAttribute("id");
	descricao = Usuarios.textoFormulario(descricao);
	ramo = Usuarios.textoFormulario(ramo);
	int fkendereco = empresa.getFkEndereco();
	int id  = (Integer)session.getAttribute("id");
%>


           <div id="conteudo" class="conteudocadempresa">
             <div class="divback">
                  <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>	
                 
                 <form id="form-cad" class="form-inline" role="form" action="empresacontroller.do?acao=alterarempresa" method="post">
                     <h1 id="titulo-cad">Edite seu cadastro</h1>    
                        
                        <div class="form-group"> 
                          	<label id="hnome">Nome:</label><br/>
                          	<input maxlength="50" value="<%= nome %>" type="text" name="nomeEmpresa" id="campoNome" class="form-control">
                        </div>
                        
                        <div class="form-group">
                        	<label id="hfone">Telefone:</label><br/>
                         	<input type="text" value="<%= telefone %>" name="telefoneEmpresa" id="fone"  class="form-control">
                         </div>
                        

                         <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input maxlength="100" value="<%= email %>" type="text" name="emailEmpresa" class="form-control">
                         </div>
                         
                          <div class="form-group">
                            <label>Pessoa para contato:</label><br/>
                            <input maxlength="50" type="text" value="<%= pessoa %>" name="pessoaContato" id=""  class="form-control">
                         </div>
                         
                         <div class="form-group">
	                          <label id="hendereco">Quantidade de funcionáros:</label><br/>
	                          <input value="<%= qtd %>"  type="number" name="nFunc"  class="form-control" id="numeroFunc">     
	                     </div>   
	                      <br/> 
                         
                         <div class="form-group"> 
                         	<label id="hbairro">Bairro:</label><br/>
                         	<input  maxlength="100" type="text" value="<%= bairro %>" name="nbairro"  class="form-control" id="bairro">
                         </div>
                         
                         <div class="form-group">                        
	                         <label id="hendereco">CEP:</label><br/>
	                         <input type="text" value="<%= cep %>" name="ncep"  class="form-control" id="cep"> 
	                     </div>   
	                     
	                        
	                     <div class="form-group">
	                          <label id="hendereco">Rua:</label><br/>
	                          <input maxlength="100" type="text" name="nrua" value="<%= rua %>" class="form-control" id="rua">     
	                     </div>  
	                       
	                     <div class="form-group">
	                          <label id="hendereco">Número:</label><br/>
	                          <input type="number" value="<%= numero %>" name="nnumero"  class="form-control" id="numerorua">     
	                     </div>   
	                      <br/> 
	                      
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
	                        <label>Descreva a empresa:</label><br/>
	                        <textarea maxlength="250" class="form-control" name="descricaoEmpresa" placeholder=" "><%= descricao %></textarea>
	                    </div>
	                    
	                    <div class="form-group">
	                        <label>Ramo de atividade:</label><br/>
	                        <textarea maxlength="250" class="form-control" name="descricaoRamo" placeholder="Exemplo: Desenvolvimento WEB"><%= ramo %>
	                        </textarea>
	                    </div>
	                    <br/>
	                    
	                     <input type="hidden" name="idEmpresa" value="<%= id %>">
	                   	 <input type="hidden" name="idEndereco" value="<%= fkendereco %>" >
	                  
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
          </div> 
    </div>
    
<%@ include file="rodape.jsp" %>