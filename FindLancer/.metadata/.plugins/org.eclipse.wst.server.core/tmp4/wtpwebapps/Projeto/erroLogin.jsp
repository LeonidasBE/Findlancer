<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
		
         <div id="conteudo" class="conteudoErroLogin">
           	<div class="divback">    
       
             <form id="erroLogin" action="logincontroller.do?acao=logar" method="post">
				
                <div class="form-group">
					<label class="txtPerfil">E-mail:</label><br/>
                    <input type="text" name="email" id=""  class="form-control">
                </div>
                
                <div class="form-group">
	               <label class="txtPerfil">Senha:</label><br/>
	               <input type="password" name="senha"  class="form-control" id=""> 
	            </div>
                 
                <div id="divBotao">
                	<input id="bt-LoginErro" type="submit" value="Logar" class="btsalvar">
             	</div>
              
          	</div>    
        </div>    
    
<%@ include file="rodape.jsp" %>