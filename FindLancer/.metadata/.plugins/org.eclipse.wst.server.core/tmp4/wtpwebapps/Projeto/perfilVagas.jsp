<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="br.com.findlancer.model.Vaga"%>
<%@page import="java.util.ArrayList"%>  
<%@page import="java.util.List;"%> 
<%@ include file="topo.jsp" %>
 <% 
 
 
 	
 	Vaga vaga = (Vaga)session.getAttribute("Vaga");
 
	int idLogado = (Integer)session.getAttribute("id");
	int idPerfil = vaga.getEmpresa().getId();
	int nivel =  (Integer)session.getAttribute("nivelUsu");
 
	
 	List<Vaga> lista =(List<Vaga>)session.getAttribute("listaDeVagas"); 
 %>    
 
     <div id="conteudo" class="conteudoPerfilVagas">
         <div class="divback">
              <div id="conteudoVaga">
              <% 
              	if((idLogado==idPerfil) && (nivel==2) ){
              %>    
                <div id="opcoes">
                    <div id="editVaga">
                        <div id="iconEditar"></div>
                        <p><a href="vagacontroller.do?acao=alterarvaga&id=<%= vaga.getIdVaga() %>" >Editar vaga</a></p>
                    </div>

                    <div id="delVaga">
                        <div id="iconDel"></div>
                          <p><a href="vagacontroller.do?acao=deletarvaga&id=<%= vaga.getIdVaga() %>" >Excluir vaga</a></p>
                    </div>
                </div>
              <% 
              	}
              %>      
                <div class="tituloPerfVaga">
                  <h1><%= vaga.getTitulo() %></h1>
                </div>
                
                <div class="dadosVaga">
                  <h3>Descrição:</h3>
                    <p><%= vaga.getDescricao() %> </p>
                </div>
                
                <div id="imgEmp">
                
                </div>
                
                <div class="dadosVaga">
                  <h3>Categoria da vaga:</h3>
                    <p><%= vaga.getSubcategoria().getCategoria().getDescricao() %></p>
                </div>
                <br/>
                
                <div class="dadosVaga">
                  <h3>Sub-categoria vaga:</h3>
                    <p><%= vaga.getSubcategoria().getDescricao() %></p>
                </div>
                <br/>
                  
                <div class="dadosVaga">
                  <h3>Formação mínima:</h3>
                    <p><%=vaga.getFormacao() %></p>
                </div>
                 <br/>
                  
                <div class="dadosVaga">
                  <h3>Experiência requerida:</h3>
                    <p><%= vaga.getExperiencia() %></p>
                </div>
                  
                <div class="dadosVaga">
                  <h3>Salário:</h3>
                    <p><%= vaga.getSalario() %></p>
                </div>
               
               <% 
              	if(idPerfil!=idLogado){
              %> 
                <div class="tituloPerfVaga">
                    <h1>Sobre a empresa</h1>
                    <a class="txtPerfil" href="empresacontroller.do?acao=viewperfil&id=<%= vaga.getFkEmpresa()%>"><%= vaga.getEmpresa().getNome() %></a>     
                  </div>
                  
                <div class="dadosVaga">
                  <h3>Endereço:</h3>
                    <p>Rua: <%= vaga.getEmpresa().getEndereco().getNomeRua()+" - "+vaga.getEmpresa().getEndereco().getBairro()%></p>
                </div>
                  
                <div class="dadosVaga">
                  <h3>Cidade:</h3>
                    <p><%= vaga.getEmpresa().getEndereco().getCidade().getNomeCidade()+" - "+vaga.getEmpresa().getEndereco().getCidade().getEstado().getNomeEstado() %> </p>
                </div>  
                  
                <div class="dadosVaga">
                  <h3>CEP:</h3>
                    <p><%=vaga.getEmpresa().getEndereco().getCep() %></p>
                </div> 
                
                <div class="dadosVaga">
                  <h3>Contato:</h3>
                    <p><%= vaga.getEmpresa().getTelefone() %></p>
                </div> 
                
                <div class="dadosVaga">
                  <h3>Email:</h3>
                    <p><%= vaga.getEmpresa().getEmail() %></p>
                </div>
                
                <div class="dadosVaga">
                  <h3>Pessoa para contato:</h3>
                    <p><%= vaga.getEmpresa().getPessoaContato()  %></p>
                </div>
              
               <% 
              		}
               %> 
             </div>
             
            <% 
            if(lista.size()!=1){
              	if(idLogado!=idPerfil){
            %> 
             <p id="btmaisVagas"><%= lista.size()%></p>
             <div id="maisVagas">
             <% 
             	for(Vaga vagaDaLista : lista){
             		if(vagaDaLista.getIdVaga()!=vaga.getIdVaga()){
             %>
                 <div id="linkVaga">
                    <a id="tituloVaga" href="vagacontroller.do?acao=perfilvaga&id=<%= vagaDaLista.getIdVaga() %>" ><%= vagaDaLista.getTitulo() %></a>
                    <p><%= vagaDaLista.getSubcategoria().getCategoria().getDescricao() %></p>
                    <p><%= vagaDaLista.getSubcategoria().getDescricao() %></p>
                    <br/>
                 </div>
              <% 
             		}		
             	}
              }
            }
              %>    
             </div>
             
         </div>
      </div>
           
<%@ include file="rodape.jsp" %>