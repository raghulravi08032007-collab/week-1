import java.util.*;

public class uc2_FlashSaleInventoryManager {

    static HashMap<String, Integer> stock = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    public static void addProduct(String id, int quantity) {
        stock.put(id, quantity);
    }

    public static synchronized String purchaseItem(String id, int userId) {
        int qty = stock.getOrDefault(id, 0);

        if (qty > 0) {
            stock.put(id, qty - 1);
            return "Success, remaining: " + (qty - 1);
        } else {
            waitingList.add(userId);
            return "Added to waiting list position: " + waitingList.size();
        }
    }

    public static void main(String[] args) {
        addProduct("IPHONE15", 2);

        System.out.println(purchaseItem("IPHONE15", 1));
        System.out.println(purchaseItem("IPHONE15", 2));
        System.out.println(purchaseItem("IPHONE15", 3));
    }
}