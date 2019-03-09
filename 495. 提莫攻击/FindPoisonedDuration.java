public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        if (timeSeries.length == 0)
            return 0;
        for (int i = 1; i < timeSeries.length; i++) {
            result += timeSeries[i] - timeSeries[i - 1] >= duration ? duration : timeSeries[i] - timeSeries[i - 1];
        }
        result += duration;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindPoisonedDuration().findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
