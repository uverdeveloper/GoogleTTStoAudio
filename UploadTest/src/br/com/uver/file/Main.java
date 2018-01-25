package br.com.uver.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.uver.gtranslate.Audio;
import br.com.uver.gtranslate.Language;
import javazoom.jl.decoder.JavaLayerException;

public class Main {

	public static void main(String[] args) {

		/*File fileFolder = new File("C:/audio");
		if (!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		
		try {
			File fileLocal = new File("C:/audio/audioLocal.wav");
			fileLocal.createNewFile();
			System.out.println("Arquivo: [" + fileLocal.getName() + "] criado com sucesso.");
			fileLocal.renameTo(new File("C:/audio/audioFinal.wav"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}*/
		
		OutputStream out = null;

		String path = "c:/audio/";
	    
		Audio audio = Audio.getInstance();
        InputStream sound;
		try {
			sound = audio.getAudio("Juliano e um chefe bravo", Language.PORTUGUESE);
			
			out = new FileOutputStream(new File(path + File.separator
	                + "audioTest.wav"));

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = sound.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
			
			try {
				audio.play(sound);
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}

}
