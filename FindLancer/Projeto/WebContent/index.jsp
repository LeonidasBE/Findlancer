<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="topo.jsp" %>
<%
	String url="#";
	try{
		int nivel = (Integer)session.getAttribute("nivelUsu");
		if(nivel==1){
			url="vagacontroller.do?acao=buscaporcat&p=&ncategoria=";	
		}else if(nivel==2){
			url="freelacontroller.do?acao=pesqfreelacat&p=&ncategoria=";
		}
	}catch(Exception e){
		
	}	
%>
           <div id="conteudo" class="conteudohome">
               <div class="fotorama" data-loop="true" data-autoplay="3000"    data-width="100%" data-ratio="601/401">  
                   <img src="css/img/banner/1.jpg">
                   <img src="css/img/banner/2.jpg">
                   <img src="css/img/banner/3.jpg">
                   <img src="css/img/banner/4.jpg">
                   <img src="css/img/banner/5.jpg">
                  
              </div>
                <div id="textoHome">
                    <h2>Conectamos você de forma inteligente e profissional</h2>
                    <p> 
						O que você procura está aqui, empresas e profissionais
						se conectando de forma rápida e prática com o mesmo 
						objetivo, a satisfação de todos!
                    </p>
                </div>
               
                <div id="areasdeatuacao">
				    <h2>Áreas em destaque</h2>
                   <div id="listcard1"> 
                    <div id="card1" class="card">
                        <div id="programadores" class="cardimg">
                            <div class="pop" id="pop1">
                                <a href="<%=url+1 %>"><button id="btprogram" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Desenvolvedores</h3>
                        <p class="txtcard">Desktop - Mobile - WEB</p>
                    </div>
            
                     <div id="card2" class="card">
                        <div id="fotografia" class="cardimg">
                            <div id="pop2" class="pop">
                              <a href="<%=url+2 %>"><button type="submit" id="btfotografia" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Fotógrafos</h3>
                        <p class="txtcard">Eventos - Festas - Álbuns</p>
                    </div>
                    <div id="card3" class="card">
                        <div id="redacao" class="cardimg">
                            <div id="pop3" class="pop">
                               <a href="<%=url+4 %>"><button type="submit" id="btredacao" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Escritores e tradutores</h3>
                        <p class="txtcard"> Contéudo Web- Jornalismo</p>
                    </div> 
               </div>
                
              <div id="listcard2"> 
                     
                    <div id="card1" class="card">
                        <div id="DigitalMarkt" class="cardimg">
                            <div class="pop" id="pop4">
                                <a href="<%=url+5 %>"><button type="submit" id="btMarktDigital" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Marketing Digital</h3>
                        <p class="txtcard">SEO - SEM - CRM</p>
                    </div>
            
                     <div id="card2" class="card">
                        <div id="EngenheiroSoftware" class="cardimg">
                            <div id="pop5" class="pop">
                                  <a href="<%=url+3 %>"><button type="submit" id="btEngSoft" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Engenheiros de Soft.</h3>
                        <p class="txtcard">Sistemas - .NET - JAVA</p>
                    </div>
                     
                    <div id="card3" class="card">
                        <div id="Designer" class="cardimg">
                            <div id="pop6" class="pop">
                                  <a href="<%=url+2 %>"><button type="submit" id="btDesigner" class="btpop">Ver mais</button></a>
                            </div>
                        </div>
                        <h3 class="titcard">Designer</h3>
                        <p class="txtcard">Logos - Ilustração - UX/UI</p>
                    </div> 
               </div>            
                    
          </div>
          </div>    
    
<%@ include file="rodape.jsp" %>