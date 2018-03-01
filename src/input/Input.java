package input;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public int rows;
    public int columns;
    public int vehicles;
    public int ridesNumber;
    public int bonus;
    public int steps;
    public List<Ride> rides = new ArrayList<>();

    @Override
    public String toString() {
        return "Input{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", vehicles=" + vehicles +
                ", ridesNumber=" + ridesNumber +
                ", bonus=" + bonus +
                ", steps=" + steps +
                ", rides=" + rides +
                '}';
    }
}
