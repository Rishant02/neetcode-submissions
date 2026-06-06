class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // TC: O(n * log(maxPile))
        // SC: O(1)

        // Search space:
        // min possible speed = 1
        // max possible speed = largest pile
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        // Largest pile size is always a valid answer.
        int result = right;

        while (left <= right) {
            int speed = left + (right - left) / 2;

            // Total hours needed if Koko eats at 'speed'
            long hours = 0;

            for (int pile : piles) {
                // ceil(pile / speed)
                hours += (pile + speed - 1) / speed;
            }

            if (hours <= h) {
                // Current speed works.
                // Try to find a smaller valid speed.
                result = speed;
                right = speed - 1;

            } else {
                // Too slow, need a higher speed.
                left = speed + 1;
            }
        }

        return result;
    }
}