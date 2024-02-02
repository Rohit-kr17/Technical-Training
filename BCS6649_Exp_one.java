public class BCS6649_Exp_one {
    public static void main(String[] args) {
        // Sample array
        int[] array = {1, 2, 3, 4, 5};
        
        // Print original array
        System.out.println("Original array:");
        printArray(array);
        
        // Reverse the array
        reverseArray(array);
        
        // Print reversed array
        System.out.println("\nReversed array:");
        printArray(array);
    }
    
    // Method to reverse the array
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move pointers
            start++;
            end--;
        }
    }
    
    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line
    }
}
