package br.com.uver.gtranslate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import br.com.uver.gtranslate.Audio;
import br.com.uver.gtranslate.Language;
import br.com.uver.gtranslate.Translator;
import javazoom.jl.decoder.JavaLayerException;

public class TranslatorTest {
    Translator translator = Translator.getInstance();

   /* @Test
    public void testTranslateText() {
        String text = translator.translate("I am programmer", Language.ENGLISH, Language.PORTUGUESE);
        assertEquals("Eu sou programador", text);
    }

    @Test
    public void testDetectLanguage() {
        String language = translator.detect("Hello World");
        assertEquals("en", language);
    }*/

    @Test
    public void testPlayingAudio() throws IOException, JavaLayerException {
        Audio audio = Audio.getInstance();
        InputStream sound = audio.getAudio("casa", Language.PORTUGUESE);
        audio.play(sound);

        assertTrue(sound != null);
    }

}