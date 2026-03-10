import java.util.*;

public class uc7_AutocompleteSystem {

    static HashMap<String, Integer> queries = new HashMap<>();

    public static void addQuery(String query) {
        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public static void search(String prefix) {

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                System.out.println(q + " (" + queries.get(q) + ")");
            }
        }
    }

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("javascript guide");
        addQuery("java download");

        System.out.println("Suggestions for 'jav':");
        search("jav");
    }
}