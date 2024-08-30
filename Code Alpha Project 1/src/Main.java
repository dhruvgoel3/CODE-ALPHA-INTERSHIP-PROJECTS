import java.util.Scanner;

class Calculations {
    int result;

    int calculate(int maths, int physics, int chemistry, int english, int computer) {
        result = (maths + physics + chemistry + english + computer) / 5;
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int maths = 0;
        int physics = 0;
        int chemistry = 0;
        int english = 0;
        int computer = 0;

        System.out.println("Welcome to Student Grade Tracker");
        System.out.println("Only teachers can use it");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the marks of maths: ");
        maths = sc.nextInt();
        System.out.print("Enter the marks of physics: ");
        physics = sc.nextInt();
        System.out.print("Enter the marks of chemistry: ");
        chemistry = sc.nextInt();
        System.out.print("Enter the marks of English: ");
        english = sc.nextInt();
        System.out.print("Enter the marks of Computer: ");
        computer = sc.nextInt();

        // Create an instance of the Calculations class
        Calculations calc = new Calculations();

        // Call the calculate method and print the result
        int average = calc.calculate(maths, physics, chemistry, english, computer);
        System.out.println("The average mark is: " + average);
    }
}
