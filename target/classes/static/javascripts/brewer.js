$(function(){
	var decimal = 	$('.js-decimal');
	decimal.maskMoney({decimal: ','  , thousands: '.' });
	
	var plain = $('.js-plain');
	plain.maskMoney({precision: 0, thousands: '.'}); //Zera as casa decimais, aqui eu quero dizer que vou aplicar número inteiro 
	
//	var plain1 = $('.js-plain1');
//	plain1.maskMoney({precision : 1});
//	
//	$(document).ready(function(){
//		$("#cpf").mask("999.999.999-99");
//	});
//
//	
//	
//	var cpf = $('.js-cpf');
//	cpf.mask("999.999.999-99");
});
	

