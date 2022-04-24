import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class WikipageHttp {
    Map<String, String> catWikipage = new HashMap<>();
    final private String URLPREFIX = "https://en.wikipedia.org/wiki/";

    public WikipageHttp() {
        catWikipage.put("bombay", URLPREFIX + "Bombay_cat");
        catWikipage.put("siamese", URLPREFIX + "Siamese");
        catWikipage.put("maine coon", URLPREFIX + "Maine_Coon");
        catWikipage.put("bombay", URLPREFIX + "Bombay_ca");
        catWikipage.put("burmese", URLPREFIX + "Burmese_cat");
    }


    public int catPageProvision(String catBreed) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = catWikipage.get(catBreed);

        if (url == null) {
            return -1;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }


}
