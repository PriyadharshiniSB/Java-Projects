import java.util.Scanner;
import java.util.Random;
class Task_4_RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*";
        String characters = "";
        System.out.print("Enter password length: ");
        int length = sc.nextInt();
        if (length <= 0) {
            System.out.println("Invalid password length!");
        }
        else {
            System.out.print("Include numbers? (yes/no): ");
            String num = sc.next();
            System.out.print("Include lowercase letters? (yes/no): ");
            String lower = sc.next();
            System.out.print("Include uppercase letters? (yes/no): ");
            String upper = sc.next();
            System.out.print("Include special characters? (yes/no): ");
            String sp = sc.next();
            if (num.equalsIgnoreCase("yes")) {
                characters = characters + numbers;
            }
            if (lower.equalsIgnoreCase("yes")) {
                characters = characters + lowercase;
            }
            if (upper.equalsIgnoreCase("yes")) {
                characters = characters + uppercase;
            }
            if (sp.equalsIgnoreCase("yes")) {
                characters = characters + special;
            }
            if (characters.isEmpty()) {
                System.out.println("Please select at least one character type!");
            }
            else {
                String password = "";
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(characters.length());
                    password = password + characters.charAt(index);
                }
                System.out.println("Generated Password: " + password);
            }
        }
        sc.close();
    }
}
