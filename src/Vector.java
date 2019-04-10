import java.util.Scanner;

public class Vector {
    public static void main(String[] args)
    {
        start();
    }

    private static void start() {

        int n;
        System.out.println("Enter dimension of matrix");
        Scanner ns = new Scanner(System.in);
        n = ns.nextInt();

        if (n > 0) {


            int x[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("x[" + (i + 1) + "]=");
                Scanner xscan = new Scanner(System.in);
                x[i] = xscan.nextInt();
            }


            int k;
            System.out.println("Enter k");
            Scanner kscan = new Scanner(System.in);
            k = kscan.nextInt();


//        поиск эл-ов кратных k и сжатие массива
            int cnt = 0;
            int ncop = n;
            for (int i = 0; i < (ncop + 1); i++) {
                if ((x[i] % k) == 0) {
                    if (i == ncop) {
                        break;
                    } else {
                        x[i] = x[i + 1];
                        for (int j = i + 1; j < n - 1; j++) {
                            x[j] = x[j + 1];
                        }
                    }
                    cnt++; // кол-во эл-ов кратных k
                    ncop--;
                    i--;
                }
            }
//        System.out.println("Kolvo el" + cnt);


//        System.out.println("Matrix x :");
//        for (int i=0; i<n; i++) {
//            System.out.println(x[i]);
//        }
//
//        for (int i=(n-1); i>(n - cnt - 1); i--) {
//            x[i] = 0;
//        }

//        замена конца вектор на cnt кол-во нулей
            System.out.println("Transformed matrix x :");
            for (int i = 0; i < n; i++) {
                System.out.println(x[i]);
            }
        }
        else
            start();

    }
}
