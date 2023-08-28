/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            Qoute[] quotes = gson.fromJson(new FileReader("src/main/resources/qoutes.json"), Qoute[].class);
            QouteRandomizer random = new QouteRandomizer(quotes);
            if (args.length > 0) {
                String author = args[0].replace("_"," ");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}