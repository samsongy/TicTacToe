import java.util.Scanner;
import java.util.Arrays;

public class Program {

    public static void Gameboard(String[][] slots){

        for(int i=0; i<3; i++){
            System.out.println("-------");
            for(int j=0; j<3; j++){
                System.out.print("|" + slots[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------");

    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to TicTacToe\n\n");   

        String[][] boardSlots = new String[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(boardSlots[i][j] == null) {
                    boardSlots[i][j] = " ";
                }
            }
        }

        Gameboard(boardSlots);

        
        //boolean continueGame = true;

       /* while(continueGame){

            //create gameboard method



            Scanner sc = new Scanner(System.in);

            System.out.println("Would you like to play again? (y/n):");
            String userResponse = sc.nextLine();

            switch(userResponse){
                case "y":
                    continueGame = true;
                    break;
                case "n":
                    continueGame = false;
                    break;
                default:
                    while(!userResponse.equals("y") && !userResponse.equals("n")){
                        System.out.println("Please select either y or n");
                        userResponse = sc.nextLine();

                        if(userResponse.equals("y")){
                            continueGame = true;
                        }

                        if(userResponse.equals("n")){
                            continueGame = false;
                        }
                    }

            }
            

            

        }

        */

    }
}