import java.util.Scanner;
class Task_3_StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid number of subjects!");
        }
        else {
            double[] grades = new double[n];
            double sum = 0;
            for (int i = 0; i < n; i++) {
                System.out.print("Enter grade for subject " + (i + 1) + ": ");
                grades[i] = sc.nextDouble();
                sum = sum + grades[i];
            }
            double average = sum / n;
            System.out.println("Total marks: " + sum);
            System.out.println("Average grade: " + average);
        }
        sc.close();
    }
}
