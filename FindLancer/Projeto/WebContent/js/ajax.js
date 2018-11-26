$(document).ready(function(){
        
	 
		 
		//Chamando o metodo para popular select de estados
		popularEstados();
		
		//Evento change, para realizar novo select a cada item do select de estados
		$("#estado").change(function(){
			popularCidades(this,'cidades');
		});
		
	});

//function para limpar o combo 
function limparCombo(combo){
	while(combo.length>1){
		combo.remove(combo.length-1);
	} 
}




//Metodo para popular estados
function popularEstados(){
	
	var comboEstado=document.getElementById('estado');
    
	//Método para popular combo de categorias com ajax
	$.ajax({
				url:'utilcontroller.do?o=est',
				type:'GET',
				datatype:'json',
				data:{valor:comboEstado.options[comboEstado.selectedIndex].value},
				success:function(estados){
					var myObject = eval('('+ estados + ')');
					atribuirEstados(myObject,comboEstado);
				}
			});
}

//Metodo que atribui os valores no combo de estados
function atribuirEstados(json,combo){ 
	for(var i=0;i<json.length;i++){
		combo.options[combo.length] = new Option( json[i].siglaEstado,json[i].idEstado );
	}
}

//Método para popular subcategorias
function popularCidades(combo1,combo2){
	
	combo2= document.getElementById(combo2);
	
	limparCombo(combo2);
	
	if(combo1.options[combo1.selectedIndex].value!= ""){
			$.ajax({
			url:"utilcontroller.do?o=cid",
			type:'GET',
			datatype:'json',
			data:{fk:combo1.options[combo1.selectedIndex].value},
			success:function(resultado){
				var listaJSON = eval('('+ resultado + ')');
				atribuirCidades(listaJSON,combo2);
				combo1.disabled=false;
				combo2.disabled=false;    
			}
		});
	}else{
		combo2.disabled=true;
	}
}

//Metodo que atribui os valores no combo
function atribuirCidades(jsonCid,combo){ 
	 
	for(var i=0;i<jsonCid.length;i++){ 
		combo.options[combo.length] = new Option(jsonCid[i].nomeCidade,jsonCid[i].idCidade);
	}

}