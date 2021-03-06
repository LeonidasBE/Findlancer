<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="UTF-8" %>

<html lang="pt-br">
  <head>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
      <!-- Importar fonte -->
   
    
     <title>FindLancer</title>
     
     <!-- JQuery lib -->  
     <script  src="js/jquery.js"></script> 
     <script  src="js/fotorama.js"></script> 
     <script  src="js/jqueryMask.js"></script> 
     <script  src="js/jquery-ui.js"></script> 
     <script  src="js/maskMoney.js"></script>
     
      

      <!-- Jquery-->
      <script  src="js/jqParallax.js"></script>
      <script  src="js/jqvalida.js"></script>
      <script  src="js/mascara.js"></script>
      
   	
       
    <link rel="stylesheet" href="css/boot/bootstrap/bootstrap.css">
    <link href="css/boot/topo.css" rel="stylesheet">
    <link href="css/boot/jqueryStyles.css" rel="stylesheet">
    <link href="css/boot/fotorama.css" rel="stylesheet">
    <link href="css/boot/conteudo.css" rel="stylesheet">
    <link href="css/boot/rodape.css" rel="stylesheet">
    <link href="css/boot/parallax.css" rel="stylesheet">  
    <link href="css/boot/fontface.css" rel="stylesheet">
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
    
  <body>
   
      <!-- Div que engloba todo o site -->
      <div id="tudo">

          <!--Div que engloba os elementos do topo-->
          <div id="topo">

              <!--Div que engloba a logo da página -->
             <div id="logo" ><h2>FindLancer</h2></div>

 			 <% 
 			 	//Try para tentar capturar variaveis de sessao e verificar se o usuario esta logado ou nao
		 	    try{
		 	    	
			 		int nivelUsuario = Integer.parseInt(session.getAttribute("nivelUsu").toString());
			 		int idUsuario = Integer.parseInt(session.getAttribute("id").toString());
			 		String nomeUsuario = session.getAttribute("nomeUsu").toString();
			 		
			 		//Terario para verificar o controller
			 		String urlPerfil = (nivelUsuario==1) ? "freelacontroller.do?acao=myperfil" : "empresacontroller.do?acao=myperfil";
					
			 		//Verificar qual nivel do usuario
			 		if(nivelUsuario==1){
			 	%>
			 			<%@ include file="pesqvagas.jsp" %>
			 	<% 	
			 		}else if(nivelUsuario==2){
			 			
			 	%>	
			 		<%@ include file="pesqfreela.jsp" %>
			 	<% 	
			 	}
			 		
			 		//Condicional para verificar se o usuario esta logado
			 		if(idUsuario!=0){
		   %>
				 <div id="div-bemvindo">
					<p>Olá <% out.print(nomeUsuario); %></p> 
					<a href=<% out.print(urlPerfil); %> >Meu perfil</a>
					<a href="logincontroller.do?acao=logout">Sair</a>
				 </div>
		<%  			
		 		}
		 	}catch(Exception erro){
		%> 		  
		 		 <div id="div-btlogar">
                   <input type="button" id="btlogar" name="logar" value="Fazer login">   
           		 </div> 
		 <% 
		 	}
		 
		 %>          
                                 
         <%
                    	//Try para capturar variaveis de sessao
                    	try{
		 					int nivelUsuario = Integer.parseInt(session.getAttribute("nivelUsu").toString());
                    		
		 					//Condicional para verificar qual o nivel do usuario
		 					if(nivelUsuario==1){
         %>			  
                    
                            <%@ include file="menuFreelancer.jsp" %>
                        
         <%
                            }else if(nivelUsuario==2){
         %>
                    
                        <%@ include file="menuEmpresa.jsp" %>    
                    
         <%
                            }
                       }catch(Exception erro){
         %>   
    				<%@ include file="menuDeslogado.jsp" %>                
    				
        <%             } 
        
           
        %>
                        
          <div id="fundoTransparente">
		
            <div class="formularioLogin">
                 <div id="btclose">
                    
                 </div>       
                 <form  id="formlogar" name="loginForm" action="logincontroller.do?acao=logar" method="post">  
                        <p id="alertLogin-index"></p>
                        <h2>E-mail:</h2>
                        <input type="text" name="email" id="emailLogin">
                        <h2>Senha:</h2>
                        <input type="password" id="senhaLogin" name="senha">
                        <a id="btesqueceuSenha">Esqueceu sua senha?</a>
                        <br>
                        <input type="submit" id="btLogar-index"   value="Entrar">
                   		
                    </form>     
                    
                    <div id="esqueceuSenha">
                        <h4>Informe seu email para enviarmos sua senha:</h4>
                        <input type="text">
                        <br>
                        <input type="button" value="Enviar">
                   </div>    
            </div>
          
            </div>  
          </div>