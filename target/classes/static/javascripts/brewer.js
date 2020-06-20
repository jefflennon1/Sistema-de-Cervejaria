var Brewer = Brewer || {}

Brewer.MaskMoney = (function(){
	
	function MaskMoney(){
		this.decimal = 	$('.js-decimal');
		this.plain = $('.js-plain');
		
	}
	
	MaskMoney.prototype.enable = function(){
		this.decimal.maskMoney({decimal: ','  , thousands: '.' });
		this.plain.maskMoney({precision: 0, thousands: '.'});   			
		
	}
	
	 return MaskMoney;
}())



$(function(){
	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();
	
	
	
	//Zera as casa decimais, aqui eu quero dizer que vou aplicar número inteiro 	
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
	

