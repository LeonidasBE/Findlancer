<%@ include file="topo.jsp" %>
<script  src="js/ajaxCategorias.js"></script> 
<script  src="js/ajax.js"></script> 
 
          <div id="conteudo" class="conteudocadfreela">
             <div class="divback">
                 
                
                 <div id="msgalerta"><p id="alerta"></p><a id="btok">OK</a></div>
                 
                 <form id="form-cad" class="form-inline" role="form" action="freelacontroller.do?acao=cadastrarfreela" method="post">
                 <h1 id="titulo-cad">Cadastro Freelancer</h1>   
                        <div class="form-group"> 
                          	<label id="hnome">Nome</label><br/>
                          	<input maxlength="50" type="text" name="nomeFreela" id="campoNome" class="form-control">
                        </div>
                        
                        <div class="form-group">
                        	<label id="hfone">Telefone:</label><br/>
                         	<input type="text" name="telefoneFreela" id="fone"  class="form-control">
                         </div>
                         <br/>
                         
                         <div class="form-group">
                            <label>E-mail:</label><br/>
                            <input maxlength="100" type="text" name="emailFreela" id="email"  class="form-control">
                         </div>
                         
                          
                         <div class="form-group"> 
                            <label>Data de nascimento:</label><br/>
                            <input type="text" id="datepicker" name="nascimento"class="form-control" readonly>
                         </div>
                        
                         
                         <div class="form-group"> 
                         	<label id="hbairro">Bairro:</label><br/>
                         	<input maxlength="100" type="text" name="nbairro"  class="form-control" id="bairro">
                         </div>
                         
                         <div class="form-group">                        
	                         <label id="hendereco">CEP:</label><br/>
	                         <input type="text" name="ncep"  class="form-control" id="cep"> 
	                     </div>   
	                     
	                        
	                     <div class="form-group">
	                          <label id="hendereco">Rua:</label><br/>
	                          <input maxlength="100" type="text" name="nrua"  class="form-control" id="rua">     
	                     </div>  
	                       
	                     <div class="form-group">
	                          <label id="hendereco">N�mero:</label><br/>
	                          <input  type="number" name="nnumero"  class="form-control" id="numerorua">     
	                     </div>   
	                      
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
	                         <label>Categorias de trabalho</label><br/>
	                         <select  class="form-control" name="ncategoria" id="cat">
	                    		<option value="">Selecione uma categoria</option>
	                         </select>
	                      </div>
	                     
	                       
	                      <div class="form-group">   
	                          <label>Subcategoria de trabalho</label><br/>
	                          <select  class="form-control" name="nsubcategoria" id="subcat">
	                			<option value="" >Selecione uma subcategoria</option>
	                         </select>
	                      </div>    
	                      <br/>	
	                    
	                      <div class="form-group">
	                        <label>Senha</label><br/>
	                        <input type="password" name="senhaFreela"  class="form-control" id="senha"> 
	                      </div>	
	                    
	                    <div class="form-group">	
	                        <label>Repita sua senha</label><br/>
	                        <input maxlength="100" class="form-control" type="password"  id="senha2">
	                    </div>
	                    <br/>
	                      
						<div class="form-group">
	                        <label>Descreva seu trabalho.</label><br/>
	                        <textarea maxlength="250"  class="form-control" name="descricaoFreela" placeholder="Exemplo: Programador - PHP,JAVA e etc."></textarea>
	                    </div>
	                    <br/>
	                    
	                    <div class="form-group">
	                        <label>Forma��o</label><br/>
	                        <textarea maxlength="250"  class="form-control" name="formacaoFreela" placeholder="Exemplo: Cursando Superior, Ensino M�dio etc."></textarea>
	                    </div>
	                    <br/>
	                         
	                    <div class="form-group">     
	                        <label>Exp. profissional</label><br/>
	                        <textarea maxlength="250" class="form-control" name="experienciaFreela" placeholder="Exemplo: Vendedor de carros, Programador Java etc."></textarea>
	                   	</div>  
	                   	 <br/>   
	                   	<div id="divBotao"> 
                        	<input  type="submit" value="Salvar" class="btsalvar">
                        </div>
                 </form>
             </div>     
          </div>       

<%@ include file="rodape.jsp" %>
