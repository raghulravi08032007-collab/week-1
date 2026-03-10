import java.util.*;

public class uc1_UsernameChecker {

    private static HashMap<String, Integer> userMap = new HashMap<>();
    private static HashMap<String, Integer> attempts = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !userMap.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public static String getMostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        userMap.put("john_doe", 101);

        System.out.println("john_doe available? " + checkAvailability("john_doe"));
        System.out.println("jane_smith available? " + checkAvailability("jane_smith"));
        System.out.println("Suggestions: " + suggestAlternatives("john_doe"));
    }
}