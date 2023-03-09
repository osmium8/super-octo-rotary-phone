import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution3 {  
    public static void main(String args[]) {
        String[] input1 = new String[]{"d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77"};
        customSorting(input1);
    }
    
    private static void customSorting(String[] input) {
        
        List<String> list = new ArrayList<>();
        
        for (String val: input) {
            list.add(val);
        }
        
        Collections.sort(list, new SortByFirstCharacter());
        System.out.println("L1: "+list);
        
        Collections.sort(list, new SortSameCharacterByNumberDescending());
        System.out.println("L2: "+list);
    }
    
    static class SortByFirstCharacter implements Comparator<String> {
        
        @Override
        public int compare(String a, String b) {
            if (b.charAt(0) == a.charAt(0)) return 0;
            if (b.charAt(0) > a.charAt(0)) return -1;
            return 1;
        }
    }
    
    static class SortSameCharacterByNumberDescending implements Comparator<String> {
        
        @Override
        public int compare(String a, String b) {
            if (b.charAt(0) == a.charAt(0)) {
                int firstNumber = a.length() == 3 ? Integer.parseInt(a.substring(1, 3)) : Integer.parseInt(a.substring(1, 2));
                int secondNumber = b.length() == 3 ? Integer.parseInt(b.substring(1, 3)) : Integer.parseInt(b.substring(1, 2));
                return secondNumber - firstNumber;
            }
            return 0;
        }
    }
}
