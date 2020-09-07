package StringVaRegex.bai_tap.CrawlTinTuc;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL url;
        CrawlNews crawlNews;
        try {
            crawlNews = new CrawlNews();
            url = new URL("https://dantri.com.vn/the-thao.htm");
            crawlNews.crawlNews(url);
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}
