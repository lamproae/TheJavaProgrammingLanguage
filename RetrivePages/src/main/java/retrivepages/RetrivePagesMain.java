package retrivepages;

import java.io.*;
import org.apache.commons.httpclient.HttpException;

public class RetrivePagesMain {
    public static void main(String[] args) {
        RetrivePages rp = new RetrivePages("http://www.baidu.com");
        RetrivePages rp1 = new RetrivePages("http://www.163.com");
        try {
            rp.downloadPage();
            rp1.downloadPage();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
