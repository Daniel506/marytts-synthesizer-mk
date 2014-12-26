
$(document).ready(function ($) {
  
  $('input').on("click", function(event) {
    
    var data = {};
    
    data['inputText'] = 'Hello how are you?';
    data['inputType'] = 'TEXT';
    data['selectedVoice'] = 'cmu-slt-hsmm';
    
      $.ajax({
        type: 'POST',
        url: '/Synthetizer/synthesize',
        data: data,
        success: function (response) {
        	$('audio').attr('src', '/Synthetizer/resources/wav/temp.wav');
        }
      });
  });

}); 