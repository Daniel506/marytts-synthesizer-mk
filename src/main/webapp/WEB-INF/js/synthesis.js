$(document).ready() {
	
	$('#sinthesize').on("click", function(event) {
		
		var data = _getSinthesisData();
		
		$.ajax({
		  type: 'POST',
		  url: '/synthesize',
		  data: data,
		  success: success,
		  dataType: dataType
		});
	});
	
	
}

_getSinthesisData : function () {
	var data = {};
	
	data['inputText'] = 'Hello how are you?';
	data['inputType'] = 'blabla';
	data['selectedVoice'] = 'hahahaha';
	
	return data;
}