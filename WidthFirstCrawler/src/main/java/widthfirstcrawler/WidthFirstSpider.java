package widthfirstspider;

import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WidthFirstSpider {
    private static Logger logger = Logger.getLogger(WidthFirstSpider.class);

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            LinkQueue.addUnvisitedUrl(seeds[i]);
        }
    }

    public void crawling(String[] seeds) {
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.163.com"))
                    return true;
                else
                    return false;
            }
        };

        logger.warn(seeds);
        initCrawlerWithSeeds(seeds);
        
        while(!LinkQueue.unVisitedUrlsEmpty() && LinkQueue.getVisitedUrlNum() <= 1000) {
            String visitUrl = (String)LinkQueue.unVisitedUrlDeQueue();
            if (visitUrl == null)
                continue;

            DownloadFile downLoader = new DownloadFile();
            LinkQueue.addVisitedUrl(visitUrl);

            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);

            for (String link : links) {
                LinkQueue.addUnvisitedUrl(link);
            }
        }
    }
}
