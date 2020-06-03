import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class program {

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

    public static void SetPlayerMove(int[] coordinates, String[][] slots, String marker){
        Scanner sc = new Scanner(System.in);

        boolean endOfMove = false;

        while(!endOfMove) {
            System.out.print("\nSelect the vertical coordinate (1, 2, 3): ");
            coordinates[0] = sc.nextInt() - 1;

            while (coordinates[0] > 2 || coordinates[0] < 0) {
                System.out.print("Please select 1, 2, or 3: ");
                coordinates[0] = sc.nextInt() - 1;
            }

            System.out.print("Select the horizontal coordinate (1, 2, 3): ");
            coordinates[1] = sc.nextInt() - 1;

            while (coordinates[1] > 2 || coordinates[1] < 0) {
                System.out.print("Please select 1, 2, or 3: ");
                coordinates[1] = sc.nextInt() - 1;
            }

            if(slots[coordinates[0]][coordinates[1]] != " ") {
                System.out.println("\nSpace is already filled, pick another spot");
            } else {
                endOfMove = true;
            }

        }

        slots[coordinates[0]][coordinates[1]] = marker;

        System.out.println("\nPlayer Move: ");
    }

    public static void SetComputerMove(String computerMarker, String[][] slots){

        Random rand = new Random();
        int x = rand.nextInt(3);
        int y = rand.nextInt(3);

        if(slots[x][y] != " "){
            while(slots[x][y] != " "){
                x = rand.nextInt(3);
                y = rand.nextInt(3);
            }  
        }

        slots[x][y] = computerMarker;

        System.out.println("\nComputer Move: ");

    }

    public static boolean CheckForWinner(String marker, String[][] gameBoard){
        
        boolean winner = false;

        int row = 0;
        int column = 0;

        //diagonals
        if(gameBoard[row][column].equals(marker) && gameBoard[row + 1][column + 1].equals(marker) && gameBoard[row + 2][column + 2].equals(marker)){
            winner = true;
        } else if(gameBoard[row][column + 2].equals(marker) && gameBoard[row + 1][column + 1].equals(marker) && gameBoard[row + 2][column].equals(marker)){
            winner = true;
        }

        //rows
        if(gameBoard[row][column].equals(marker) && gameBoard[row][column + 1].equals(marker) && gameBoard[row][column + 2].equals(marker)){
            winner = true;
        } else if(gameBoard[row + 1][column].equals(marker) && gameBoard[row + 1][column + 1].equals(marker) && gameBoard[row + 1][column + 2].equals(marker)){
            winner = true;
        } else if(gameBoard[row + 2][column].equals(marker) && gameBoard[row + 2][column + 1].equals(marker) && gameBoard[row + 2][column + 2].equals(marker)){
            winner = true;
        }

        //columns
        if(gameBoard[row][column].equals(marker) && gameBoard[row + 1][column].equals(marker) && gameBoard[row + 2][column].equals(marker)){
            winner = true;
        } else if(gameBoard[row][column + 1].equals(marker) && gameBoard[row + 1][column + 1].equals(marker) && gameBoard[row + 2][column + 1].equals(marker)){
            winner = true;
        } else if(gameBoard[row][column + 2].equals(marker) && gameBoard[row + 1][column + 2].equals(marker) && gameBoard[row + 2][column + 2].equals(marker)){
            winner = true;
        }


        return winner;

    }


    public static boolean CoinToss(){
        boolean userTurn= true;
        
        Random rand = new Random();
        int coinToss = rand.nextInt(2);

        if(coinToss == 0){
            System.out.println("\nYou lost the coin toss, you move second");
            userTurn = false;
        }

        if(coinToss == 1){
            System.out.println("\nYou won the coin toss, you move first");
            userTurn = true;
        }

        return userTurn;
    }

     


    public static void main(String[] args) {

        System.out.println("\nWelcome to TicTacToe");   

        int tieCounter = 0;
        int userWins = 0;
        int compWins = 0;
       

        boolean continueGame = true;
        while(continueGame){

            Scanner sc = new Scanner(System.in);
            String[][] boardSlots = new String[3][3];


            //Game setup
            CleanGameboard(boardSlots);
            PrintGameboard(boardSlots);
            
            String userMarker = SetUserMarker();
            String compMarker = SetCompMarker(userMarker);

            boolean userTurn = CoinToss();



            //Game start (put in method)
            boolean winner = false;
            String winnerMarker = null;
                        
            if(userTurn) {
                int moveNumber = 0;
                while(!winner && moveNumber < 9){
                    int[] coordinates = new int[2];
    
                    //player move
                    SetPlayerMove(coordinates, boardSlots, userMarker);
                    PrintGameboard(boardSlots);
                    winner = CheckForWinner(userMarker, boardSlots); 
                    if(winner) {
                        winnerMarker = userMarker;
                    }

                    moveNumber++;

                    //computer move
                    if(!winner && moveNumber < 9) {
                        SetComputerMove(compMarker, boardSlots);
                        PrintGameboard(boardSlots);
                        winner = CheckForWinner(compMarker, boardSlots); 
                        if(winner) {
                            winnerMarker = compMarker;
                        }

                        moveNumber++;
                    }
                    
                }
                

            } else {    
                int moveNumber = 0;
                while(!winner && moveNumber < 9){
                    int[] coordinates = new int[2];

                    SetComputerMove(compMarker, boardSlots);
                    PrintGameboard(boardSlots);
                    winner = CheckForWinner(compMarker, boardSlots);
                    if(winner) {
                        winnerMarker = compMarker;
                    }

                    moveNumber++;

                    if(!winner && moveNumber < 9){
                        SetPlayerMove(coordinates, boardSlots, userMarker);
                        PrintGameboard(boardSlots);
                        winner = CheckForWinner(userMarker, boardSlots); 
                        if(winner) {
                            winnerMarker = userMarker;
                        }

                        moveNumber++;
                    }
                
                }
                
            }


            //put in method
            if(winner){
                //print winner, add to win counter
                if(winnerMarker.equals(compMarker)){
                    System.out.println("\nYou lose...");
                    compWins++;
                } else if(winnerMarker.equals(userMarker)) {
                    System.out.println("\nYou win!!!");
                    userWins++;
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("\nTie");
                tieCounter++;

            }


            

                
            

        

            //game end (put in method)
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

        System.out.println("\nResults:\nPlayer Wins: " + userWins + "\nComputer Wins: " + compWins + "\nTies: " + tieCounter);   
        System.out.println("\nThanks for Playing! :)");   
    }
}