
<%@page import="br.com.findlancer.model.Empresa"%>  
<%@ include file="topo.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

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
				
				int idLogado = (Integer)session.getAttribute("id");
                int idPerfil = (Integer)session.getAttribute("idValida");
                int nivel =  (Integer)session.getAttribute("nivelUsu");
                
                int vagas = (Integer)session.getAttribute("contVagas");
                
                String inicialNome = nome.substring(0,1);
			%>
	
          <div id="conteudo" class="conteudoPerfil">
              <div class="fotoPerfil" ><p><%= inicialNome %></p></div>  
              <div id="fundoFoto">
                    
             <% 
             	if( (idLogado==idPerfil) && (nivel==2) ){
             %>   	
				<div id="opcoes">
                    <div id="editVaga">
                        <div id="iconEditar"></div>
                        <a href ="empresacontroller.do?acao=editarperfil">Editar perfil</a>
                    </div>
                    <div id="alteraSenha">
                        <div id="iconSenha"></div>
                        <a href="alterarSenha.jsp">Alterar senha</a>
                	</div>
                </div>
                       
             <% 
             	}
             %>  
              </div>
                  
                  <div id="txtNome">
                        <h1><%= nome %></h1>
                        <p  class="txtPerfil"><%= cidade+"-"+estado %></p>
                  </div>    
                   
                  <div id="divTextos">
                          <span  class="txtPerfil"> E-mail: <%= email %></span>  
                           <span  class="txtPerfil">Contato: <%= telefone %></span>
                      
                  </div>

                
                  <div id="textoDesc">
                      <h2  class="titPerfil">Sobre <%=nome %> </h2>
                      <p  class="txtPerfil"><%= descricao %> </p>
                  </div>
                
                  <div id="ramo" class="cardPerfil">
                      <h2 class="titPerfil">Dados da empresa</h2>
                          <h3>Endereço:</h3>
                          <p class="txtPerfil"> Rua: <%=rua %></p>
                          <p class="txtPerfil"> Bairro: <%=bairro %></p>
                          <h3>Ramo de atividade:</h3>
                          <p class="txtPerfil"><%= ramo %> </p>
                          <h3>Número de funcionários:<%= qtd %></h3>
                          <h3>Pessoa responsável para contato:</h3>
                          <p  class="txtPerfil"><%= pessoa %></p>  
                  </div>
               <%
                	//Verifica se o perfil do usuário é o logado ou é de outro perfil
                	if(idPerfil != idLogado){
               %>
                   <div id="vagasPerfilEmpresa" class="cardPerfil">
                      <h2 class="titPerfil">Vagas desta empresa</h2>
                       <h3>Há <%= vagas %> <a href="vagacontroller.do?acao=vervagas&idEmpresa=<%= idPerfil %>">vagas</a> desta empresa</h3>
                  </div>
              <% } %>    
          </div>
<%@ include file="rodape.jsp" %>
