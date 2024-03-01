import java.util.Scanner;

public class BCS6649_Exp_three {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = calculateSum(h1);
        int sum2 = calculateSum(h2);
        int sum3 = calculateSum(h3);

        int index1 = 0, index2 = 0, index3 = 0;

        while (!(sum1 == sum2 && sum2 == sum3)) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1[index1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2[index2++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3[index3++];
            }
        }

        return sum1; // or sum2 or sum3, they are all equal now
    }

    static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            h1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            h2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            h3[i] = scanner.nextInt();
        }

        System.out.println(equalStacks(h1, h2, h3));
    }
}

// 5 3 4
// 3 2 1 1 1
// 4 3 2
// 1 1 4 1