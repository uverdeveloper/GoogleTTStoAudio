package br.com.uver.gtranslate.parsing;

import java.util.Map;

import com.google.gson.Gson;

import br.com.uver.gtranslate.URLCONSTANTS;
import br.com.uver.gtranslate.text.Text;
import br.com.uver.gtranslate.utils.WebUtils;

public class ParseTextDetect implements Parse {
    private StringBuilder url;
    private Text input;
    private Gson gson;

    public ParseTextDetect(Text input) {
        this.input = input;
        this.gson = new Gson();
    }

    @Override
    public void appendURL() {

        url = new StringBuilder(URLCONSTANTS.GOOGLE_TRANSLATE_TEXT);
        url.append("text=" + input.getText().replace(" ", "%20"));
        url.append("&oe=UTF-8&");
        url.append("tl=en&");
        url.append("client=z&");
        url.append("sl=&");
        url.append("ie=UTF-8");
    }

    @Override
    public void parse() {

        appendURL();
        String result = WebUtils.source(url.toString());

        Map map = gson.fromJson(result, Map.class);
        String inputLanguage = (String) map.get("src");

        input.setLanguage(inputLanguage);
    }

}
