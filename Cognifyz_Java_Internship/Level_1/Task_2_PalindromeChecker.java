import java.util.Scanner;
class Task_2_PalindromeChecker {
        static String revString(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        String clean = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                clean = clean + ch;
            }
        }
        String rev = revString(clean);
        if (clean.equals(rev)) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}
