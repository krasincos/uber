import input.Input;
import input.InputParser;
import input.Ride;
import output.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("111"));
        int n = 350;
        List<String[]> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.nextLine().split(" "));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)[list.get(i).length - 1] + " ");
            for (int j = 0; j < list.get(i).length - 1; j++) {
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println();
        }
        int count = n - list.size();
        if (list.size() < n) {
            while (count != 0) {
                System.out.println(0);
                count--;
            }
        }


        // new Solver().solve();
    }

}
