package com.sumit.playjava;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class Test_To_Speech {
	private static final String VOICE_KEY="freetts.voices"; //key
	private static final String VOICE_VALUE="com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory"; // directory
	private static final String CENTRAL_DATA="com.sun.speech.freetts.jsapi.FreeTTSEngineCentral"; // package name
	
	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String data=sc.nextLine();
		System.setProperty(VOICE_KEY,VOICE_VALUE);
		
		
		Central.registerEngineCentral(CENTRAL_DATA);
		Synthesizer sy=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		sy.allocate();
		sy.resume();
		sy.speakPlainText(data, null);
		sy.waitEngineState(Synthesizer.QUEUE_EMPTY);
		sy.deallocate();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
	}

}

