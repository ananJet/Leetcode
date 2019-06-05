public class ReachNumber {
    public int reachNumber(int target) {
        if (target == 0)
            return 0;
        target = Math.abs(target);
        int times = 1;
        int sum = 0;
        while (true) {
            sum += times;
            if (sum == target) {
                return times;
            }else if (sum > target && ((sum - target) & 1) == 0) {
                return times - 1;
            }
            times++;
        }
    }
}
