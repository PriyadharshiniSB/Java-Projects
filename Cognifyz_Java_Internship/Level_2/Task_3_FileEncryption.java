package Level_2;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
class Task_3_FileEncryption {
    public static String processText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ('A' + (ch - 'A' + shift + 26) % 26);
            }
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('a' + (ch - 'a' + shift + 26) % 26);
            }
            result.append(ch);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }
        System.out.print("Enter file name or path: ");
        String filePath = sc.nextLine();
        File inputFile = new File(filePath);
        String outputName;
        if (choice == 1) {
            outputName = "encrypted_output.txt";
        } else {
            outputName = "decrypted_output.txt";
        }
        File outputFile = new File(inputFile.getAbsoluteFile().getParent(),
                                   outputName);
        int shift;
        if (choice == 1) {
            shift = 3;
        } else {
            shift = -3;
        }
        try (
            BufferedReader reader = new BufferedReader(
                new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(outputFile))
        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                String processed = processText(
                    String.valueOf((char) ch), shift);
                writer.write(processed);
            }
            System.out.println("Operation completed successfully!");
            System.out.println("Output saved at: "
                               + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
