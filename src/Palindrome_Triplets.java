import java.util.*;

public class Palindrome_Triplets {

    public static void main(String[] args) {
        String[] words = {"race", "car", "ecar", ""};
        List<int[]> result = findPalindromeTriplets(words);


        System.out.print("[ ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i)).replace("[", "{").replace("]", "}"));
            if (i < result.size() - 1) System.out.print(" , ");
        }
        System.out.println(" ]");
    }

    public static List<int[]> findPalindromeTriplets(String[] words) {
        List<int[]> triplets = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    // Concatenate and convert to lowercase for comparison
                    String combined = (words[i] + words[j] + words[k]).toLowerCase();

                    if (isPalindrome(combined)) {
                        triplets.add(new int[]{i, j, k});
                    }
                }
            }
        }
        return triplets;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}