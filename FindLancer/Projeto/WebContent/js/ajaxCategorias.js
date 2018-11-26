$(document).ready(function(){
        
	//Chamando metodo para popular select de categorias
	popularCategorias();
	
	//Evento change, para realizar novo select a cada item do select de categorias
	$("#cat").change(function(){
		popularSubcat(this,'subcat');
	});
});

function popularCategorias(){
	
	var comboCat=document.getElementById('cat');
    
	//Método para popular combo de categorias com ajax
	$.ajax({
				url:'utilcontroller.do?o=cat',
				type:'GET',
				datatype:'json',
				data:{valor:comboCat.options[comboCat.selectedIndex].value},
				success:function(categorias ){
					var myObject = eval('('+ categorias + ')');
					atribuirCategorias(myObject,comboCat);
				}
			});
    
    
}


//Metodo que atribui os valores no combo
function atribuirCategorias(json,combo){ 
	for(var i=0;i<json.length;i++){
		combo.options[combo.length] = new Option( json[i].descricao,json[i].idCategoria );
	}
	 
	
}

//function para limpar o combo 
function limparCombo(combo){
	while(combo.length>1){
		combo.remove(combo.length-1);
	} 
}

//Método para popular subcategorias
function popularSubcat(combo1,combo2){
	
	combo2= document.getElementById(combo2);
	
	limparCombo(combo2);
	
	if(combo1.options[combo1.selectedIndex].value!= ""){
			$.ajax({
			url:'utilcontroller.do?o=sub',
			type:'GET',
			datatype:'json',
			data:{valor:combo1.options[combo1.selectedIndex].value},
			success:function(resultado){
				var listaJSON = eval('('+ resultado + ')');
				atribuirSubcategorias(listaJSON,combo2);
				combo1.disabled=false;
				combo2.disabled=false;    
			}
		});
	}else{
		combo2.disabled=true;
	}
}

//Metodo que atribui os valores no combo
function atribuirSubcategorias(json2,combo){ 
	 
	for(var i=0;i<json2.length;i++){
		combo.options[combo.length] = new Option(json2[i].descricao,json2[i].idSub);
	}
}
