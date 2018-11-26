package br.com.findlancer.util;


public enum Acao {
MINHAS_VAGAS("minhasvagas"),
MEU_PERFIL("myperfil"),
VER_PERFIL("viewperfil"),
EDITAR_PERFIL("editarperfil"),
LOGOUT("logout"),
LOGAR("logar"),
PESQ_VAGA("pesquisarvaga"),
PESQ_FREELANCER("pesqfreela"),
PESQ_FREELACAT("pesqfreelacat"),
PESQ_VAGACATEGORIA("pesqporcategoria"),
ALT_SENHA("alterarsenha"),
CAD_EMPRESA("cadastrarempresa"),
ALT_VAGA("alterarvaga"),
ALT_EMPRESA("alterarempresa"),
CAD_VAGA("cadastrarvaga"),
CAD_FREELA("cadastrarfreela"),
DEL_VAGA("deletarvaga"),
ALT_FREELA("alterarFreela"),
VAGAFCAT("buscaporcat"),
VER_VAGAS("vervagas"),
FCAT("cat"),
FSUB("sub"),
FCID("cid"),
FEST("est"),
PERFIL_VAGAS("perfilvaga");
	
	private String constante;
	
	
	public String getConstante() {
		return constante;
	}
	
	private Acao(String acao) {
		this.constante = acao;
	}
	
}
