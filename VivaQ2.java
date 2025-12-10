
import java.util.Scanner;

public class VivaQ2 {

    public static boolean isBalanced(String a) {
        int balanced = 0;
        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) == '(') {
                balanced += 1;
            }

            else if (a.charAt(i) == ')') {
                balanced -= 1;
            }

            if (balanced < 0) {
                return false;
            }

        }

        if (balanced != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression:");
        String exp = sc.nextLine();
        if (isBalanced(exp)) {
            System.out.print("Balanced");
        } else {
            System.out.print("Not balanced");
        }
    }
}
