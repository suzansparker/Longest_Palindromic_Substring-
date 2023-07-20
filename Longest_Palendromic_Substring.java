import java.util.Scanner;


public class Longest_Palendromic_Substring {

    public static String longestPalindromicSubstring(String A) {
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        // Every individual character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // Check for substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        // Return the longest palindromic substring
        return A.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter String");
        String A=sc.next();
        System.out.println(longestPalindromicSubstring(A));
    }
}
