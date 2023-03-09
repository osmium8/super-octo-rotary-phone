import java.util.Arrays;

class Solution1 {  
    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 6, 5, 1, 2};
        int[] b = new int[]{3, 4, 3, 2, 2, 5};
        
        System.out.println(minMax(a, b) == 18 ? "#1 Passed" : "#1 Failed");
        
        a = new int[]{8,7,9,6,5,6,6,5,6,4,6,7,8,5,4,3,2,1,4,5,6,7,8,7,8};
        b = new int[]{2,4,5,6,7,6,7,8,9,8,7,6,7,6,5,4,3,2,3,4,5,5,5,4,5};
        
        System.out.println(minMax(a, b) == 63 ? "#2 Passed" : "#2 Failed");
        
        a = new int[]{1,2,3,2,3,4,5,3,5,6,7,8};
        b = new int[]{2,1,5,3,4,6,4,3,2,3,1,2};
        
        System.out.println(minMax(a, b) == 32 ? "#3 Passed" : "#3 Failed");
    }
    
    // Time Complexity: O(N)
    public static int minMax(int[] a, int[] b) {
        int[] list1 = Arrays.copyOfRange(a, 0, a.length);
        int[] list2 = Arrays.copyOfRange(b, 0, b.length);
        
        for (int i = 0; i < list1.length; ++i) {
            if (list2[i] > list1[i]) {
                swap(list1, list2, i);
            }
        }
        
        return max(list1) * max(list2);
    }
    
    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val: arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
    
    private static void swap(int[] arr1, int[] arr2, int index) {
        int temp = arr1[index];
        arr1[index] = arr2[index];
        arr2[index] = temp;
    }
}