$(document).ready(function(){
    $("#fone").focusin(function(){
       $(this).mask("(99) 9999-9999");
    });
    
    $("#cep").focusin(function(){
       $(this).mask("99.999-999");
    });
    
     $("#cnpj").focusin(function(){
       $(this).mask("99.999.999/9999-99");
    });
    
     $("#salario").focusin(function(){
         $(this).maskMoney({decimal:",", thousands:"."});
      });
     
     $("#data").focusin(function(){
    	 $(this).mask("99/99/9999");
     });

});