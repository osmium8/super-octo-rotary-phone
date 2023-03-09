class Solution4 {
 
    public static void main(String args[]) {
        System.out.printf("Test Case #1: %.2f units%n", distance(0, 0, "NNNNEEENE"));
        System.out.printf("Test Case #2: %.2f units%n", distance(1, 2, "NSEW"));
    }
    
    public static double distance(int initialX, int initialY, String input) {
        char[] directions = input.toCharArray();
        
        int finalX = initialX;
        int finalY = initialY;
        
        for (char direction: directions) {
            if (direction == 'N') {
                ++finalY;
            } else if (direction == 'S') {
                --finalY;
            } else if (direction == 'E') {
                ++finalX;
            } else {
                --finalX;
            }
        }
        
        int deltaX = finalX - initialX;
        int deltaY = finalY - initialY;
        
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
