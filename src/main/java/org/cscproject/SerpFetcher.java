package org.cscproject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class SerpFetcher implements Callable<List<String>> {
    private final String query;

    public SerpFetcher(String query) {
        this.query = query;
    }

    @Override
    public List<String> call() {
        try {
            String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
//            String url = "https://duckduckgo.com/?q=crime+reporting+papers&t=h_\n";
            System.out.println(url);
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            Elements results = doc.select("h3");

            return results.stream().map(Element::text).toList();
        } catch (IOException e) {
        }
        return List.of();
    }
}

