import java.util.*;

public class uc6_RateLimiter {

    static HashMap<String, Integer> requests = new HashMap<>();
    static int LIMIT = 5;

    public static boolean checkRateLimit(String clientId) {
        int count = requests.getOrDefault(clientId, 0);

        if (count >= LIMIT) {
            return false;
        }

        requests.put(clientId, count + 1);
        return true;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i++) {
            System.out.println("Request " + i + ": " + checkRateLimit("client1"));
        }
    }
}