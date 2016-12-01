package simplejsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class SimpleJsoupMain {
    public static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 50 * 1000;
    public static void main(String[] args) throws IOException {
        // Validate.isTrue(args.length == 1 || args.length == 2, "usage: java -cp jsoup.jar org.jsoup.examples.HtmlToPlainText url [selector]");
        // final String url = args[0];
        // final String selector = args.length == 2 ? args[1] : null;
        // final String selector = ".slider-main";
        final String selector = "#layout-news";
        // final String selector = "body";
        // final String selector = "#m-img";

        // fetch the specified URL and parse to a HTML DOM
        Document doc = Jsoup.connect("http://www.163.com").userAgent(userAgent).timeout(timeout).get();

        SimpleJsoup formatter = new SimpleJsoup();

        if (selector != null) {
            Elements elements = doc.select(selector); // get each element that matches the CSS selector
            for (Element element : elements) {
                String plainText = formatter.getPlainText(element); // format that element to plain text
                System.out.println(plainText);
            }
        } else { // format the whole doc
            String plainText = formatter.getPlainText(doc);
            System.out.println(plainText);
        }
    }
}
