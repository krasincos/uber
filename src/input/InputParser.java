package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputParser {

    public static Input parse(String filename) throws FileNotFoundException {
        Input input = new Input();
        Scanner scanner = new Scanner(new File(filename));

        String[] firstLine = scanner.nextLine().split(" ");
        input.rows = Integer.valueOf(firstLine[0]);
        input.columns = Integer.valueOf(firstLine[1]);
        input.vehicles = Integer.valueOf(firstLine[2]);
        input.ridesNumber = Integer.valueOf(firstLine[3]);
        input.bonus = Integer.valueOf(firstLine[4]);
        input.steps = Integer.valueOf(firstLine[5]);

        int i = 0;
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            Ride ride = new Ride();
            ride.originalNumber = i++;
            ride.startRow = Integer.valueOf(line[0]);
            ride.startColumn = Integer.valueOf(line[1]);
            ride.endRow = Integer.valueOf(line[2]);
            ride.endColumn = Integer.valueOf(line[3]);
            ride.start = Integer.valueOf(line[4]);
            ride.end = Integer.valueOf(line[5]);
            input.rides.add(ride);
        }

        return input;
    }




}
