import java.util.Scanner;

public class VivaQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array A: " );
        String lineA = sc.nextLine();
        System.out.print("Array B: ");
        String lineB = sc.nextLine();

        int[] arrayA = parseInput(lineA);
        int[] arrayB = parseInput(lineB);
    
        //Check the length requirement (1-50 elements)
        if (arrayA.length < 1 || arrayA.length > 50 || arrayB.length < 1 || arrayB.length > 50) {
            System.out.println("Invalid input: Array length must be between 1 and 50.");
            return; // Stop the program if it already fails the length requirement
        }

        boolean result = isMirror(arrayA, arrayB); //Check if they are mirror patterns and print the result
        System.out.println("Mirror pattern: " + result);

    }

    public  static int[] parseInput (String line) {
        // It splits the string by the comma "," AND removes any spaces ("\\s*") around it.
        // Example: "1, 2,  3" becomes ["1", "2", "3"]
        String[] parts = line.split("\\s*,\\s*"); 
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    public static boolean isMirror(int[]a, int[]b){
        if(a.length != b.length){ //check if lengths are equal
            return false;
        }

        int length = a.length;
        for(int i = 0; i < length; i++){
            if(a[i] != b[length - 1 - i]){
                return false;
            }
        }
        return true; //reyurn true if all elements match the mirror condition
    }
}
