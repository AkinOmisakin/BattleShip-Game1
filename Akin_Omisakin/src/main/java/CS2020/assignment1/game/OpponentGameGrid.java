package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid {
    
    public OpponentGameGrid (int width, int height, int numberOfShips){
        super(width, height, numberOfShips);
        gameGrid = new String[width][height];
        
    }

    public void printGrid(){

        for(int i = 0;i < gameGrid.length;i++){
            for(int j=0; j<gameGrid[i].length;j++){
                String position = gameGrid[i][j];
                if (position == "*"){
                    System.out.print("." + " "); // hides * ship
                } else{
                    System.out.print(gameGrid[i][j] + " ");
                }
            }System.out.println(); // prints row
            
        }
        
    }
}
