public class ArrayOps {
    public static void main(String[] args) {

        int[] arr = { 1, -2, 3 };
        System.out.println(isSorted(arr));

    }

    public static int findMissingInt(int[] array) {

        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == arr[j]) {
                    arr[j] = -1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                return arr[i];

            }
        }
        return -1;
    }

    public static int secondMaxValue(int[] array) {

        int Max1 = array[0];
        int Max2 = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > Max1) {
                Max2 = Max1;
                Max1 = array[i];

            }

            else if (array[i] > Max2 && array[i] != Max1) {
                Max2 = array[i];

            }

        }

        return Max2;

    }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {

        boolean Exist = false;

        for (int i = 0; i < array1.length; i++) {
            Exist = false; // Reset the varible
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    Exist = true;
                }
            }

            if (Exist == false) { // if the sycle finished and didn't find a match, so return false and don't even
                                  // start the next sycle
                return false;

            }

        }

        return Exist;

    }

    public static boolean isSorted(int[] array) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
            } else if (array[i] < array[i - 1]) {
                increasing = false;
            }
            if (!increasing && !decreasing) {
                return false;
            }
        }

        // Either increasing or decreasing, not both, means the array is sorted
        return true;

    }

}
