package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid {

    public PlayerGameGrid (int width, int height, int numberOfShips){
        super(width, height, numberOfShips);
        gameGrid = new String[width][height];
        
    }

    public void printGrid(){
        // prints the grid in rows rather than list
        for(int i = 0;i < gameGrid.length;i++){
            for(int j=0; j<gameGrid[i].length;j++){
                System.out.print(gameGrid[i][j] + " "); // prints everything
            }
            System.out.println();
          
        }
        System.out.println();
        
    }
    
}
/**/