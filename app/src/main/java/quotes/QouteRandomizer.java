package quotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QouteRandomizer {
    private final Qoute[] quotes;
    private final Random random;

    public QouteRandomizer(Qoute[] quotes) {
        this.quotes = quotes;
        this.random = new Random();
    }

    public Qoute getRandomQoute(){
        if (quotes != null && quotes.length > 0) {
            int randomIndex = random.nextInt(quotes.length);
            return quotes[randomIndex];
        }
        return null;
    }
    public List<Qoute> searchByAuthor(String author){
        List<Qoute> authorQuotes = new ArrayList<>();
        if (quotes != null) {
            for (Qoute quote: quotes
                 ) {
                if (quote.author.equalsIgnoreCase(author)){
                    authorQuotes.add(quote);
                }
            }
            return authorQuotes;
        }
        return null;
    }
}
