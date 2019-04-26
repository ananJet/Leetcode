import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
//            ��ǰ�����бȵ�ǰ��С����
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res)
                res = dp[i];
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        /**
         dp[i]: ���г���Ϊi+1�ĵ�����������, ��С���Ǹ�����β��.
         �ɶ���֪dp�����Ȼ��һ����������, ������ maxL ����ʾ����������еĳ���.
         ��������е���, �����ж�ÿ����num�������dp������Ӧ��λ��:
         1. num > dp[maxL], ��ʾnum��������֪�������е�β������, ��num�����dp
         ����β��, ������������г���maxL��1
         2. dp[i-1] < num <= dp[i], ֻ������Ӧ��dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // ���ַ�����, Ҳ���Ե��ÿ⺯����binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

    public static void main(String[] args) {
        new LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
