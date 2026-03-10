import java.util.*;

public class uc10_MultiLevelCacheSystem {

    static LinkedHashMap<String, String> L1Cache = new LinkedHashMap<>(5, 0.75f, true);
    static HashMap<String, String> L2Cache = new HashMap<>();

    public static String getVideo(String id) {

        if (L1Cache.containsKey(id)) {
            return "L1 Cache HIT";
        }

        if (L2Cache.containsKey(id)) {
            L1Cache.put(id, L2Cache.get(id));
            return "L2 Cache HIT → promoted to L1";
        }

        L2Cache.put(id, "VideoData");
        return "Loaded from Database";
    }

    public static void main(String[] args) {

        System.out.println(getVideo("video123"));
        System.out.println(getVideo("video123"));
    }
}