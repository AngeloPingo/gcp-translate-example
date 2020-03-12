package pt.angelopingo.examples;

import lombok.extern.slf4j.Slf4j;
import pt.angelopingo.examples.gcp.Translator;

import java.io.IOException;

@Slf4j
public class MainApp {

    public static void main(String[] args) throws IOException {
        log.info("Application started.");

        if (args.length != 1) {
            System.err.println("You need to give the Google service account credentials JSON path!");
            System.err.println("If you don't have the JSON file, you can create it on https://console.cloud.google.com/iam-admin/serviceaccounts/create");
            System.exit(-1);
        }

        String credentialsPath = args[0];
        String string = "Hello World";

        Translator translator = new Translator();
        System.out.println("EN: " + string);
        System.out.println("PT: " + translator.translateWord(credentialsPath, string, "en", "pt"));
        System.out.println("ES: " + translator.translateWord(credentialsPath, string, "en", "es"));
        System.out.println("IT: " + translator.translateWord(credentialsPath, string, "en", "it"));
        System.out.println("DE: " + translator.translateWord(credentialsPath, string, "en", "de"));
        System.out.println("FR: " + translator.translateWord(credentialsPath, string, "en", "fr"));
    }

}
