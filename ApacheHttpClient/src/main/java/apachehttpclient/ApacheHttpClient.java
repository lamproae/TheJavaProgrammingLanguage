package apachehttpclient;

import java.io.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;

public class ApacheHttpClient {
    private static Logger logger = Logger.getLogger(ApacheHttpClient.class);

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    private void saveToLocal(byte[] data, String filePath) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
            for (int i = 0; i < data.length; i++) {
                out.write(data[i]);
            }
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFileNameByUrl(String url, String contentType) {
        url = url.substring(7);
        if (contentType.indexOf("html") != -1) {
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
            return url;
        } else {
            return url.replaceAll("[\\?/:*|<>\"]", "_") + "*." + 
                contentType.substring(contentType.lastIndexOf("/") + 1);
        }
    }


    public String downloadFile(String url) {
        String filePath = null;
        HttpClient httpClient = new HttpClient();

        logger.warn("Downloading .... " + url);
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(50000);
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                logger.warn("Method failed: " +  getMethod.getStatusLine());
                filePath = null;
            }

            byte[] responseBody = getMethod.getResponseBody();
            filePath = "./temp/" + getFileNameByUrl(url, getMethod.getResponseHeader("Content-Type").getValue());
            saveToLocal(responseBody, filePath);
        } catch (HttpException ex) {
            logger.warn("Please check your provided http address!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }

        return filePath;
    }
}
