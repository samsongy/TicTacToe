import java.util.Scanner;

public class Program {

    public static void Gameboard(){







        for(int i=0; i<3; i++){
            System.out.println("-------");
            for(int j=0; j<4; j++){
                System.out.print("| ");

            }
            System.out.println();
        }
        System.out.println("-------");




    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to TicTacToe\n\n");   

        Gameboard();
        
        boolean continueGame = true;

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