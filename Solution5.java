import java.util.ArrayList;
import java.util.List;

class Solution5 {
 
    public static void main(String args[]) {
        int[] testCases = new int[]{8, 28, 496};
        for (int input: testCases) {
            System.out.printf("%d is %sa Perfect Number.%n", input, sum(getDivisors(input)) == input ? "" : "NOT ");
        }
    }
    
    // Time Complexity: O(sqrt(N))
    public static List<Integer> getDivisors(int N) {
        List<Integer> divisors = new ArrayList<>();
        
        for(int f = 2; f * f < N; ++f) {
             if (N % f == 0) {
             if (N / f == f)  { divisors.add(f); }
             else             { divisors.add(f); divisors.add(N/f); }
           }
        }
        divisors.add(1);
        
        return divisors;
    }
    
    private static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
