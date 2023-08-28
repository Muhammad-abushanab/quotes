package quotes;

public class Qoute {
    public String author;
    public String text;

    public Qoute(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' + "\n"
                ;
    }
}
