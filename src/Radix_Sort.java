import java.util.*;

public class Radix_Sort{

    public static void main(String[] args) {
        String[] s = {"google", "gojo", "amazingly", "jogo", "luna", "pup","amazon", "puppy", "hydra", "amazonia", "vueltiao", "ama"};

        radixSort(s);

        // Print final result
        System.out.println(String.join(", ", s));
    }

    public static void radixSort(String[] arr) {
        int maxLength = 0;
        for (String str : arr) maxLength = Math.max(maxLength, str.length());

        // Process from rightmost character to leftmost
        for (int d = maxLength - 1; d >= 0; d--) {

            Map<Integer, List<String>> buckets = new HashMap<>();

            for (String str : arr) {
                // Use -1 for strings that are shorter than current index d
                int charVal = (d < str.length()) ? (int) str.charAt(d) : -1;

                buckets.putIfAbsent(charVal, new ArrayList<>());
                buckets.get(charVal).add(str);
            }


            int index = 0;

            List<Integer> sortedKeys = new ArrayList<>(buckets.keySet());
            Collections.sort(sortedKeys);

            for (int key : sortedKeys) {
                for (String str : buckets.get(key)) {
                    arr[index++] = str;
                }
            }
        }
    }
}