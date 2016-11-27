package retrivepages;

import java.io.*;
import org.apache.log4j.Logger;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpException;

public class RetrivePages {
    private String page;
    private static HttpClient client = new HttpClient();
    private static Logger logger = Logger.getLogger(RetrivePages.class);

    public RetrivePages(String page) {
        this.page = page;
    }

    public boolean downloadPage() throws HttpException, IOException {
        InputStream input = null;
        OutputStream output = null;

        GetMethod getMethod = new GetMethod(page);
        int statusCode = client.executeMethod(getMethod);
        logger.debug("Downloading " + page + " with status code " + statusCode + "!");
        if (statusCode == HttpStatus.SC_OK) {

            input = getMethod.getResponseBodyAsStream();
            String fileName = page.substring(page.lastIndexOf('/')+1);
            output = new FileOutputStream(fileName);

            int tempByte = -1;

            while ((tempByte = input.read()) > 0) {
                output.write(tempByte);
            }
            if (input != null) {
                    input.close();
                }

            if (output != null) {
                output.close();
            }
            return true;
        }
        return false;
    }
}
