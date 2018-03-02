import input.Input;
import input.InputParser;
import input.Ride;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solver {

    private static final Comparator<Ride> CLOSEST_TO_START = (o1, o2) -> (o1.startRow + o1.startColumn - o1.start + o1.startedAtTimeBonus() - o2.startRow - o2.startColumn + o2.start - o2.startedAtTimeBonus());

    private Input map;

    public void solve() throws FileNotFoundException {
        // 3 4 2 3 2 10
        // 0 0 1 3 2 9
        // 1 2 1 0 0 9
        // 2 0 2 2 0 9

        Input map = InputParser.parse("e_high_bonus.in");
//        map.columns = 3;
//        map.rows = 4;
//        map.vehicles = 2;
//        map.ridesNumber = 3;
//        map.steps = 10;
        this.map = map;

//        List<Ride> rides = new ArrayList<>();
//        rides.add(ride(0, 0, 1, 3, 2, 9, 0));
//        rides.add(ride(1, 2, 1, 0, 0, 9, 1));
//        rides.add(ride(2, 0, 2, 2, 0, 9, 2));

        List<Ride> rides = map.rides;
        fillCouldBeStartedAtTime(rides);

        for (int i = 0; i < map.vehicles; i++) {
//            System.out.println("Car " + i);
            if (rides.isEmpty()) {
                break;
            }
            Ride firstRide = closestToStart(rides);
            nextRide(0, firstRide, rides, 1);
        }

    }

    public void nextRide(int moment, Ride currentRide, List<Ride> rides, int ridesCount) {

        if (currentRide.start > moment)
            moment = currentRide.start;


        moment += currentRide.length();

        if (moment < map.steps) {
            System.out.print(currentRide.originalNumber);
            System.out.print(" ");

            rides.remove(currentRide);

            if (rides.isEmpty()) {
//                System.out.print(currentRide.originalNumber + " ");
                System.out.println(" " + ridesCount);
                return;
            }

            BestNextRideComparator bestNextRideComparator = new BestNextRideComparator(currentRide, moment);
            rides.sort(bestNextRideComparator);

            Ride nextRide = rides.get(0);

            int distanceToThisRide = Math.abs(currentRide.endRow - nextRide.startRow) + Math.abs(currentRide.endColumn - nextRide.startColumn);
            int waitingBeforeStart = moment + distanceToThisRide;

            //TODO: moment after end?

//            if (moment + distanceToThisRide + nextRide.length() + waitingBeforeStart > map.steps) {
//                return;
//            }
            moment += distanceToThisRide;
//            System.out.print(nextRide.originalNumber + " ");
            nextRide(moment, nextRide, rides, ridesCount + 1);
        } else {
            System.out.print(" ");
            System.out.print((ridesCount - 1));
            System.out.println();
        }
    }

    private class BestNextRideComparator implements Comparator<Ride> {
        private Ride currentRide;
        private int moment;

        public BestNextRideComparator(Ride currentRide, int moment) {
            this.currentRide = currentRide;
            this.moment = moment;
        }

        @Override
        public int compare(Ride o1, Ride o2) {
            //TODO: probably invert
            return -score(o1) + score(o2);
        }

        private int score(Ride ride) {
            if (ride == currentRide) {
                return -100;
            }
            if (!ride.available) {
                return -100;
            }
            int distanceToThisRide = Math.abs(currentRide.endRow - ride.startRow) + Math.abs(currentRide.endColumn - ride.startColumn);
            int momentThisRideWillEnd = moment + distanceToThisRide + ride.length();
            if (momentThisRideWillEnd > map.steps || momentThisRideWillEnd > ride.end) {
                return -100;
            }
            int waitingBeforeStart = moment - ride.start - distanceToThisRide;
            return -distanceToThisRide - waitingBeforeStart;
        }
    }

    private void fillCouldBeStartedAtTime(List<Ride> rides) {
        for (Ride ride : rides) {
            if (ride.distanceToStartPoint() > ride.start)
                ride.couldBeStartedAtTime = false;
        }
    }

    private Ride closestToStart(List<Ride> rides) {
        rides.sort(CLOSEST_TO_START);
        for (Ride ride : rides) {
//            System.out.println(ride);
        }
        return rides.get(0);
    }

    private Ride ride(int startRow, int startColumn, int endRow, int endColumn, int start, int end, int originalNumber) {
        Ride ride = new Ride();
        ride.startRow = startRow;
        ride.startColumn = startColumn;

        ride.endRow = endRow;
        ride.endColumn = endColumn;

        ride.start = start;
        ride.end = end;

        ride.originalNumber = originalNumber;
        return ride;
    }
}