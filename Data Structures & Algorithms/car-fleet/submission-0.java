class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Idea:
        // A car fleet is determined by arrival time at the target.
        // If a car behind reaches the target earlier than a car ahead,
        // it will catch up before the target and become part of that fleet.

        int n = position.length;

        // Store cars as [position, speed]
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        // Process cars from closest to target -> farthest.
        // This lets us determine whether the current car can catch
        // the fleet directly in front of it.
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;

        // Arrival time of the fleet immediately ahead.
        // Think of this as the "slowest time" that the current car
        // must beat to form its own fleet.
        double fleetTime = 0;

        for (int[] car : cars) {

            // Time needed for this car to reach target alone.
            double time = (double) (target - car[0]) / car[1];

            // If this car arrives later than the fleet ahead,
            // it cannot catch that fleet -> forms a new fleet.
            if (time > fleetTime) {
                fleets++;
                fleetTime = time;
            }

            // Otherwise:
            // time <= fleetTime
            // This car catches up to the fleet ahead before target,
            // so it becomes part of that fleet.
            // We do NOT update fleetTime because the merged fleet
            // travels at the slower fleet's pace.
        }

        return fleets;
    }
}