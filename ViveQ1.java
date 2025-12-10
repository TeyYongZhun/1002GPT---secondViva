package vivaq1;
import java.util.Scanner;
public class VivaQ1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.print("Enter number: ");
        num=sc.nextInt();
        System.out.println("Digital root: "+digitalRoot(num));
    } 
    
    public static String digitalRoot(int num){
        String strnum=String.valueOf(num); //Convert int to string first
        while(strnum.length()>1){ //can detect digits based on converted int length
            num=0; //so that add all the nums together after every iteration
            for(int i=0;i<strnum.length();i++){
                num=num+Integer.parseInt(String.valueOf(strnum.charAt(i))); //Convert back to int and add all numbers in the digits
            }
            strnum=String.valueOf(num); //convert back to string for while loop check
        }
        return strnum;
    } 
}
