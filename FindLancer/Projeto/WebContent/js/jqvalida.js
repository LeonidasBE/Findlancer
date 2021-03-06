$(document).ready(
		function() {

			$("#iconPesq").click(function() {
				if ($("#campoPesq").val() == "") {
					return false;
				}
			});

			$("#datepicker")
					.datepicker(
							{
								changeYear : true,
								changeMonth : true,
								dayNames : [ 'Domingo', 'Segunda', 'Terça',
										'Quarta', 'Quinta', 'Sexta', 'Sábado',
										'Domingo' ],
								dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
										'S', 'D' ],
								dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
										'Qui', 'Sex', 'Sáb', 'Dom' ],
								monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
										'Abril', 'Maio', 'Junho', 'Julho',
										'Agosto', 'Setembro', 'Outubro',
										'Novembro', 'Dezembro' ],
								monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
										'Mai', 'Jun', 'Jul', 'Ago', 'Set',
										'Out', 'Nov', 'Dez' ]
							});

			$("#programadores").hover(function() {
				cardanimate("#pop1");
			});

			$("#fotografia").hover(function() {
				cardanimate("#pop2");
			});

			$("#redacao").hover(function() {
				cardanimate("#pop3");
			});

			$("#DigitalMarkt").hover(function() {
				cardanimate("#pop4");
			});

			$("#EngenheiroSoftware").hover(function() {
				cardanimate("#pop5");
			});

			$("#Designer").hover(function() {
				cardanimate("#pop6");
			});

			$("#l4").hover(function() {
				sub();
			});

			$("#pesquisar").focusin(function() {
				resizepesq();
			});

			$("#pesquisar").focusout(function() {
				resizepesq2();
			});

			$("#btlogar").click(function() {
				exibirForm();

			});

			$("#btclose").click(function() {
				closeForm();
			});

			// Evento click botão
			$(".btsalvar").click(function() {
				return validacoes();
			});

			$("#btesqueceuSenha").click(function() {
				cardanimate("#esqueceuSenha");
			});

			$("#esqueceuSenha-txt").click(function() {
				cardanimate("#div-esqueceuSenha");
			});

			$("#btok").click(function() {
				$("#msgalerta").slideToggle(300);
			});

			$("#btmaisVagas").click(function() {
				$("#maisVagas").slideToggle(300);
			});

		});

// Método para efeitos nos cards
function cardanimate(id) {
	$(id).slideToggle(300);
}

function sub() {
	$("#sub").slideToggle(500);
}

// Método para resize na barra de pesquisa ao ganhar foco
function resizepesq() {
	$("#campoPesq").css("width", "350");
}

// Método para resize na barra de pesquisa ao perder foco
function resizepesq2() {
	var conteudo = $("#campoPesq").val();
	if (conteudo == "") {
		$("#campoPesq").css("width", "100");
	}
}

// Método para dar display block na div form login
function exibirForm() {
	$("#fundoTransparente").fadeToggle();
}

// Método para dar display block na div form login
function closeForm() {
	$("#fundoTransparente").fadeToggle();
}

