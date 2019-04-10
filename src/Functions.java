import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        int x, a, b, u;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number x");
        x = scan.nextInt();

        System.out.println("x =" + x);

        System.out.println("Enter a number u");
        u = scan.nextInt();

        System.out.println("u ="+ u);

        System.out.println("Enter interval [a, b]");

        System.out.print("a = ");
        a = scan.nextInt();

        System.out.print("b = ");
        b = scan.nextInt();

        double f;
        if (a > b) {
            System.out.println("Incorrect interval");
        }
        else {
            if (x < a) {
                f = Math.cos(x + Math.log(x)) + Math.exp(x);
                System.out.println("f1");
            }
            else {
                if (x < b) {
                    f = Math.pow(x, 3) + Math.pow(x, 2) - 15;
                    System.out.println("f2");
                }
                else {
                    f = Math.tan(Math.PI * (x + u));
                    System.out.println("f3");
                }
            }
            System.out.printf("Function f = %.2f", f);
        }

    }
}
