package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputParser {

    public Input parse(String filename) throws FileNotFoundException {
        Input input = new Input();
        Scanner scanner = new Scanner(new File(filename));

        String[] firstLine = scanner.next().split(" ");




        while (scanner.hasNext()) {

        }


        return input;
    }


}
