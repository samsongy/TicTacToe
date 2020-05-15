import java.util.Scanner;
import java.util.Arrays;

public class Program {

    public static void PrintGameboard(String[][] slots){
        System.out.println();
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

    public static void CleanGameboard(String[][] slots){

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                slots[i][j] = " ";
            }
        }
    }

    public static void UpdateGameboard(String[][] slots, String marker, int row, int column){

        slots[column][row] = marker;

    }

    public static String SetUserMarker(){

        Scanner sc = new Scanner(System.in);

        System.out.print("\nSelect your marker (x/o): ");
        String marker = sc.next();

        while(!marker.equals("x") && !marker.equals("o")){
            System.out.print("Please select a valid game marker (x/o): ");
            marker = sc.next();
        }

        return marker;
    }

    public static String SetCompMarker(String userMarker){
        String compMove = null;
        
        if(userMarker.equals("x")){
            compMove = "o";
        }

        if (userMarker.equals("o")){
            compMove = "x";
        }

        return compMove;
    }


    public static int[] GetPlayerMove(int[] coordinates){

        Scanner sc = new Scanner(System.in);

        System.out.print("\nSelect the horizontal coordinate (1, 2, 3): ");
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
    public static void main(String[] args) {

        System.out.println("\nWelcome to TicTacToe");   

        boolean continueGame = true;
        while(continueGame){

            Scanner sc = new Scanner(System.in);
            String[][] boardSlots = new String[3][3];

            CleanGameboard(boardSlots);
            PrintGameboard(boardSlots);
            
            String userMarker = SetUserMarker();
            String compMarker = SetCompMarker(userMarker);

            int[] coordinates = new int[2];
            coordinates = GetPlayerMove(coordinates);

            int row = coordinates[0];
            int column = coordinates[1];

            UpdateGameboard(boardSlots, userMarker, row, column);
            PrintGameboard(boardSlots);
        
            System.out.print("\nWould you like to play again? (y/n):");
            String userResponse = sc.next();

            switch(userResponse){
                case "y":
                    continueGame = true;
                    break;
                case "n":
                    continueGame = false;
                    break;
                default:
                    while(!userResponse.equals("y") && !userResponse.equals("n")){
                        System.out.print("Please select either y or n: ");
                        userResponse = sc.next();

                        if(userResponse.equals("y")){
                            continueGame = true;
                        }

                        if(userResponse.equals("n")){
                            continueGame = false;
                        }
                    }
            }
        }

        System.out.println("\nThanks for Playing! :)");   


        

    }
}