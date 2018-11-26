<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
		
		<%
			//Verificar se o usuário é empresa ou freelancer
			int nivel = (Integer)session.getAttribute("nivelUsu");
			String url = nivel == 1 ? "freelacontroller.do?acao=alterarsenha" : "empresacontroller.do?acao=alterarsenha"; 
		%>
		
       <div id="conteudo" class="conteudoMudarSenha">
           <div class="divback2">
           
       			<h2>Alterar senha</h2>
                <br>
       
             <form id="mudarSenha" action="<%=url%>" method="post">
                
                <div class="form-group">
	                <label>Senha atual:</label><br/>
	                <input type="password" class="form-control" name="senhaatual" id="senhaAtual"> 
	            </div>	
                
                <div class="form-group">
	                <label>Senha:</label><br/>
	                <input type="password" class="form-control" name="senhaNova" id="senha"> 
	            </div>	
	                    
	            <div class="form-group">	
	                <label>Repita sua senha:</label><br/>
	                <input class="form-control" type="password"  id="senha2">
	            </div>
                 
                <div id="divBotao">
                	<input type="submit" value="Alterar" class="btsalvar">
             	</div>
             	
             </form>
          </div>
       </div>
    
<%@ include file="rodape.jsp" %>