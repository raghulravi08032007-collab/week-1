import java.util.*;

public class uc4_PlagiarismDetector {

    public static Set<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        Set<String> grams = new HashSet<>();

        for (int i = 0; i <= words.length - n; i++) {
            String gram = "";
            for (int j = 0; j < n; j++) {
                gram += words[i + j] + " ";
            }
            grams.add(gram.trim());
        }
        return grams;
    }

    public static double similarity(String a, String b) {
        Set<String> s1 = getNGrams(a, 3);
        Set<String> s2 = getNGrams(b, 3);

        s1.retainAll(s2);
        return (s1.size() * 100.0) / getNGrams(a, 3).size();
    }

    public static void main(String[] args) {
        String doc1 = "java is a programming language used worldwide";
        String doc2 = "java is a programming language";

        System.out.println("Similarity: " + similarity(doc1, doc2) + "%");
    }
}