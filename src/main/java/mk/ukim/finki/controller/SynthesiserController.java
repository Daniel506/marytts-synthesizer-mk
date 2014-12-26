package mk.ukim.finki.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mk.finki.ukim.services.MaryClientAudioService;
import mk.finki.ukim.services.MaryClientProcessorService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SynthesiserController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    MaryClientAudioService maryClientAudioService;
    
    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");

        return new ModelAndView("synthesis");
    }
    
    @RequestMapping("/synthesis")
    public ModelAndView handleRequestD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");

        return new ModelAndView("synthesis");
    }
    
    @RequestMapping(value="/synthesize", method=RequestMethod.POST)
    public ModelAndView handleSinthesize(
    		HttpServletRequest request, 
    		@RequestParam(value="inputText", required=true) String inputText,
    		@RequestParam(value="selectedVoice", required=true) String selectedVoice,
    		@RequestParam(value="inputType", required=true) String inputType,
    		HttpServletResponse response)
            throws ServletException, IOException {

    		maryClientAudioService.streamAudio(inputText, inputType, selectedVoice);
    		
        return new ModelAndView("hello");
    }

}