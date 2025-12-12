import java.util.Scanner;

public class VivaQ3 {

    public static void main(String[] args) {
        //Create a scanner object
        Scanner input = new Scanner (System.in);
        
        //Prompt user to input a ticket number
        System.out.print("Enter ticket number: ");
        String ticketNum = input.nextLine();
        
        //Check validation of ticket number entered
        // 1. Check if length of the string is odd (Invalid ticket number)
        // 2. Check if string contains non-digits (Invalid ticket number)
        if (ticketNum.length() %2 != 0 || !ticketNum.matches("[0-9]+")){
            System.out.println("Invalid ticket number.");
        }
        // If valid, pass the string to the helper method
        else if (isLuckyTicket(ticketNum)){
            System.out.println("Lucky");
        }
        else {
            System.out.println("Unlucky");
        }
        
    }
    
    public static boolean isLuckyTicket (String ticket){
        // Find the middle index to split the string into two equal parts
        int mid = ticket.length() / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        
        // Loop through the first half of the string (0 to mid-1)
        for (int i = 0; i < mid; i++) {
            // Subtracting char '0' converts the ASCII char to its integer value
            sumFirstHalf += ticket.charAt(i) - '0';
        }
        
        // Loop through the second half of the string (mid to end)
        for (int i = mid; i < ticket.length(); i++) {
            sumSecondHalf += ticket.charAt(i) - '0';
        }
        
        // Compare sum of FirstHalf and sum of SecondHalf
        return sumFirstHalf == sumSecondHalf;
    }
}

