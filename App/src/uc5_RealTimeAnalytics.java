import java.util.*;

public class uc5_RealTimeAnalytics {

    static HashMap<String, Integer> pageViews = new HashMap<>();

    public static void processEvent(String url) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
    }

    public static void showTopPages() {
        pageViews.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        processEvent("/article/news");
        processEvent("/article/news");
        processEvent("/sports");

        showTopPages();
    }
}