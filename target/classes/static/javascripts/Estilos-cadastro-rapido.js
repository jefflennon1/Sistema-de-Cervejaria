$(function(){
	var modal = $('#modalCadastroRapidoEstilo');
	var botaoSalvar = modal.find('.btn-salvar-estilo-cadastro-rapido-modal');
	 var form = modal.find('form');
	var url = form.attr('action');
	var inputNomeEstilo = modal.find('#nomeEstilo');
	var containerMensagemErro = modal.find('.js-mensagem-cadastro-rapido-estilo');
	
	form.on('submit', function(e) { e.preventDefault() });
	botaoSalvar.on('click', onBotaoSalvarClick);
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	
	
	function onModalShow(){
		  inputNomeEstilo.focus()
	  }
	
	function onModalClose(){
		inputNomeEstilo.val('');
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick(){
		var nomeEstilo = inputNomeEstilo.val().trim();
//		console.log(nomeEstilo)
		$.ajax({
			url: url,
			contentType: 'application/json',
			method: 'POST',
			 //Stringify é uma função pra transformar meus dados em  objeto json
			data: JSON.stringify({ nome: nomeEstilo }) ,
			error: onErroSalvandoEstilo,
			success: onEstiloSalvo
		});	
	}
	
	function onErroSalvandoEstilo(obj){
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden'); //fazendo a classe que esconde a div de erro escondida
		containerMensagemErro.html('<span>'+mensagemErro+'</span>'); 
		form.find('.form-group').addClass('has-error');
	}
	
	
	function onEstiloSalvo(estilo){
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value='+estilo.codigo+'>' +estilo.nome+'<option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}
	
 
});