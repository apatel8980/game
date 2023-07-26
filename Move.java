/**
 * The Move class contains the computer move and human player input
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Move {

    private int min = 0;
    private int max = 6;

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public double getComputerMove() {

        //get random number between 0 & 6
        return Math.random()*(max-min+1)+min;
    }

    public String getUserInput(){
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){

        }
        return toReturn;
    }
}