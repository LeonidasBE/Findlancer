<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
		
       <div id="conteudo" class="conteudoDeletarAcc">
           <div class="divback2">
           
       			<h2>Insira seu email para desativar sua conta</h2>
                <br>
       
             <form id="inativarAcc" method="post">
				
                <div class="form-group">
					<label>E-mail:</label><br/>
                    <input type="text" name="email" id="email"  class="form-control">
                </div>
                
                <div class="form-group">
	               <label>Senha:</label><br/>
	               <input type="password" name="senha"  class="form-control" id="senha"> 
	            </div>
                 
                <div id="divBotao">
                	<input type="submit" value="Desativar" class="btsalvar">
             	</div>
          </div>
       </div>
    
<%@ include file="rodape.jsp" %>