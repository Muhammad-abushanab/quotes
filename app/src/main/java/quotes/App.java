/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) {
        try {
            Api api = new Api(new URL("https://api.quotable.io/random"), new File("app/src/main/resources/qoutes.json"));

            if (api.connect()) {
                api.readAndWriteFile();
            } else {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Qoute[] quotes = gson.fromJson(new FileReader("app/src/main/resources/qoutes.json"), Qoute[].class);
                QouteRandomizer random = new QouteRandomizer(quotes);


                if (args.length > 0) {
                    String author = args[0].replace("_", " ");
                    List<Qoute> byAuthor = random.searchByAuthor(author);
                    System.out.println(byAuthor.toString());
                } else {
                    Qoute randomQuote = random.getRandomQoute();
                    if (randomQuote != null) {
                        System.out.println(randomQuote.getAuthor() + "\n" + randomQuote.getText());
                    } else {
                        System.out.println("No quote found");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}