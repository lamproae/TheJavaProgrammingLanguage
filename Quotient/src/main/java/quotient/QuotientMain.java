package quotient;

public class QuotientMain {
    public static void main(String[] args) {
           java.util.Scanner input = new java.util.Scanner(System.in);
           System.out.print("Enter two integers: ");
           int number1 = input.nextInt();
           int number2 = input.nextInt();
           System.out.println(number1 + " / " + number2 + " is " + (number1/number2));
    }
}
