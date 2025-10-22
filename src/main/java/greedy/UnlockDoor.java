package greedy;

public class UnlockDoor {
    public static void main(String[] args) {
        int[] currentSequence = {3, 6, 5, 8};
        int[] doorSequence = {9, 2, 4, 0};
        System.out.println(unlockDoor(currentSequence, doorSequence));
    }

    private static int unlockDoor(int[] currentSequence, int[] doorSequence) {
        int countSteps = 0;
        for (int i = 0; i < currentSequence.length; i++) {
            int min = Math.min(currentSequence[i], doorSequence[i]);
            int max = Math.max(currentSequence[i], doorSequence[i]);
            int anticlockwise = max - min;
            int clockwise = (min + 10) - max;

            countSteps += Math.min(clockwise, anticlockwise);
        }

        return countSteps;
    }
}
