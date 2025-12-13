import java.util.*;

public class VivaQ5 {
    public static String compress(String s){
        int count = 1; //every character start with count 1, no matter it got repeat or not
        String result = ""; //result that is going to be returned later

        for (int index = 0; index<s.length(); index++){
            char alpha = s.charAt(index); //alpha is the character that we are targeting, means the character that might be repeating
            while (((index+1) < s.length()) && (s.charAt(index)==s.charAt(index+1))){ 
            //the condition before && handle the case where index out of bound, and condition after && check whether it got repeat or not, by checking the adjacent character next to it
                count++;
                index++;
            }
            result+=count;
            result+=alpha;
            //append count and targeting character to result

            count=1;
            //this count will be initialized to 1 again, because we are switching target character
        }
        return result;
    }

    public static String decompress(String s){
        String result = ""; //result that is going to be returned later
        char first, second;
        for (int index=0; index<s.length(); index+=2){ 
            //index+=2 because 1 pair should contain 2 characters, 1 for digit and 1 for alphabet/space that should be repeating
            
            first = s.charAt(index); //first character in a pair

            if ((index+1)>=s.length()){
                return "Invalid encoding"; 
                //this case means last character is a digit, without following by any character, so it is invalid
            }

            second = s.charAt(index+1); //second character in a pair

            if (!((Character.isDigit(first)) && ((second==' ') || Character.isAlphabetic(second)))){
                //in a pair, first character must be a digit, and second character should be a space or alphabet, or else invald. Space is not considered an alphabet, so I make a special condition for it
                return "Invalid encoding";
            }
            
            int count = first-'0'; //convert first character (digit) to int
            result+=String.valueOf(second).repeat(count); //.repeat only can be used for String, so convert second which is a char to String first by using String.valueOf
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String mode=""; 
        do{
            System.out.print("Mode (C/D): ");
            mode = input.nextLine();
        }while (!(mode.equals("C") || mode.equals("D"))); 
        //Purpose of this do-while: if user enter word other than C or D, it will ask user to enter again

        System.out.print("Text: ");
        String text = input.nextLine();

        if (mode.equals("C")){
            System.out.println("Result: "+compress(text));
        }else if(mode.equals("D")){
            System.out.println("Result: "+decompress(text));
        }
        input.close();
    }
}
