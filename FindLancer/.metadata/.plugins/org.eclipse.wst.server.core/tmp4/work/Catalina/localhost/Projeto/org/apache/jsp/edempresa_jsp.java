/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-10-22 23:17:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.findlancer.model.Empresa;
import br.com.findlancer.model.Usuarios;

public final class edempresa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("/rodape.jsp", Long.valueOf(1471271726000L));
    _jspx_dependants.put("/menuEmpresa.jsp", Long.valueOf(1471895274000L));
    _jspx_dependants.put("/menuDeslogado.jsp", Long.valueOf(1470970940000L));
    _jspx_dependants.put("/pesqvagas.jsp", Long.valueOf(1472530148000L));
    _jspx_dependants.put("/menuFreelancer.jsp", Long.valueOf(1472539494000L));
    _jspx_dependants.put("/topo.jsp", Long.valueOf(1472532104000L));
    _jspx_dependants.put("/pesqfreela.jsp", Long.valueOf(1472527274000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("  <head>\r\n");
      out.write("    \r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("   \r\n");
      out.write("      <!-- Importar fonte -->\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("     <title>FindLancer</title>\r\n");
      out.write("     \r\n");
      out.write("     <!-- JQuery lib -->  \r\n");
      out.write("     <script  src=\"js/jquery.js\"></script> \r\n");
      out.write("     <script  src=\"js/fotorama.js\"></script> \r\n");
      out.write("     <script  src=\"js/jqueryMask.js\"></script> \r\n");
      out.write("     <script  src=\"js/jquery-ui.js\"></script> \r\n");
      out.write("     <script  src=\"js/maskMoney.js\"></script>\r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      <!-- Jquery-->\r\n");
      out.write("      <script  src=\"js/jqParallax.js\"></script>\r\n");
      out.write("      <script  src=\"js/jqvalida.js\"></script>\r\n");
      out.write("      <script  src=\"js/mascara.js\"></script>\r\n");
      out.write("      \r\n");
      out.write("   \t\r\n");
      out.write("       \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/boot/bootstrap/bootstrap.css\">\r\n");
      out.write("    <link href=\"css/boot/topo.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/boot/jqueryStyles.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/boot/fotorama.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/boot/conteudo.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/boot/rodape.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/boot/parallax.css\" rel=\"stylesheet\">  \r\n");
      out.write("    <link href=\"css/boot/fontface.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("  <body>\r\n");
      out.write("   \r\n");
      out.write("      <!-- Div que engloba todo o site -->\r\n");
      out.write("      <div id=\"tudo\">\r\n");
      out.write("\r\n");
      out.write("          <!--Div que engloba os elementos do topo-->\r\n");
      out.write("          <div id=\"topo\">\r\n");
      out.write("\r\n");
      out.write("              <!--Div que engloba a logo da página -->\r\n");
      out.write("             <div id=\"logo\" ><h2>FindLancer</h2></div>\r\n");
      out.write("\r\n");
      out.write(" \t\t\t ");
 
 			 	//Try para tentar capturar variaveis de sessao e verificar se o usuario esta logado ou nao
		 	    try{
		 	    	
			 		int nivelUsuario = Integer.parseInt(session.getAttribute("nivelUsu").toString());
			 		int idUsuario = Integer.parseInt(session.getAttribute("id").toString());
			 		String nomeUsuario = session.getAttribute("nomeUsu").toString();
			 		
			 		//Terario para verificar o controller
			 		String urlPerfil = (nivelUsuario==1) ? "freelacontroller.do?acao=myperfil" : "empresacontroller.do?acao=myperfil";
					
			 		//Verificar qual nivel do usuario
			 		if(nivelUsuario==1){
			 	
      out.write("\r\n");
      out.write("\t\t\t \t\t\t");
      out.write(" \r\n");
      out.write("              <!--Form para a barra de pesquisa -->\r\n");
      out.write("              <form id=\"pesquisar\" role=\"form\" action=\"vagacontroller.do\" method=\"GET\">\r\n");
      out.write("                <input type=\"text\" name=\"query\" id=\"campoPesq\"> \r\n");
      out.write("                <input type=\"hidden\" value=\"pesquisarvaga\" name=\"acao\" id=\"campoPesq\"> \r\n");
      out.write("                <input type=\"submit\"  value=\" \" id=\"iconPesq\">\r\n");
      out.write("             </form>\r\n");
      out.write(" \t\t\t");
      out.write("\r\n");
      out.write("\t\t\t \t");
 	
			 		}else if(nivelUsuario==2){
			 			
			 	
      out.write("\t\r\n");
      out.write("\t\t\t \t\t");
      out.write(" \r\n");
      out.write("              <!--Form para a barra de pesquisa -->\r\n");
      out.write("              <form id=\"pesquisar\" role=\"form\" action=\"freelacontroller.do\" method=\"GET\">\r\n");
      out.write("                <input type=\"text\" name=\"query\" id=\"campoPesq\"> \r\n");
      out.write("                <input type=\"hidden\" value=\"pesqfreela\" name=\"acao\" id=\"campoPesq\"> \r\n");
      out.write("                <input type=\"submit\"  value=\" \" id=\"iconPesq\">\r\n");
      out.write("             </form>\r\n");
      out.write(" \t\t\t");
      out.write("\r\n");
      out.write("\t\t\t \t");
 	
			 	}
			 		
			 		//Condicional para verificar se o usuario esta logado
			 		if(idUsuario!=0){
		   
      out.write("\r\n");
      out.write("\t\t\t\t <div id=\"div-bemvindo\">\r\n");
      out.write("\t\t\t\t\t<p>Olá ");
 out.print(nomeUsuario); 
      out.write("</p> \r\n");
      out.write("\t\t\t\t\t<a href=");
 out.print(urlPerfil); 
      out.write(" >Meu perfil</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"logincontroller.do?acao=logout\">Sair</a>\r\n");
      out.write("\t\t\t\t </div>\r\n");
      out.write("\t\t");
  			
		 		}
		 	}catch(Exception erro){
		
      out.write(" \t\t  \r\n");
      out.write("\t\t \t\t <div id=\"div-btlogar\">\r\n");
      out.write("                   <input type=\"button\" id=\"btlogar\" name=\"logar\" value=\"Fazer login\">   \r\n");
      out.write("           \t\t </div> \r\n");
      out.write("\t\t ");
 
		 	}
		 
		 
      out.write("          \r\n");
      out.write("                                 \r\n");
      out.write("         ");

                    	//Try para capturar variaveis de sessao
                    	try{
		 					int nivelUsuario = Integer.parseInt(session.getAttribute("nivelUsu").toString());
                    		
		 					//Condicional para verificar qual o nivel do usuario
		 					if(nivelUsuario==1){
         
      out.write("\t\t\t  \r\n");
      out.write("                    \r\n");
      out.write("                            ");
      out.write(" <nav id=\"menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li id=\"l1\"><a href=\"index.jsp\" >Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l2\">\r\n");
      out.write("                    <a href=\"sobre.jsp\">Sobre</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l3\">\r\n");
      out.write("                  <a href=\"vagacontroller.do?query=&acao=pesquisarvaga\">Vagas</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l4\" >\r\n");
      out.write("                         <a>Conta</a>\r\n");
      out.write("                                      <ul id=\"sub\">\r\n");
      out.write("                                          <li><a href=\"freelacontroller.do?acao=editarperfil\">Editar perfil</a></li>\r\n");
      out.write("                                          <li><a href=\"alterarSenha.jsp\" >Alterar senha</a></li>\r\n");
      out.write("                                      </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                                         \t   \r\n");
      out.write("                   \r\n");
      out.write("                                  \r\n");
      out.write("                                         \t\r\n");
      out.write("                </ul>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("         ");

                            }else if(nivelUsuario==2){
         
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                        ");
      out.write(" <nav id=\"menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li id=\"l1\"><a href=\"index.jsp\" >Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l2\">\r\n");
      out.write("                    <a href=\"sobre.jsp\">Sobre</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l3\">\r\n");
      out.write("                    <a href=\"planos.jsp\">Planos</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l4\" >\r\n");
      out.write("                                  <a>Conta</a>\r\n");
      out.write("                                      <ul id=\"sub\">\r\n");
      out.write("                                          <li><a href=\"vagacontroller.do?acao=minhasvagas\">Minhas vagas</a></li>\r\n");
      out.write("                                          <li><a href=\"cadvaga.jsp\" >Cadastrar vaga</a></li>\r\n");
      out.write("                                      </ul>\r\n");
      out.write("                                  </li>\r\n");
      out.write("                                         \t\r\n");
      out.write("                </ul>\r\n");
      out.write("</nav>");
      out.write("    \r\n");
      out.write("                    \r\n");
      out.write("         ");

                            }
                       }catch(Exception erro){
         
      out.write("   \r\n");
      out.write("    \t\t\t\t");
      out.write(" <nav id=\"menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li id=\"l1\"><a href=\"index.jsp\" >Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l2\">\r\n");
      out.write("                    <a href=\"sobre.jsp\">Sobre</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l3\">\r\n");
      out.write("                    <a href=\"planos.jsp\">Planos</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li id=\"l4\" >\r\n");
      out.write("                    \t<a>Cadastre-se</a>\r\n");
      out.write("                        <ul id=\"sub\">\r\n");
      out.write("                            <li><a href=\"cadempresas.jsp\">Empresa</a></li><li>\r\n");
      out.write("                            <a href=\"cadfreela.jsp\" >Freelancer</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                                         \t\r\n");
      out.write("                </ul>\r\n");
      out.write("</nav>");
      out.write("                \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("        ");
             } 
        
           
        
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("          <div id=\"fundoTransparente\">\r\n");
      out.write("\t\t\r\n");
      out.write("            <div class=\"formularioLogin\">\r\n");
      out.write("                 <div id=\"btclose\">\r\n");
      out.write("                    \r\n");
      out.write("                 </div>       \r\n");
      out.write("                 <form  id=\"formlogar\" name=\"loginForm\" action=\"logincontroller.do?acao=logar\" method=\"post\">  \r\n");
      out.write("                        <p id=\"alertLogin-index\"></p>\r\n");
      out.write("                        <h2>E-mail:</h2>\r\n");
      out.write("                        <input type=\"text\" name=\"email\" id=\"emailLogin\">\r\n");
      out.write("                        <h2>Senha:</h2>\r\n");
      out.write("                        <input type=\"password\" id=\"senhaLogin\" name=\"senha\">\r\n");
      out.write("                        <a id=\"btesqueceuSenha\">Esqueceu sua senha?</a>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"submit\" id=\"btLogar-index\"   value=\"Entrar\">\r\n");
      out.write("                   \t\t\r\n");
      out.write("                    </form>     \r\n");
      out.write("                    \r\n");
      out.write("                    <div id=\"esqueceuSenha\">\r\n");
      out.write("                        <h4>Informe seu email para enviarmos sua senha:</h4>\r\n");
      out.write("                        <input type=\"text\">\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"button\" value=\"Enviar\">\r\n");
      out.write("                   </div>    \r\n");
      out.write("            </div>\r\n");
      out.write("          \r\n");
      out.write("            </div>  \r\n");
      out.write("          </div>");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("<script  src=\"js/ajax.js\"></script> \r\n");
 

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
	int fkestado = empresa.getEndereco().getCidade().getFk_estado();
	int fkcidade = empresa.getEndereco().getFk_cidade();
	int idLogado = (Integer)session.getAttribute("id");
	descricao = Usuarios.textoFormulario(descricao);
	ramo = Usuarios.textoFormulario(ramo);
	int fkendereco = empresa.getFkEndereco();
	int id  = (Integer)session.getAttribute("id");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("           <div id=\"conteudo\" class=\"conteudocadempresa\">\r\n");
      out.write("             <div class=\"divback\">\r\n");
      out.write("                  <div id=\"msgalerta\"><p id=\"alerta\"></p><a id=\"btok\">OK</a></div>\t\r\n");
      out.write("                 \r\n");
      out.write("                 <form id=\"form-cad\" class=\"form-inline\" role=\"form\" action=\"empresacontroller.do?acao=alterarempresa\" method=\"post\">\r\n");
      out.write("                     <h1 id=\"titulo-cad\">Edite seu cadastro</h1>    \r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"form-group\"> \r\n");
      out.write("                          \t<label id=\"hnome\">Nome:</label><br/>\r\n");
      out.write("                          \t<input maxlength=\"50\" value=\"");
      out.print( nome );
      out.write("\" type=\"text\" name=\"nomeEmpresa\" id=\"campoNome\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                        \t<label id=\"hfone\">Telefone:</label><br/>\r\n");
      out.write("                         \t<input type=\"text\" value=\"");
      out.print( telefone );
      out.write("\" name=\"telefoneEmpresa\" id=\"fone\"  class=\"form-control\">\r\n");
      out.write("                         </div>\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("                         <div class=\"form-group\">\r\n");
      out.write("                            <label>E-mail:</label><br/>\r\n");
      out.write("                            <input maxlength=\"100\" value=\"");
      out.print( email );
      out.write("\" type=\"text\" name=\"emailEmpresa\" class=\"form-control\">\r\n");
      out.write("                         </div>\r\n");
      out.write("                         \r\n");
      out.write("                          <div class=\"form-group\">\r\n");
      out.write("                            <label>Pessoa para contato:</label><br/>\r\n");
      out.write("                            <input maxlength=\"50\" type=\"text\" value=\"");
      out.print( pessoa );
      out.write("\" name=\"pessoaContato\" id=\"\"  class=\"form-control\">\r\n");
      out.write("                         </div>\r\n");
      out.write("                         \r\n");
      out.write("                         <div class=\"form-group\">\r\n");
      out.write("\t                          <label id=\"hendereco\">Quantidade de funcionáros:</label><br/>\r\n");
      out.write("\t                          <input value=\"");
      out.print( qtd );
      out.write("\"  type=\"number\" name=\"nFunc\"  class=\"form-control\" id=\"numeroFunc\">     \r\n");
      out.write("\t                     </div>   \r\n");
      out.write("\t                      <br/> \r\n");
      out.write("                         \r\n");
      out.write("                         <div class=\"form-group\"> \r\n");
      out.write("                         \t<label id=\"hbairro\">Bairro:</label><br/>\r\n");
      out.write("                         \t<input  maxlength=\"100\" type=\"text\" value=\"");
      out.print( bairro );
      out.write("\" name=\"nbairro\"  class=\"form-control\" id=\"bairro\">\r\n");
      out.write("                         </div>\r\n");
      out.write("                         \r\n");
      out.write("                         <div class=\"form-group\">                        \r\n");
      out.write("\t                         <label id=\"hendereco\">CEP:</label><br/>\r\n");
      out.write("\t                         <input type=\"text\" value=\"");
      out.print( cep );
      out.write("\" name=\"ncep\"  class=\"form-control\" id=\"cep\"> \r\n");
      out.write("\t                     </div>   \r\n");
      out.write("\t                     \r\n");
      out.write("\t                        \r\n");
      out.write("\t                     <div class=\"form-group\">\r\n");
      out.write("\t                          <label id=\"hendereco\">Rua:</label><br/>\r\n");
      out.write("\t                          <input maxlength=\"100\" type=\"text\" name=\"nrua\" value=\"");
      out.print( rua );
      out.write("\" class=\"form-control\" id=\"rua\">     \r\n");
      out.write("\t                     </div>  \r\n");
      out.write("\t                       \r\n");
      out.write("\t                     <div class=\"form-group\">\r\n");
      out.write("\t                          <label id=\"hendereco\">Número:</label><br/>\r\n");
      out.write("\t                          <input type=\"number\" value=\"");
      out.print( numero );
      out.write("\" name=\"nnumero\"  class=\"form-control\" id=\"numerorua\">     \r\n");
      out.write("\t                     </div>   \r\n");
      out.write("\t                      <br/> \r\n");
      out.write("\t                      \r\n");
      out.write("\t                    <div class=\"form-group\">     \r\n");
      out.write("\t                         <label>Estado</label><br/>\r\n");
      out.write("\t                         <select  class=\"form-control\" name=\"nestado\" id=\"estado\">\r\n");
      out.write("\t                    \t\t<option value=\"");
      out.print( fkestado );
      out.write('"');
      out.write('>');
      out.print( estado );
      out.write("</option>\r\n");
      out.write("\t                         </select>\r\n");
      out.write("\t                      </div>\r\n");
      out.write("\t                      \r\n");
      out.write("\t                        <div class=\"form-group\">     \r\n");
      out.write("\t                         <label>Cidade</label><br/>\r\n");
      out.write("\t                         <select  class=\"form-control\" name=\"ncidade\" id=\"cidades\">\r\n");
      out.write("\t                    \t\t<option value=\"");
      out.print( fkcidade );
      out.write('"');
      out.write('>');
      out.print( cidade );
      out.write("</option>\r\n");
      out.write("\t                         </select>\r\n");
      out.write("\t                      </div>\r\n");
      out.write("\t                      \r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t                        <label>Descreva a empresa:</label><br/>\r\n");
      out.write("\t                        <textarea maxlength=\"250\" class=\"form-control\" name=\"descricaoEmpresa\" placeholder=\" \">");
      out.print( descricao );
      out.write("</textarea>\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                    \r\n");
      out.write("\t                    <div class=\"form-group\">\r\n");
      out.write("\t                        <label>Ramo de atividade:</label><br/>\r\n");
      out.write("\t                        <textarea maxlength=\"250\" class=\"form-control\" name=\"descricaoRamo\" placeholder=\"Exemplo: Desenvolvimento WEB\">");
      out.print( ramo );
      out.write("\r\n");
      out.write("\t                        </textarea>\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                    <br/>\r\n");
      out.write("\t                    \r\n");
      out.write("\t                     <input type=\"hidden\" name=\"idEmpresa\" value=\"");
      out.print( id );
      out.write("\">\r\n");
      out.write("\t                   \t <input type=\"hidden\" name=\"idEndereco\" value=\"");
      out.print( fkendereco );
      out.write("\" >\r\n");
      out.write("\t                  \r\n");
      out.write("\t                   \t<div id=\"divBotao\"> \r\n");
      out.write("                        \t<input  type=\"submit\" value=\"Salvar\" class=\"btsalvar\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                 </form>\r\n");
      out.write("          </div> \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<div id=\"rodape\">\r\n");
      out.write("              <div id=\"social\">\r\n");
      out.write("                   <div id=\"icones\"> \r\n");
      out.write("                     <div id=\"face\" class=\"icone\"></div>\r\n");
      out.write("                     <div id=\"twitter\" class=\"icone\"></div>    \r\n");
      out.write("                     <div id=\"liked\" class=\"icone\"></div>    \r\n");
      out.write("                     <div id=\"git\" class=\"icone\"></div>    \r\n");
      out.write("                  </div>      \r\n");
      out.write("              </div>\r\n");
      out.write("              <div id=\"colunas\">\r\n");
      out.write("                <div id=\"coluna1\">\r\n");
      out.write("                    <h3 class=\"titrodape\">Contato</h3>\r\n");
      out.write("                    <p class=\"txtfooter\">findlancer@gmail.com</p>\r\n");
      out.write("                    <p class=\"txtfooter\">(47)3328-6112</p>\r\n");
      out.write("                  </div>      \r\n");
      out.write("                <div id=\"coluna2\">\r\n");
      out.write("                    <h3 class=\"titrodape\">Endereço</h3>\r\n");
      out.write("                    <p id=\"txtend\" class=\"txtfooter\">Rua 7 de Setembro,1213(Shopping Neumarkt)</p>\r\n");
      out.write("                    <a href=\"https://www.google.com.br/maps/place/PROWAY+INFORMATICA+LTDA/@-26.9198527,-49.0711114,17z/data=!4m5!3m4!1s0x94df18c3b4a71d65:0xa5ec9dd8406a6a7!8m2!3d-26.9198575!4d-49.0689227\" target=\"_blank\"><div id=\"maps\"></div></a>\r\n");
      out.write("                </div> \r\n");
      out.write("                <div id=\"coluna3\">\r\n");
      out.write("                \t<h3 class=\"titrodape\">Empresa</h3>\r\n");
      out.write("                     <a class=\"linksfooter\" href=\"sobre.jsp\" >Sobre a FindLancer</a> <br/> \r\n");
      out.write("                     <a class=\"linksfooter\" href=\"erroLogin.jsp\" >Termos de uso</a><br/>   \r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"coluna4\">\r\n");
      out.write("                \t<h3 class=\"titrodape\">Recrutamento</h3>\r\n");
      out.write("                    <a class=\"linksfooter\" href=\"erroLogin.jsp\" >Login</a> <br/> \r\n");
      out.write("                    <a class=\"linksfooter\" href=\"erroLogin.jsp\" >Como anunciar</a><br/>  \r\n");
      out.write("                    <a class=\"linksfooter\" href=\"erroLogin.jsp\" >Nossos serviços</a>  <br/>\r\n");
      out.write("                </div>  \r\n");
      out.write("            </div> \r\n");
      out.write("                  <p id=\"copyright\">© Copyright - Find Lancer - Todos os direitos reservados </p>              \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("  </body>\r\n");
      out.write("  </html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
