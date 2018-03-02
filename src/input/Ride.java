package input;

public class Ride {

    public int originalNumber;
    public int startRow;
    public int startColumn;
    public int endRow;
    public int endColumn;
    public int start;
    public int end;


    public boolean available = true;

    public Boolean couldBeStartedAtTime;

    public String toString() {
        return startRow + " " + startColumn + "    " + endRow + " " + endColumn + "   " + start + " " + end + "     " + length();
    }

    public int distanceToStartPoint() {
        return startRow + startColumn;
    }

    public int startedAtTimeBonus() {
        if (couldBeStartedAtTime != null && couldBeStartedAtTime) {
            return 10;
        }
        return 0;
    }

    public int length() {
        return Math.abs(startRow - endRow) + Math.abs(startColumn - endColumn);
    }

}
