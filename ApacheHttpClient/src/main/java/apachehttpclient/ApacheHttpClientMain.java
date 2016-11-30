package apachehttpclient;

public class ApacheHttpClientMain {
    public static void main(String[] args) {
        ApacheHttpClient client = new ApacheHttpClient();
        client.downloadFile("http://www.longfuxiaoshuo.com");
    }
}
