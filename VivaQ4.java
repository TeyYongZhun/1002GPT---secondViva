import java.util.Scanner;
public class VivaQ4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][]board=new char[3][3];
        for(int i=0;i<3;i++){ //repeat 3 times
            System.out.print("Enter row "+(i+1)+" : ");
            String row=sc.next(); //read row as string
            for(int j=0;j<3;j++){
                board[i][j]=row.charAt(j); //read each characters in the string
            }
        }
        int x=countMoves(board,'X'); //number of 'X'
        int o=countMoves(board,'O'); //number of 'O'
        if(x==o||x-o==1){ //always start with 'X', so need to be equal or one more than 'O'to proceed
            if(checkWinner(board)=='X'||checkWinner(board)=='O'){
                System.out.println("Winner: "+checkWinner(board));
            }
            else{
                System.out.println("No winner");
            }
        }
        else{
            System.out.println("");
            System.out.println("Invalid board: number of moves is not valid");
        }
    }
    
    public static int countMoves(char[][]board,char y){
        int n=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==y){ //detects char y 
                    n=n+1; //if char Y detected
                }
            }
        }
        return n;
    }
    
    public static char checkWinner(char[][]board){
        for(int i=0;i<3;i++){
            if(board[i][0]=='X'&&board[i][1]=='X'&&board[i][2]=='X'){ //detect horizontal winning line
                return 'X';
            }
            else if(board[i][0]=='O'&&board[i][1]=='O'&&board[i][2]=='O'){
                return 'O';
            }
            else if(board[0][i]=='X'&&board[1][i]=='X'&&board[2][i]=='X'){ //detect vertical winning line
                return 'X';
            }
            else if(board[0][i]=='O'&&board[1][i]=='O'&&board[2][i]=='O'){
                return 'O';
            }
        }
        
        if (board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X'){ //detect diagonal winning line
            return 'X';}
        else if (board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O'){
            return 'O';}
        else if (board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X') {
            return 'X';}
        else if (board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O') {
            return 'O';}
        return '.'; //no winning line detection
    }
}
