package widthfirstspider;

import java.util.*;

public class WidthFirstSpider {
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
