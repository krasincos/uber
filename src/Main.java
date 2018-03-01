import input.InputParser;

import java.io.FileNotFoundException;

public class Main {

//  R – number of rows of the grid (1 ≤ R ≤ 10000)
//● C – number of columns of the grid (1 ≤ C ≤ 10000)
//● F – number of vehicles in the fleet (1 ≤ F ≤ 1000)
//● N – number of rides (1 ≤ N ≤ 10000)
//● B – per-ride bonus for starting the ride on time (1 ≤ B ≤ 10000)
//● T – number of steps in the simulation (1 ≤ T ≤ 10 )

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input.in";
        System.out.println(InputParser.parse(filename));
    }



}
