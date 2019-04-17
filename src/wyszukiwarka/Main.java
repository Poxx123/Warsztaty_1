package wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {

        wyszukaj();
    }

    static void wyszukaj() {

        final String[] sites = {"http://www.onet.pl/",
                "http://www.gazeta.pl/",
                "http://www.wp.pl/",
                "http://www.interia.pl/"};

        Set<String> popularWords = new TreeSet<>();
        for (int i = 0; i < sites.length; i++) {

            Connection connect = Jsoup.connect(sites[i]);
            try {
                Document document = connect.get();
                Elements links = document.select("span.title");
                for (Element elem : links) {

                    String[] words = elem.text().split("[,\"'?.:/!0-9 ]");

                    for (String word : words) {

                        if (word.length() > 2) {

                            popularWords.add(word);

                        }

                    }

                }


            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }

        }

        try {
            Files.write(Paths.get("popular_words.txt"), popularWords, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String[] excludedWords = {"oraz", "ponieważ", "ale", "dlatego", "może"};
        try {
            List<String> listOfPopularWords = Files.readAllLines(Paths.get("popular_words.txt"));

            for (int i=0; i<listOfPopularWords.size(); i++) {

                if(Arrays.asList(excludedWords).contains(listOfPopularWords.get(i))) {
                    listOfPopularWords.remove(i);
                }

            }

            Files.write(Paths.get("filtered_popular_words.txt"), listOfPopularWords, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