function validacoes() {

	var erro = $("#alerta");
	var nome = $("#campoNome");
	var email = $("#email");
	var fone = $("#fone");
	var cidade = $("#cidade");
	var senha = $("#senha");
	var senha2 = $("#senha2");
	var categoria = $("#cat");
	var subcategoria = $("#subcat");
	var endereco = $("#endereco");
	var razao = $("#razao");
	var ramo = $("#ramo");
	var contato = $("#contato");
	var descricao = $("#descricao");
	var cep = $("#cep");
	var cnpj = $("#cnpj");

	var senhaAtual = $("#senhaAtual");

	if (senhaAtual.val() == "") {
		validacaoTrue(senhaAtual, "senhaAtual");
		return false;
	} else {
		validacaoFalse(senhaAtual);
	}

	if (senha.val() == "") {
		validacaoTrue(senha, "Senha");
		return false;
	} else {
		validacaoFalse(senha);
	}

	// Validação da repetição da senha
	if (senha2.val() == "") {
		validacaoTrue(senha2, "Repetir Senha");
		return false;
	} else {
		var condicao = validacaoSenha(senha, senha2);

		if (condicao == false) {
			return false;
		} else {
			validacaoFalse(senha2);
		}
	}

	// Validação do email
	if (email.val() == "") {
		validacaoTrue(email, "Email");
		return false;
	} else {
		var condicao = validacaoEmail(email);

		if (condicao == false) {
			return false;
		} else {
			validacaoFalse(email);
		}
	}

	if (razao.val() <= 2) {
		validacaoTrue(razao, "Razão Social");
		return false;
	} else {
		validacaoFalse(razao);
	}

	if (nome.val() <= 2) {
		validacaoTrue(nome, "Nome");
		return false;
	} else {
		validacaoFalse(nome);
	}

	if (ramo.val() <= 2) {
		validacaoTrue(ramo, "Ramo");
		return false;
	} else {
		validacaoFalse(ramo);
	}

	// Validação CNPJ
	if (cnpj.val() == "") {
		validacaoTrue(cnpj, "CNPJ");
		return false;
	} else {
		validacaoFalse(cnpj);
	}

	if (endereco.val() == "") {
		validacaoTrue(endereco, "Endereco");
		return false;
	} else {
		validacaoFalse(endereco);
	}

	if (cidade.val() == "") {
		validacaoTrue(cidade, "Cidade");
		return false;
	} else {
		validacaoFalse(cidade);
	}

	// validação CEP
	if (cep.val() == "") {
		validacaoTrue(cep, "CEP");
		return false;
	} else {
		validacaoFalse(cep);
	}

	if (fone.val() == "") {
		validacaoTrue(fone, "Telefone");
		return false;
	} else {
		validacaoFalse(fone);
	}

	// Validação do email
	if (email.val() == "") {
		validacaoTrue(email, "Email");
		return false;
	} else {
		var condicao = validacaoEmail(email);

		if (condicao == false) {
			return false;
		} else {
			validacaoFalse(email);
		}
	}

	if (contato.val() <= 2) {
		validacaoTrue(contato, "Pessoa para contato");
		return false;
	} else {
		validacaoFalse(contato);
	}

	// Validaçao da categoria
	if (categoria.val() == "") {
		validacaoCat(categoria, "Categoria");
		return false;
	} else {
		validacaoFalse(categoria);
	}

	// Validação da subcategoria
	if (subcategoria.val() == "") {
		validacaoCat(subcategoria, "Subcategoria");
		return false;
	} else {
		validacaoFalse(subcategoria);
	}

	// Validação descrição
	if (descricao.val() == "") {
		validacaoTrue(descricao, "Descrição");
		return false;
	} else {
		validacaoFalse(descricao);
	}

}

// Inicio funções para validação
function validacaoTrue(campo, valueCampo) {
	campo.css("border", "solid 0.5px #c74735");
	campo.focus();
	$("#msgalerta").slideDown(300);
	$("#alerta").html("*Preencha o campo " + valueCampo);
}

function validacaoFalse(campo) {
	campo.css("border", "none");
}

function validacaoCat(campo, valueCampo) {
	campo.css("border", "solid 0.5px #c74735");
	campo.focus();
	$("#msgalerta").slideDown(300);
	$("#alerta").html("*Escolha uma " + valueCampo);
}

function validacaoEmail(email) {
	if ((email.val().indexOf('@') == -1) || (email.val().indexOf('.') == -1)) {
		email.css("border", "solid 0.5px #c74735");
		$("#alerta").html("*Informe um email valido");
		email.focus();
		return false;
	}

	resultado = Boolean(emailBool = validarEmailCadastrado(email.val()));
	if (resultado) {
		$("#alerta").html("*Email já cadastrado");
		email.css("border", "solid 0.5px #c74735");
		$("#msgalerta").slideDown(300);
		return false;
	}
}

function validacaoSenha(senha, senha2) {
	if (senha.val() != senha2.val()) {
		senha2.css("border", "solid 0.5px #c74735");
		$("#alerta").html("*As senhas não conferem");
		senha2.focus();
		return false;
	}
}

function validarEmailCadastrado(emailCad) {
	var retorno = false;
	// Método para verificar se o email digitado ja existe
	$.ajax({
		url : 'logincontroller.do?acao=autenticaremail&email=' + emailCad,
		type : 'post',
		async : false,
		datatype : 'JSON',
		data : {
			email : emailCad
		},
		success : function(resultado) {
			console.log("resultado =" + resultado);
			retorno = eval("(" + resultado + ")");
		}
	});

	return retorno;

}
