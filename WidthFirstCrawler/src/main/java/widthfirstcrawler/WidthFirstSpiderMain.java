package widthfirstspider;

public class WidthFirstSpiderMain {
    public static void main(String[] args) {
        WidthFirstSpider spider = new WidthFirstSpider();
        spider.crawling(new String[]{"http://www.163.com"});
    }
}
