package CS2020.assignment1.game;
import java.util.InputMismatchException;
import java.util.Scanner;


public class RunGame {//runs game

    public static void main(String[]args){
        int numberOfColumns = Integer.parseInt(args[1]);
        int numberOfRows = Integer.parseInt(args[0]);
        int numberOfShips = Integer.parseInt(args[2]);
        Game testGame = new Game(numberOfRows, numberOfColumns, numberOfShips);
        //Game testGame = new Game(4, 4, 1);
        try{
        Scanner start_game = new Scanner(System.in);
        
        do {
        System.out.println("Enter the position you would like to attack\n"+"type 'exit' to stop game\n");
        String input_game = start_game.nextLine();//x,y
        testGame.playRound(input_game);
        //System.out.println(testGame.checkVictory());//test 
        } while(testGame.checkVictory() == false);// checkVictory only equals false when all ships are destroyed
        } catch (InputMismatchException ex){
            System.out.println(ex + "Incorrect Input");
        }
        
        
    }
}