<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="br.com.findlancer.model.Freelancer"%>  
<%@ include file="topo.jsp" %>
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
                     String rua = freelancer.getEndereco().getNomeRua();
                     String bairro = freelancer.getEndereco().getBairro();
                     int numero = freelancer.getEndereco().getNumero();
                     int cep = freelancer.getEndereco().getCep();
                     int idade = freelancer.getIdade();
                     String email = freelancer.getEmail(); 
                     String telefone = freelancer.getTelefone();
                     String subcategoria = freelancer.getSubcategoria().getDescricao();
                     String categoria = freelancer.getSubcategoria().getCategoria().getDescricao();
                     
                     int idLogado = (Integer)session.getAttribute("id");
                     int idPerfil = (Integer)session.getAttribute("idValida");
                     int nivel =  (Integer)session.getAttribute("nivelUsu");
    					
                     String inicialNome = nome.substring(0,1);
	%>

          <div id="conteudo" class="conteudoPerfil">
              
          
              <div class="fotoPerfil" ><p><%= inicialNome %></p></div>  
              <div id="fundoFoto">
			<%
				if((idPerfil==idLogado)&& (nivel==1)){
			%>	
				<div id="opcoes">
                    <div id="editVaga">
                        <div id="iconEditar"></div>
                        <a href ="freelacontroller.do?acao=editarperfil">Editar perfil</a>
                    </div>
                   <div id="alteraSenha">
                        <div id="iconSenha"></div>
                        <a href="alterarSenha.jsp">Alterar senha</a>
                	</div>
                </div>
			<% } %>	
              </div>
              
                  <div id="txtNome">
                        <h1><%= nome %></h1>
                        <p  class="txtPerfil"><%= cidade+"-"+estado+", "+idade  %></p>
                  </div>
                   
                  <div id="divTextos">
                          <span class="txtPerfil"> E-mail: <%= email  %></span>  
                          <span class="txtPerfil">Contato: <%= telefone   %></span>
                  </div>
                
                  <div id="textoDesc">
                      <h2 class="titPerfil">Sobre <%= nome %></h2>
                      <p class="txtPerfil"><%= descricao   %></p>
                  </div>
                
                  <div id="formacao" class="cardPerfil">
                      <h2 class="titPerfil">Formação de <%= nome %></h2>
                        <p class="txtPerfil"><%= formacao %></p>       
                  </div>
              
                 <div id="categoriaPerfil" class="cardPerfil">
                      <h2 class="titPerfil">Categoria profissional</h2>
                        <p class="txtPerfil"><%= categoria  %></p>      
                 </div>
              
                  <div id="subcategoriaPerfil" class="cardPerfil">
                      <h2 class="titPerfil">Subcategoria profissional</h2>
                        <p class="txtPerfil"><%= subcategoria %></p>      
                 </div>
              
                 <div id="experiencia" class="cardPerfil">
                      <h2 class="titPerfil">Experiências profissionais</h2>
                        <p class="txtPerfil"><%= experiencia  %></p>      
                 </div>
                 
                 <div id="Endereco" class="cardPerfil">
                      <h2 class="titPerfil">Endereco</h2>
                        <p class="txtPerfil">Rua:  <%= rua  %></p>      
                        <p class="txtPerfil">Bairro:<%= bairro   %></p>      
                        <p class="txtPerfil">Numero:<%= numero %></p>      
                        <p class="txtPerfil">Cep:<%= cep   %></p>      
                 </div>
                
                 
              
          </div>
<%@ include file="rodape.jsp" %>
