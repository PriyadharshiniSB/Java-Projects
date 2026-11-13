
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        double result;
        if (choice == 1) {
            result = (temp * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + result + " F");
        }
        else if (choice == 2) {
            result = (temp - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + result + " C");
        }
        else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
