package mk.finki.ukim.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaryClientAudioService {
	
	@Autowired
	MaryClientProcessorService maryClientProcessorService;
	
	public void streamAudio(String inputText, String inputType, String selectedVoice) {
		
		try {
			
			InputStream inputStream = maryClientProcessorService.processInput(inputText, inputType, selectedVoice);
			File outputTempFile = new File("C:/Users/DANIEL/git/marytts-synthesizer-mk/src/main/webapp/resources/wav/temp.wav");
			FileUtils.writeByteArrayToFile(outputTempFile, IOUtils.toByteArray(inputStream));
//			AudioFormat audioFormat = new AudioFormat(16000, 16, 1, false, true);
//	    int numSamples = IOUtils.toByteArray(inputStream).length *100;
//			AudioInputStream audioInputStream = new AudioInputStream(inputStream, audioFormat, numSamples);
//			
//			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputTempFile);
			
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}
}
