import java.util.Scanner;
import java.util.Arrays;

public class Program {

    public static void PrintGameboard(String[][] slots){

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

    public static String UserMarker(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Select your game marker (x/o): ");
        String marker = sc.next();

        while(!marker.equals("x") && !marker.equals("o")){
            System.out.print("Please select a valid game marker (x/o): ");
            marker = sc.next();
        }

        return marker;

    }

    public static String CompMarker(String userMarker){
        String compMove = null;
        
        if(userMarker.equals("x")){
            compMove = "o";
        }

        if (userMarker.equals("o")){
            compMove = "x";
        }


        return compMove;

    }


    public static int[] PlayerMove(int[] coordinates){

        Scanner sc = new Scanner(System.in);


        System.out.print("\n\nSelect the horizontal coordinate (1, 2, 3): ");
        coordinates[0] = sc.nextInt() - 1;

        while (coordinates[0] > 2 || coordinates[0] < 0) {
            System.out.print("Please select 1, 2, or 3: ");
            coordinates[0] = sc.nextInt() - 1;
        }

        System.out.print("Select the vertical coordinate (1, 2, 3): ");
        coordinates[1] = sc.nextInt() - 1;

        while (coordinates[1] > 2 || coordinates[1] < 0) {
            System.out.print("Please select 1, 2, or 3: ");
            coordinates[1] = sc.nextInt() - 1;
        }


        return coordinates;
    
    }

    //create coin toss method to figure out who goes first
    //create a comp move method 
    //create a player move method


    

    public static void main(String[] args) {
        System.out.println("\nWelcome to TicTacToe\n");   

        // Scanner sc = new Scanner(System.in);
        // String[][] boardSlots = new String[3][3];

        // PrintGameboard(boardSlots);
        
        // System.out.print("\nWhich marker do you want to be? (x/o): ");

        // String userMarker = UserMarker();
        // String compMarker = CompMarker(userMarker);

        


        int[] coordinates = new int[2];
        coordinates = PlayerMove(coordinates);

        int column = coordinates[0];
        int row = coordinates[1];

        System.out.println("column: " + column);
        System.out.println("row: " + row);

        //need to pass value of methods to variables in main










        
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