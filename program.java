import java.util.Scanner;
import java.util.Arrays;

public class Program {

    public static void Gameboard(String[][] slots){

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(slots[i][j] == null) {
                    slots[i][j] = " ";
                }
            }
        }

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

    public static void UpdateGameboard(String[][] slots, String marker, int row, int column){

        slots[row][column] = marker;

    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to TicTacToe\n\n");   

        Scanner sc = new Scanner(System.in);
        String[][] boardSlots = new String[3][3];

        Gameboard(boardSlots);

        System.out.println("\n\n");
        
        // System.out.print("Which marker do you want to be? (x/o): ");
        // String marker = sc.next();

        //testing
        String marker = "x";
        int row = 1;
        int column = 1;


        UpdateGameboard(boardSlots, marker, row, column);
        Gameboard(boardSlots);






        
        //UpdateGameboard(boardSlots);

        
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