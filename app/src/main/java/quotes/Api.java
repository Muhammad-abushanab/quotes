package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Api {
    private HttpURLConnection connection;
    private final URL apiUrl;
    private final File filepath;

    public Api(URL apiUrl,  File filepath) {
        this.apiUrl = apiUrl;
        this.filepath = filepath;
    }

    public boolean connect() {
        try {
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.out.println("API connection failed with response code: " + responseCode);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void readAndWriteFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String quoteData = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            Qoute quote = gson.fromJson(quoteData, Qoute.class);
            System.out.println(quoteData);
            writeFile(quote,gson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeFile(Qoute quote , Gson gson){

        Qoute[] quotes;
        try {
            quotes = gson.fromJson(new FileReader(filepath), Qoute[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Qoute[] updatedQuotes;
        if (quotes != null) {
            updatedQuotes = Arrays.copyOf(quotes, quotes.length + 1);
            updatedQuotes[quotes.length] = quote;
        } else {
            updatedQuotes = new Qoute[]{quote};
        }
        try (FileWriter writer = new FileWriter(filepath)) {
            gson.toJson(updatedQuotes, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
