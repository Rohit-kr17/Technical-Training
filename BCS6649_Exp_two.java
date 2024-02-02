public class BCS6649_Exp_two {

    // Function to rotate left the array by d positions
    static int[] rotateLeft(int[] arr, int d) {
        int n = arr.length;
        int[] rotatedArray = new int[n];

        // Calculate the effective rotation
        int rotation = d % n;

        // Copy elements to the rotated array
        for (int i = 0; i < n; i++) {
            int newIndex = (i + n - rotation) % n; // Calculate the new index after rotation
            rotatedArray[newIndex] = arr[i];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2; // Number of rotations

        int[] rotatedArray = rotateLeft(arr, d);

        // Print the rotated array
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}
