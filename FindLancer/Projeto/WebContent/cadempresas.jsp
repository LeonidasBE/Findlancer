<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="topo.jsp" %> 
<script  src="js/ajax.js"></script> 

          <div id="conteudo" class="conteudocadempresa">
             <div class="divback">
                  <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>
                     	
                 <form id="form-cad"  class="form-inline" role="form" action="empresacontroller.do?acao=cadastrarempresa" method="post">
                 <h1 id="titulo-cad">Cadastre sua empresa</h1>    
                        
                        <div class="form-group"> 
                          	<label id="hnome">Nome:</label><br/>
                          	<input maxlength="50" type="text" name="nomeEmpresa" id="campoNome" class="form-control">
                        </div>
                        
                        <div class="form-group">
                        	<label id="hfone">Telefone:</label><br/>
                         	<input type="text" name="telefoneEmpresa" id="fone"  class="form-control">
                         </div>
                        

                         <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input type="text" maxlength="100" name="emailEmpresa" id="email"  class="form-control">
                         </div>
                         
                          <div class="form-group">
                            <label>Pessoa para contato:</label><br/>
                            <input type="text" maxlength="50" name="pessoaContato" id=""  class="form-control">
                         </div>
                         
                               
	                     <div class="form-group">
	                          <label id="hendereco">Quantidade de funcionáros:</label><br/>
	                          <input type="number" name="nFunc"  class="form-control" id="qtdFunc">     
	                     </div>   
	                      <br/> 
                         
                         <div class="form-group"> 
                         	<label id="hbairro">Bairro:</label><br/>
                         	<input type="text" maxlength="100" name="nbairro"  class="form-control" id="bairro">
                         </div>
                         
                         <div class="form-group">                        
	                         <label id="hendereco">CEP:</label><br/>
	                         <input type="text" name="ncep"  class="form-control" id="cep"> 
	                     </div>   
	                     
	                        
	                     <div class="form-group">
	                          <label id="hendereco">Rua:</label><br/>
	                          <input type="text" name="nrua" maxlength="100" class="form-control" id="rua">     
	                     </div>  
	                       
	                     <div class="form-group">
	                          <label id="hendereco">Número:</label><br/>
	                          <input type="number" name="nnumero"  class="form-control" id="numerorua">     
	                     </div>   
	                      <br/> 
	                      
	                    <div class="form-group">     
	                         <label>Estado</label><br/>
	                         <select  class="form-control" name="nestado" id="estado">
	                    		<option value="">Selecione seu estado</option>
	                         </select>
	                      </div>
	                      
	                        <div class="form-group">     
	                         <label>Cidade</label><br/>
	                         <select  class="form-control" name="ncidade" id="cidades">
	                    		<option value="">Selecione sua cidade</option>
	                         </select>
	                      </div>
	                      
	                      <div class="form-group">
	                        <label>Senha:</label><br/>
	                        <input type="password" maxlength="100" name="senhaEmpresa"  class="form-control" id="senha"> 
	                      </div>	
	                    
	                    <div class="form-group">	
	                        <label>Repita sua senha:</label><br/>
	                        <input class="form-control" type="password"  id="senha2">
	                    </div>
	                    <br/>
	                      
						<div class="form-group">
	                        <label>Descreva a empresa:</label><br/>
	                        <textarea maxlength="250" class="form-control" name="descricaoEmpresa" placeholder=" "></textarea>
	                    </div>
	                    
	                    <div class="form-group">
	                        <label>Ramo de atividade:</label><br/>
	                        <textarea  maxlength="250" class="form-control" name="descricaoRamo" placeholder="Exemplo: Desenvolvimento WEB"></textarea>
	                    </div>
	                    <br/>
	                  
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
          </div> 
    </div>
    
<%@ include file="rodape.jsp" %>