import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter dimension of matrix");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("x[" + i + "][" + j + "]=");
                x[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix x :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x[i][j] + " ");

            }
            System.out.println();
        }

        int max = x[0][0];
        int i_pos = 0, j_pos = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i][j] > max) {
                    max = x[i][j];
                    i_pos = i;
                    j_pos = j;
                }
            }
        }

        int[] a = new int[n];
        int[] c = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = x[i][j_pos];
        }

        for (int j = 0; j < n; j++) {
            c[j] = x[i_pos][j];
        }

        for (int i = 0; i < n; i++) {
            b[i] = a[i] * c[i];
        }

        System.out.println("Received vector B:");

        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }

        int[] b_copy1 = b;
        Integer b_copy2[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            b_copy2[i] = b[i];
        }

        System.out.println("sorting of vector:");

        System.out.println("1) Bubble");
        for (int j = n-1; j > 0; j--) {
            for (int i = 0; i < j ; i++) {
                if (b_copy1[i] < b_copy1[i + 1]) {
                    int r = b_copy1[i];
                    b_copy1[i] = b_copy1[i + 1];
                    b_copy1[i + 1] = r;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(b_copy1[i]);
        }

        System.out.println("2) sort()");
        Arrays.sort(b_copy2, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.println(b_copy2[i]);
        }
    }
}
