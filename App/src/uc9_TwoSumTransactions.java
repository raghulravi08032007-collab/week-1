import java.util.*;

public class uc9_TwoSumTransactions {

    public static void findTwoSum(int[] transactions, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : transactions) {

            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair Found: " + num + " + " + complement);
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {

        int[] transactions = {500, 300, 200};

        findTwoSum(transactions, 500);
    }
}
