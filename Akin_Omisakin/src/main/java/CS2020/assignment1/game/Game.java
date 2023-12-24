package CS2020.assignment1.game;
import java.util.Random;

public class Game implements GameControls{
    // added fields to make it easier
    PlayerGameGrid pGrid;
    OpponentGameGrid opGrid;
    String hit ="X";
    String miss = "%";
    String ship = "*";
    String water = ".";
  
    public Game(int numberOfRows, int numberOfColumns, int numberOfShips) {
        // create and initialize the player and opponent grids
        pGrid = new PlayerGameGrid(numberOfRows, numberOfColumns, numberOfShips);
        opGrid = new OpponentGameGrid(numberOfRows, numberOfColumns, numberOfShips);
        pGrid.initializeGrid();
        opGrid.initializeGrid();
        pGrid.generateShips(numberOfShips);
        opGrid.generateShips(numberOfShips);
        for(int i = 0; i < pGrid.ships.length; i++){
            pGrid.placeShip(pGrid.ships[i]);
        }
        for(int i = 0; i < opGrid.ships.length; i++){
            opGrid.placeShip(opGrid.ships[i]);
        }
    }

    public AbstractGameGrid getPlayersGrid(){// get PlayerGameGrid object
        return pGrid;
    }
    public AbstractGameGrid getOpponentssGrid(){//get OpponentGameGrid object
        return opGrid;
    }
    public boolean checkVictory(){ //checks if all ships are destroyed
        boolean win = false;
        boolean lost = false;
        String Victory = "You have won!";
        String Lose = "You have lost!";
        for(int i = 0; i < pGrid.ships.length; i++){
            if (getOpponentssGrid().ships[i].getHits() == 3){// if you destroyed all opponent ships
                win = true;
                System.out.println(opGrid.ships[i].name + " is destroyed");
                if (win = true){
                    System.out.println(Victory);
                }
                
            } else if(getPlayersGrid().ships[i].getHits() == 3){// if opponent destroys all your ships
                lost = true;
                System.out.println(pGrid.ships[i].name + " is destroyed");
                if (lost  = true){
                    System.out.println(Lose);
                }
                
            } else {
                win = false;
                lost = false;
            }
            
            
      
        } 
        return win || lost;//return lost or win if either are true
    }
    public void playRound (String input){// prints grid to terminal
        int i =0;
        //after coordinates input
        String localString = input.toString().trim();
        exitGame(localString);
        System.out.println("Player is Attacking");
        String[] coordinates = localString.split(",",0);// split input "x,y" into {x,y}
        int x = Integer.parseInt(coordinates[0]);// input -> int
        int y = Integer.parseInt(coordinates[1]);// input -> int

        //player hit or miss
        while(i < opGrid.ships.length){
            // ships length varries on main input
            if (opGrid.ships[i].shipCoordinates[0][0] == x && opGrid.ships[i].shipCoordinates[0][1] == y ||
            opGrid.ships[i].shipCoordinates[1][0] == x && opGrid.ships[i].shipCoordinates[1][1] == y ||
            opGrid.ships[i].shipCoordinates[2][0] == x && opGrid.ships[i].shipCoordinates[2][1] == y){

                if(opGrid.gameGrid[x][y] == "*"){

                    System.out.println("Player "+"HIT "+ opGrid.ships[i].name +"!!!");//works

                    opGrid.ships[i].setHits(opGrid.ships[i].getHits() + 1);//recieve, ++, then set
                
                    opGrid.gameGrid[x][y]=hit;

                    checkVictory();//this can be in the playround or main body
                }
                  
            } else if (opGrid.ships[i].shipCoordinates[0][0] != x && opGrid.ships[i].shipCoordinates[0][1] != y ||
                    opGrid.ships[i].shipCoordinates[1][0] != x && opGrid.ships[i].shipCoordinates[1][1] != y ||
                    opGrid.ships[i].shipCoordinates[2][0] != x && opGrid.ships[i].shipCoordinates[2][1] != y){
                        if (opGrid.gameGrid[x][y] == "."){
                            opGrid.gameGrid[x][y] = miss;
                            System.out.println("Player "+"MISS!!!");
                        }   
            }
            i++;
        }
        
        //find out where opponent's ship is
        int randX = new Random().nextInt(pGrid.gameGrid[0].length);
        int randy = new Random().nextInt(pGrid.gameGrid[0].length);
        System.out.println(randX +","+randy);
        System.out.println("Opponent is attacking");
        
        //opponent hit or miss
        int j=0;
        while(j < pGrid.ships.length){

            if (pGrid.ships[j].shipCoordinates[0][0] == randX  &&  pGrid.ships[j].shipCoordinates[0][1] == randy ||
            pGrid.ships[j].shipCoordinates[1][0] == randX  &&  pGrid.ships[j].shipCoordinates[1][1] == randy ||
            pGrid.ships[j].shipCoordinates[2][0] == randX  &&  pGrid.ships[j].shipCoordinates[2][1] == randy){

                if (pGrid.gameGrid[randX][randy] == "*"){

                    System.out.println("Opponent "+"HIT "+pGrid.ships[j].name+"!!!");

                    pGrid.ships[j].setHits(pGrid.ships[j].getHits()+ 1);

                    pGrid.gameGrid[randX][randy] = hit;
                    
                    checkVictory();
                }
            }
            else if (pGrid.ships[j].shipCoordinates[0][0] != randX && pGrid.ships[j].shipCoordinates[0][1] != randy ||
                pGrid.ships[j].shipCoordinates[1][0] != randX && pGrid.ships[j].shipCoordinates[1][1] != randy ||
                pGrid.ships[j].shipCoordinates[2][0] != randX && pGrid.ships[j].shipCoordinates[2][1] != randy){
                    if (pGrid.gameGrid[randX][randy] == "."){
                        pGrid.gameGrid[randX][randy] = miss;
                        System.out.println("Opponent "+"MISS!!!");
                    }          
            }
            j++;   
        }

					
        pGrid.printGrid();
        opGrid.printGrid();
        
    }    
    public void exitGame (String input) {//exit game if condition met
        String localString = input;
        if (localString.equals("exit")){
            System.out.println("Exiting game - thank you for playing");
            System.exit(1);
        }
        
    }
}