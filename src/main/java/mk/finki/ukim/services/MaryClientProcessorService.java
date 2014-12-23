package mk.finki.ukim.services;

import marytts.client.MaryClient;
import marytts.util.data.audio.AudioPlayer;

public class MaryClientProcessorService {

	private static MaryClient processor;
	
	public static void processInput(String inputText, String inputType, String selectedVoice) {
		
		try {
		  
		  AudioPlayer audioPlayer = new AudioPlayer();
		  
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
	  	
		} catch (Exception e) {
		    e.printStackTrace();
		}
	        
	}
	
}
