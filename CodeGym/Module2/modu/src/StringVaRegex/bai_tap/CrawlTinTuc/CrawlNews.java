package StringVaRegex.bai_tap.CrawlTinTuc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    private static final String NEWS_REGEX = "title=\"(.*?)\" class=\"fon6\"";

    public void crawlNews(URL url) throws MalformedURLException {
        InputStreamReader inputStreamReader;
        Scanner sc;
        String content;
        Pattern pattern;
        Matcher matcher;
        try {
            inputStreamReader = new InputStreamReader(url.openStream());
            sc = new Scanner(inputStreamReader);
            sc.useDelimiter("\\Z");
            content = sc.next();
            sc.close();
            content = content.replaceAll("\\n+", "");
            pattern = Pattern.compile(NEWS_REGEX);
            matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
