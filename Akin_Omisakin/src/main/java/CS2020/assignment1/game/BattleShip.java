package CS2020.assignment1.game;

import java.util.Random;


public class BattleShip extends AbstractBattleShip {
    
    public BattleShip(String name) {
        this.name = name; //set name
        setShipOrientation();//call method to randomise
    }
    public String getName(){//gets name
        return name;
    }
    public String getShipOrientation(){//get shipOrientation
        return shipOrientation;
    }
    public void setShipOrientation(){//random between vertical and horizontal

        int Rand = new Random().nextInt(2);//generate random number between 0-1
        if (Rand < 1){
            shipOrientation="vertical";
        } else {
            shipOrientation="horizontal";
        }

    }

    public int getHits() {//gets hits
        return hits;
    }
    

    public int[][] getShipCoordinates() {// get coordinates
        return shipCoordinates;
    }

    
    public void setHits(int numberOfHits) {// set numberOfHits
        this.hits = 0;//default  =0
        this.hits += numberOfHits;
    }

    public void setShipCoordinates(int [][] coordinates) {//sets ship coordinates
        this.shipCoordinates =  coordinates; // coordinates = {{1,2}}

    }

    public boolean checkAttack(int row,int column){ // checks if x,y equal a hit
        boolean alive = false; 
        int i,j;
        for (i=0;i<shipCoordinates.length;i++){
            for(j=0;j<shipCoordinates[i].length;j++){
                if (shipCoordinates[0][0]==row && shipCoordinates[0][1]==column){ 
                    if (this.hits < 3){
                        alive = true;
                        this.hits++;// increase by 1 does not increase hits if ships already hit
                        return alive;
                    } else {

                        alive = false;
                        
                    }
                } else {
                    
                    return alive;
                }
            }
            
        }
        return alive;
    }
        
}

