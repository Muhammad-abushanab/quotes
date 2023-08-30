package quotes;

public class Qoute {
    private final String author;
    private final String text;
    private String content;
    private String[] tags;
    private final String likes;

    public Qoute(String author, String text,String likes) {
        this.author = author;
        this.text = text;
        this.likes =likes;
    }

    public String getLikes() {
        return likes;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Qoute{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
}
