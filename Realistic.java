/**
 * The first loop on lines 40-42 helps us to find and remove the smallest value from the loop. The loop consists of these values: { 10, -5, 11, 2 }.
 * i range is from 0 to smallest index - 1.
 * This means that the loop finds the smallest element by taking the smallest index, 0, in this case, and the number under the smallest index is 10
 * and it compares this number to the next smallest index - 1 number, in this case, is -5, and so on, till it compares all the numbers and find the smallest one.
 * Then it copies all the numbers except the smallest one to the temporary array. The index position remains the same, as it doesn't specify i-1 or i+1.
 * The second loop on lines 43-45 is moving all the numbers that are left by one place to the left and filling the spot that is left from the smallest number.
 * There are 4 digits in the input and 3 digits in the output as a result.
 * Therefore, the index number is lower in the output than in the input, as it says i-1.
 * The numbers were moved and the index of each was lowered by one.
 */

import java.util.Arrays; // from printing array

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
                }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         */
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        
        public static void add(int value){
            int[] temporary = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
            temporary[i + i] = arr[i];
        }


        /*
         * Same result with a while loop
         * 
         * int temp_index = 0;
         * int arr_index = 0;
         * while (arr_index < arr.length) {
         *   if (arr_index != smallest_index) {
         *     temporary[temp_index] = arr[arr_index];
         *     temp_index++;
         *   }
         *   arr_index++;
         * }
         */

        arr = temporary; // array shorted by 1 (removing smallest elem)
        return result; // smallest element
    } // method getSmallest
    
    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    } // method main
} // class Realistic