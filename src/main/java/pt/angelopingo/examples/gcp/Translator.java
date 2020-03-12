package pt.angelopingo.examples.gcp;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

import java.io.FileInputStream;
import java.io.IOException;

import static java.util.Objects.isNull;

public class Translator {

    private Translate translate = null;

    public String translateWord(String keyPath, String word, String srcLag, String trgLag) throws IOException {
        if (isNull(translate)) {
            translate = TranslateOptions
                    .newBuilder()
                    .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(keyPath)))
                    .build()
                    .getService();
        }
        return translate
                .translate(
                        word,
                        Translate.TranslateOption.sourceLanguage(srcLag),
                        Translate.TranslateOption.targetLanguage(trgLag))
                .getTranslatedText();
    }

}
