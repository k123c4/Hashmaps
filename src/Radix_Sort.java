import java.util.*;

public class Radix_Sort{

    public static void main(String[] args) {
        String[] input = { "solo", "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        List<String> list = new ArrayList<>(Arrays.asList(input));
        String[] s = list.toArray(new String[0]);

        radixSort(s);

        System.out.println(String.join(", ", s));
    }

    public static void radixSort(String[] arr) {
        if (arr == null || arr.length == 0) return;


        int maxLength = 0;
        for (String str : arr) {
            maxLength = Math.max(maxLength, str.length());
        }

        for (int d = maxLength - 1; d >= 0; d--) {
            countingSortByCharacter(arr, d);
        }
    }

    private static void countingSortByCharacter(String[] arr, int d) {
        int n = arr.length;
        String[] output = new String[n];

        int[] count = new int[257];

        for (int i = 0; i < n; i++) {
            int charIndex = getCharIndex(arr[i], d);
            count[charIndex + 1]++;
        }

        for (int i = 1; i < 257; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int charIndex = getCharIndex(arr[i], d);
            output[count[charIndex + 1] - 1] = arr[i];
            count[charIndex + 1]--;
        }


        System.arraycopy(output, 0, arr, 0, n);
    }


    private static int getCharIndex(String s, int d) {
        if (d >= s.length()) {
            return -1;
        }
        return s.charAt(d);
    }
}