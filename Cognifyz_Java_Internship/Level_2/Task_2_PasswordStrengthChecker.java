package Level_2;
import java.util.Scanner;
public class Task_2_PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        int score = 0;
        boolean validLength = password.length() >= 8;
        if (validLength) {
            score++;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                hasUppercase = true;
            }
            else if (ch >= 'a' && ch <= 'z') {
                hasLowercase = true;
            }
            else if (ch >= '0' && ch <= '9') {
                hasNumber = true;
            }
            else if (!Character.isWhitespace(ch)) {
                hasSpecial = true;
            }
        }
        if (hasUppercase) {
            score++;
        }
        if (hasLowercase) {
            score++;
        }
        if (hasNumber) {
            score++;
        }
        if (hasSpecial) {
            score++;
        }
        System.out.println("\n----- Password Analysis -----");
        System.out.println("Password Length: " + password.length());
        System.out.println("Length (8 or more): " + validLength);
        System.out.println("Uppercase Letters: " + hasUppercase);
        System.out.println("Lowercase Letters: " + hasLowercase);
        System.out.println("Numbers: " + hasNumber);
        System.out.println("Special Characters: " + hasSpecial);
        System.out.println("Score: " + score + "/5");
        System.out.print("Password Strength: ");
        if (score == 5) {
            System.out.println("Strong");
        }
        else if (score >= 3 && validLength) {
            System.out.println("Moderate");
        }
        else {
            System.out.println("Weak");
        }
        sc.close();
    }
}
