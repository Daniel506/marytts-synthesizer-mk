package mk.finki.ukim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marytts.client.MaryClient;
import marytts.client.MaryClient.AudioPlayerListener;
import marytts.client.http.MaryHttpClient;
import marytts.util.data.audio.AudioPlayer;

@Service
public class MaryClientProcessorService {

	@Autowired
	private MaryClient processor;
	
	@Autowired
	AudioPlayer audioPlayer = new AudioPlayer();
	
	public AudioPlayer processInput(String inputText, String inputType, String selectedVoice) {
		
		try {
      String locale = "mk";
  	  boolean streamMp3 = false;
  	
	  	processor.streamAudio(inputText, 
	    	inputType,
	      locale,
	      streamMp3 ? "MP3":"AU",
	      selectedVoice,
	      "",
	      null,
	      audioPlayer,
	      null
	      /*new AudioPlayerListener() {
	  			
	  			public void playerFinished() {
	  				resetPlayButton();
	        }
	    
	        public void playerException(Exception e) {
	          e.printStackTrace();
	          resetPlayButton();
	        }
	                
	        private void resetPlayButton() {
	          if (audioPlayer != null) {
	            audioPlayer.cancel();
	            audioPlayer = null;
	          }
	        }
	      }*/
	  	);
	  	
	  	return audioPlayer;
	  	
		} catch (Exception e) {
		    e.printStackTrace();
		}
	        
	  return null;
	}
	
}
