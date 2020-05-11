import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("\nWelcome to TicTacToe\n\n");   
        
        boolean continueGame = true;

        while(continueGame){


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

    }
}